package com.service.election_apis.controller;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.config.JwtService;
import com.service.election_apis.entity.PollingTransaction;

import com.service.election_apis.service.PollingTransactionService;
import com.service.election_apis.dto.RequestResponseMsg;

import java.time.LocalDateTime;
//import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/pdms/v1/pstran")
public class PollingTransactionController {
	
	private final PollingTransactionService service;
	private final JwtService jwtService;
	
	public PollingTransactionController(PollingTransactionService service, JwtService jwtService) {

		this.service = service;
		this.jwtService = jwtService;
	}

	// =====================================================
	// GET ALL
	// =====================================================

//    @GetMapping
//    public ResponseEntity<List<PollingTransaction>>
//    getAllPollingTransactions() {
//
//        return ResponseEntity.ok(
//                service.getAllPollingTransactions()
//        );
//    }

	// =====================================================
	// GET BY POLLING STATION ID
	// =====================================================

	@GetMapping("/{pollingStationId}")
	public ResponseEntity<?> getByPollingStationId(@PathVariable Integer pollingStationId) {

		PollingTransaction transaction = service.getByPollingStationId(pollingStationId);

		if (transaction == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Polling Station ID " + pollingStationId + " not found");
		}

		return ResponseEntity.ok(transaction);
	}

	// =====================================================
	// CREATE
	// =====================================================

//	@PostMapping()
//	public ResponseEntity<PollingTransaction> createPollingTransaction(
//
//			@RequestBody PollingTransaction pollingTransaction) {
//
//		PollingTransaction saved = service.createPollingTransaction(pollingTransaction);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//	}

	@PostMapping("/save")
	public RequestResponseMsg saveOrUpdate(@RequestBody PollingTransaction pollingTransaction,
			@RequestHeader("Authorization") String authorizationHeader) {

		RequestResponseMsg requestResponseMsg = new RequestResponseMsg(0, "");//For response message
		String token = authorizationHeader.replaceFirst("(?i)^Bearer\\s+", "");
		Integer pollingStationId = jwtService.extractPollingStationId(token);
		Integer milestoneId = pollingTransaction.getMilestoneId();
		
		if(pollingTransaction.getIsPollingPartyDespatched()!=null && pollingTransaction.getIsPollingPartyDespatched()) {			
			pollingTransaction.setPolling_party_despatched_on(LocalDateTime.now());
		}
		
		if(pollingTransaction.getIsPollingPartyReached()!=null && pollingTransaction.getIsPollingPartyReached()) {			
			pollingTransaction.setPolling_party_reached_on(LocalDateTime.now());
		}
		
		if(pollingTransaction.getIsMockPollConducted()!=null && pollingTransaction.getIsMockPollConducted()) {			
			pollingTransaction.setMock_poll_conducted_on(LocalDateTime.now());
		}
		
		if(pollingTransaction.getPolling_agent_details()!=null) {
			String formDa = pollingTransaction.getPolling_agent_details().toString();
			System.out.print(formDa);
		}
		
		
		// Always use the polling station ID from the JWT
		pollingTransaction.setTran_id(0);
		pollingTransaction.setPolling_station_id(pollingStationId);
		pollingTransaction.setName_polling_station(jwtService.extractPollingStationName(token));
		
		pollingTransaction.setBlockId(jwtService.extractBlockId(token));
		pollingTransaction.setBlock_name(jwtService.extractBlockName(token));
		
		pollingTransaction.setDistrictId(jwtService.extractDistrictId(token));
		pollingTransaction.setDistrict(jwtService.extractDistrictName(token));
		
		pollingTransaction.setElectionId(jwtService.extractElectionId(token));
		pollingTransaction.setElection_name(jwtService.extractElectionName(token));
		
		pollingTransaction.setEntry_by(jwtService.extractUserId(token));
		pollingTransaction.setEntry_by_name(jwtService.extractEmpName(token));
		
		pollingTransaction.setState_code(16);
		pollingTransaction.setState_name("Tripura");
		
		pollingTransaction.setWardId(jwtService.extractWardId(token));
		pollingTransaction.setWardName(jwtService.extractWardName(token));
		
		PollingTransaction result = null;
		
		result = service.saveOrUpdate(pollingTransaction);
		if(result!=null) {
			requestResponseMsg.setStatusCode(1);
			requestResponseMsg.setMessage("Saved Successfully");
			//ResponseEntity.ok(result);
		}
		else {
			requestResponseMsg.setStatusCode(0);
			requestResponseMsg.setMessage("Error.");
		}
		return requestResponseMsg;
	}

	// =====================================================
	// UPDATE
	// =====================================================
//
//	@PutMapping("/{pollingStationId}")
//	public ResponseEntity<PollingTransaction> updatePollingTransaction(
//
//			@PathVariable Integer pollingStationId,
//
//			@RequestBody PollingTransaction pollingTransaction) {
//
//		PollingTransaction updated = service.updatePollingTransaction(pollingStationId, pollingTransaction);
//
//		return ResponseEntity.ok(updated);
//	}

}
