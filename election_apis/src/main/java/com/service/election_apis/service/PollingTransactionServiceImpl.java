package com.service.election_apis.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.election_apis.entity.PollingTransaction;
import com.service.election_apis.repo.PollingTransactionRepository;

@Service
public class PollingTransactionServiceImpl implements PollingTransactionService{

	private final PollingTransactionRepository repository;

    public PollingTransactionServiceImpl(
            PollingTransactionRepository repository) {

        this.repository = repository;
    }


    @Override
    public List<PollingTransaction>
    getAllPollingTransactions() {
 
        return repository.findAll();
    }


    @Override
    public PollingTransaction getByPollingStationId(Integer pollingStationId) {

        return repository.findById(pollingStationId)
                .orElse(null);
    }



    @Override
    public PollingTransaction
    createPollingTransaction(
            PollingTransaction pollingTransaction) {

        LocalDateTime now = LocalDateTime.now();

        if (pollingTransaction.getTotal_polling_agent()
                == null) {

            pollingTransaction.setTotal_polling_agent(null);
        }

        return repository.save(pollingTransaction);
    }


    @Override
    public PollingTransaction updatePollingTransaction(Integer pollingStationId, PollingTransaction pollingTransaction) {

//		PollingTransaction existing = getPollingTransactionById(pollingStationId);
    	PollingTransaction existing = getByPollingStationId(pollingStationId);

		if (pollingTransaction.getName_polling_station() != null
				&& !pollingTransaction.getName_polling_station().isEmpty()) {
			existing.setName_polling_station(pollingTransaction.getName_polling_station()

			);
		}


		if (pollingTransaction.getDistrictId() != null && pollingTransaction.getDistrictId() != 0) {
			existing.setDistrictId(pollingTransaction.getDistrictId());
		}
		
		if (pollingTransaction.getDistrict() != null && !pollingTransaction.getDistrict().isEmpty()) {
			existing.setDistrict(pollingTransaction.getDistrict());
		}

		if (pollingTransaction.getState_code() != null && pollingTransaction.getState_code() != 0) {
			existing.setState_code(pollingTransaction.getState_code());
		}

		if (pollingTransaction.getState_name() != null && !pollingTransaction.getState_name().isEmpty()) {
			existing.setState_name(pollingTransaction.getState_name());
		}

		if (pollingTransaction.getBlockId() != null && pollingTransaction.getBlockId() !=0) {
			existing.setBlockId(pollingTransaction.getBlockId());
		}
		
		if (pollingTransaction.getBlock_name() != null && !pollingTransaction.getBlock_name().isEmpty()) {
			existing.setBlock_name(pollingTransaction.getBlock_name());
		}

		if (pollingTransaction.getVillage_commitee_name() != null
				&& !pollingTransaction.getVillage_commitee_name().isEmpty()) {
			existing.setVillage_commitee_name(pollingTransaction.getVillage_commitee_name());
		}

		if (pollingTransaction.getElectionId() != null && pollingTransaction.getElectionId() != 0) {
			existing.setElectionId(

					pollingTransaction.getElectionId());
		}

		if (pollingTransaction.getElection_name() != null && !pollingTransaction.getElection_name().isEmpty()) {
			existing.setElection_name(pollingTransaction.getElection_name());
		}

		if (pollingTransaction.getEntry_by() != null && pollingTransaction.getEntry_by() != 0) {
			existing.setEntry_by(pollingTransaction.getEntry_by());
		}
		
		if (pollingTransaction.getEntry_by_name() != null && !pollingTransaction.getEntry_by_name().isEmpty()) {
			existing.setEntry_by_name(pollingTransaction.getEntry_by_name());;
		}

		if (pollingTransaction.getPolling_party_despatched_on() != null
				&& !pollingTransaction.getPolling_party_despatched_on().toString().isEmpty()) {
			existing.setPolling_party_despatched_on(pollingTransaction.getPolling_party_despatched_on());
		}

		if (pollingTransaction.getPolling_party_reached_on() != null
				&& !pollingTransaction.getPolling_party_reached_on().toString().isEmpty()) {
			existing.setPolling_party_reached_on(pollingTransaction.getPolling_party_reached_on());
		}

		if (pollingTransaction.getMock_poll_conducted_on() != null
				&& !pollingTransaction.getMock_poll_conducted_on().toString().isEmpty()) {
			existing.setMock_poll_conducted_on(

					pollingTransaction.getMock_poll_conducted_on());
		}

		if (pollingTransaction.getIs_poll_started_at7am() != null //Boolean Input 
				&& !pollingTransaction.getIs_poll_started_at7am().toString().isEmpty()) {
			existing.setIs_poll_started_at7am(pollingTransaction.getIs_poll_started_at7am());
		}
		
		if (pollingTransaction.getPoll_started_at() != null
				&& !pollingTransaction.getPoll_started_at().toString().isEmpty()) {
			existing.setPoll_started_at(pollingTransaction.getPoll_started_at());
		}

		if (pollingTransaction.getWeather_at_ps() != null && !pollingTransaction.getWeather_at_ps().isEmpty()) {
			existing.setWeather_at_ps(pollingTransaction.getWeather_at_ps());
		}

		if (pollingTransaction.getLaw_order_at_ps() != null && !pollingTransaction.getLaw_order_at_ps().isEmpty()) {
			existing.setLaw_order_at_ps(pollingTransaction.getLaw_order_at_ps());
		}

		if (pollingTransaction.getPolling_agent_details() != null
				&& !pollingTransaction.getPolling_agent_details().isEmpty()) {
			existing.setPolling_agent_details(pollingTransaction.getPolling_agent_details());
		}

		if (pollingTransaction.getTotal_polling_agent() != null
				&& !pollingTransaction.getTotal_polling_agent().toString().isEmpty()) {
			existing.setTotal_polling_agent(pollingTransaction.getTotal_polling_agent());
		}
		
		if (pollingTransaction.getNo_slip_issued_after_16() != null && pollingTransaction.getNo_slip_issued_after_16() != 0) {
			existing.setNo_slip_issued_after_16(pollingTransaction.getNo_slip_issued_after_16());
		}

		return repository.save(existing);
    }

    
    
    
    // For ALL Post Method
    @Override
    public PollingTransaction saveOrUpdate(PollingTransaction pollingTransaction) {

        // Check whether record already exists
    	
    	Optional<PollingTransaction> existingRecord = repository.findById(pollingTransaction.getPolling_station_id());

    	if (existingRecord.isPresent()) {
    		
    		// UPDATE existing record
            PollingTransaction existing = existingRecord.get();

    		
		if (pollingTransaction.getName_polling_station() != null
				&& !pollingTransaction.getName_polling_station().isEmpty()) {
			existing.setName_polling_station(pollingTransaction.getName_polling_station()

			);
		}


		if (pollingTransaction.getDistrictId() != null && pollingTransaction.getDistrictId() != 0) {
			existing.setDistrictId(pollingTransaction.getDistrictId());
		}
		
		if (pollingTransaction.getDistrict() != null && !pollingTransaction.getDistrict().isEmpty()) {
			existing.setDistrict(pollingTransaction.getDistrict());
		}

		if (pollingTransaction.getState_code() != null && pollingTransaction.getState_code() != 0) {
			existing.setState_code(pollingTransaction.getState_code());
		}

		if (pollingTransaction.getState_name() != null && !pollingTransaction.getState_name().isEmpty()) {
			existing.setState_name(pollingTransaction.getState_name());
		}

		if (pollingTransaction.getBlockId() != null && pollingTransaction.getBlockId() !=0) {
			existing.setBlockId(pollingTransaction.getBlockId());
		}
		
		if (pollingTransaction.getBlock_name() != null && !pollingTransaction.getBlock_name().isEmpty()) {
			existing.setBlock_name(pollingTransaction.getBlock_name());
		}

		if (pollingTransaction.getVillage_commitee_name() != null
				&& !pollingTransaction.getVillage_commitee_name().isEmpty()) {
			existing.setVillage_commitee_name(pollingTransaction.getVillage_commitee_name());
		}

		if (pollingTransaction.getElectionId() != null && pollingTransaction.getElectionId() != 0) {
			existing.setElectionId(

					pollingTransaction.getElectionId());
		}

		if (pollingTransaction.getElection_name() != null && !pollingTransaction.getElection_name().isEmpty()) {
			existing.setElection_name(pollingTransaction.getElection_name());
		}

		if (pollingTransaction.getEntry_by() != null && pollingTransaction.getEntry_by() != 0) {
			existing.setEntry_by(pollingTransaction.getEntry_by());
		}
		
		if (pollingTransaction.getEntry_by_name() != null && !pollingTransaction.getEntry_by_name().isEmpty()) {
			existing.setEntry_by_name(pollingTransaction.getEntry_by_name());;
		}
		
		if (pollingTransaction.getIsPollingPartyDespatched() != null
				&& !pollingTransaction.getIsPollingPartyDespatched().toString().isEmpty()) {
			existing.setIsPollingPartyDespatched(pollingTransaction.getIsPollingPartyDespatched());
			if(!pollingTransaction.getIsPollingPartyDespatched()) {
				existing.setPolling_party_despatched_on(null);
			}else {
				existing.setPolling_party_despatched_on(LocalDateTime.now());
			}
		}
		
		if (pollingTransaction.getIsPollingPartyReached() != null
				&& !pollingTransaction.getIsPollingPartyReached().toString().isEmpty()) {
			existing.setIsPollingPartyReached(pollingTransaction.getIsPollingPartyReached());
			if(!pollingTransaction.getIsPollingPartyReached()) {
				existing.setPolling_party_reached_on(null);
			}else {
				existing.setPolling_party_reached_on(LocalDateTime.now());
			}
		}
		
		if (pollingTransaction.getIsMockPollConducted() != null
				&& !pollingTransaction.getIsMockPollConducted().toString().isEmpty()) {
			existing.setIsMockPollConducted(pollingTransaction.getIsMockPollConducted());
			if(!pollingTransaction.getIsMockPollConducted()) {
				existing.setMock_poll_conducted_on(null);
			}else {
				existing.setMock_poll_conducted_on(LocalDateTime.now());
			}
		}

		if (pollingTransaction.getIs_poll_started_at7am() != null
				&& !pollingTransaction.getIs_poll_started_at7am().toString().isEmpty()) {
			existing.setIs_poll_started_at7am(pollingTransaction.getIs_poll_started_at7am());
		}
		
		if (pollingTransaction.getPoll_started_at() != null
				&& !pollingTransaction.getPoll_started_at().toString().isEmpty()) {
			existing.setPoll_started_at(pollingTransaction.getPoll_started_at());
		}

		if (pollingTransaction.getWeather_at_ps() != null && !pollingTransaction.getWeather_at_ps().isEmpty()) {
			existing.setWeather_at_ps(pollingTransaction.getWeather_at_ps());
		}

		if (pollingTransaction.getLaw_order_at_ps() != null && !pollingTransaction.getLaw_order_at_ps().isEmpty()) {
			existing.setLaw_order_at_ps(pollingTransaction.getLaw_order_at_ps());
		}

		if (pollingTransaction.getPolling_agent_details() != null
				&& !pollingTransaction.getPolling_agent_details().isEmpty()) {
			existing.setPolling_agent_details(pollingTransaction.getPolling_agent_details());
		}

		if (pollingTransaction.getTotal_polling_agent() != null
				&& !pollingTransaction.getTotal_polling_agent().toString().isEmpty()) {
			existing.setTotal_polling_agent(pollingTransaction.getTotal_polling_agent());
		}
		
		if (pollingTransaction.getNo_slip_issued_after_16() != null && pollingTransaction.getNo_slip_issued_after_16() != 0) {
			existing.setNo_slip_issued_after_16(pollingTransaction.getNo_slip_issued_after_16());
		}	
		
		if (pollingTransaction.getWardId() != null && pollingTransaction.getWardId() != 0) {
			existing.setWardId(pollingTransaction.getWardId());
		}
		
		if (pollingTransaction.getWardName() != null && !pollingTransaction.getWardName().isEmpty()) {
			existing.setWardName(pollingTransaction.getWardName());;
		}
            return repository.save(existing);

        } else {

            // INSERT new record
            return repository.save(pollingTransaction);
        }
    }


}
