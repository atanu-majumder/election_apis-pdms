package com.service.election_apis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.service.election_apis.dto.PollingMonitoringResponse;
import com.service.election_apis.dto.PollingStationMonitoringDTO;
import com.service.election_apis.dto.PollingTransactionDTO;
import com.service.election_apis.dto.PollingTransactionDetailsDTO;
import com.service.election_apis.dto.VoteCountDTO;
import com.service.election_apis.entity.PollingTransaction;
import com.service.election_apis.entity.PollingTransactionDetails;
import com.service.election_apis.repo.PollingTransactionDetailsRepository;
import com.service.election_apis.repo.PollingTransactionRepository;

@Service
public class PollingMonitoringServiceImpl implements PollingMonitoringService {

	private final PollingTransactionRepository pollingTransactionRepository;

	private final PollingTransactionDetailsRepository pollingTransactionDetailsRepository;

	public PollingMonitoringServiceImpl(PollingTransactionRepository pollingTransactionRepository,
			PollingTransactionDetailsRepository pollingTransactionDetailsRepository) {

		this.pollingTransactionRepository = pollingTransactionRepository;

		this.pollingTransactionDetailsRepository = pollingTransactionDetailsRepository;
	}

	@Override
	public PollingMonitoringResponse getPollingMonitoring(Integer election_Id, Integer districtId, Integer blockId) {

// -----------------------------------------
// 1. Get polling transactions
// -----------------------------------------

		List<PollingTransaction> transactions = pollingTransactionRepository
				.findByElectionIdAndDistrictIdAndBlockId(election_Id, districtId, blockId);
				//.findByDistrict_id(election_Id);

// -----------------------------------------
// 2. Prepare response
// -----------------------------------------

		PollingMonitoringResponse response = new PollingMonitoringResponse();

		response.setElectionId(election_Id);
		response.setDistrictId(districtId);
		response.setBlockId(blockId);

		response.setTotalPollingStations(transactions.size());

// No data
		if (transactions.isEmpty()) {

			response.setPollingStations(new ArrayList<>());

			return response;
		}

// -----------------------------------------
// 3. Get polling station IDs
// -----------------------------------------

		List<Integer> pollingStationIds = transactions.stream().map(PollingTransaction::getPolling_station_id).toList();

// -----------------------------------------
// 4. Get ALL details in one query
// -----------------------------------------

		List<PollingTransactionDetails> detailsList = pollingTransactionDetailsRepository
				.findByPollingStationIdIn(pollingStationIds);

// -----------------------------------------
// 5. Group details by polling station
// -----------------------------------------

		Map<Integer, List<PollingTransactionDetails>> detailsMap = detailsList.stream()
				.collect(Collectors.groupingBy(PollingTransactionDetails::getPollingStationId));

// -----------------------------------------
// 6. Build response
// -----------------------------------------

		List<PollingStationMonitoringDTO> stationList = new ArrayList<>();

		for (PollingTransaction transaction : transactions) {

			PollingStationMonitoringDTO station = new PollingStationMonitoringDTO();

			station.setPollingStationId(transaction.getPolling_station_id());

			station.setNamePollingStation(transaction.getName_polling_station());

			// -------------------------------------
			// Parent transaction
			// -------------------------------------

			PollingTransactionDTO transactionDTO = new PollingTransactionDTO();

			transactionDTO.setTranId(transaction.getTran_id());

			transactionDTO.setPollingStationId(transaction.getPolling_station_id());

			transactionDTO.setElectionId(transaction.getElectionId());

			transactionDTO.setElectionName(transaction.getElection_name());

			transactionDTO.setDistrictId(transaction.getDistrictId());

			transactionDTO.setDistrict(transaction.getDistrict());

			transactionDTO.setBlockId(transaction.getBlockId());

			transactionDTO.setBlockName(transaction.getBlock_name());

			transactionDTO.setLawOrderAtPs(transaction.getLaw_order_at_ps());

			transactionDTO.setMockPollConductedOn(transaction.getMock_poll_conducted_on());
//			transactionDTO.setMockPollConducted(transaction.getMock_poll_conducted());
//
//			transactionDTO.setPollStartedAt7am(transaction.getPoll_started_at7am());

			transactionDTO.setPollingPartyDespatched(transaction.getPolling_party_despatched_on());

			transactionDTO.setPollingPartyReached(transaction.getPolling_party_reached_on());

			transactionDTO.setPollStartedAt(transaction.getPoll_started_at());

			transactionDTO.setStateCode(transaction.getState_code());

			transactionDTO.setStateName(transaction.getState_name());

			transactionDTO.setTotalPollingAgent(transaction.getTotal_polling_agent());

			transactionDTO.setVillageCommiteeName(transaction.getVillage_commitee_name());

			transactionDTO.setWeatherAtPs(transaction.getWeather_at_ps());

			station.setPollingTransaction(transactionDTO);

			// -------------------------------------
			// Details
			// -------------------------------------

			List<PollingTransactionDetails> stationDetails = detailsMap.getOrDefault(transaction.getPolling_station_id(),
					new ArrayList<>());

//			List<PollingTransactionDetailsDTO> detailDTOList = stationDetails.stream().map(this::convertDetails)
//					.toList();

			List<PollingTransactionDetailsDTO> detailDTOList = stationDetails.stream().map(this::convertDetails)
					.toList();
			station.setPollingTransactionDetails(detailDTOList);

			stationList.add(station);
		}

		response.setPollingStations(stationList);

		return response;
	}
	
	
	
	private PollingTransactionDetailsDTO
	convertDetails(
	        PollingTransactionDetails details) {

	    PollingTransactionDetailsDTO dto =
	            new PollingTransactionDetailsDTO();

	    dto.setTranId(details.getTranId());
	    dto.setTranSubId(details.getTranSubId());
	    dto.setPollingStationId(
	            details.getPollingStationId());

	    dto.setSeatNo(details.getSeatNo());

	    dto.setVcConstituencyNo(
	            details.getVcConstituencyNo());

	    dto.setVcConstituencyName(
	            details.getVcConstituencyName());

	    dto.setElectionId(
	            details.getElectionId());

	    dto.setElectionName(
	            details.getElectionName());

	    dto.setTotFinalElectors(
	            details.getTotFinalElectors());

	    dto.setTotAssignedVoters(
	            details.getTotAssignedVoters());

	    dto.setIsPollCompletedAt16(
	            details.getIsPollCompletedAt16());

	    

	    // Vote count
	    VoteCountDTO voteCount =
	            new VoteCountDTO();

	    voteCount.setTurnout7To9(
	            details.getTournout7to9Total());

	    voteCount.setTurnout9To11(
	            details.getTournout9to11Total());

	    voteCount.setTurnout11To13(
	            details.getTournout11to13Total());

	    voteCount.setTurnout13To15(
	            details.getTournout13to15Total());

	    voteCount.setTurnout15To16(
	            details.getTournout15to16Total());

	    voteCount.setTurnoutAfter16(
	            details.getTournoutAfter16Total());

	    voteCount.setTotalVoteCast(
	            details.getTotalVoteCast());

	    voteCount.setFinalVoteCast(
	            details.getFinalVoteCast());

	    voteCount.setPercentageVote(
	            details.getPercentageVote());

	    dto.setVoteCount(voteCount);

	    return dto;
	}

}
