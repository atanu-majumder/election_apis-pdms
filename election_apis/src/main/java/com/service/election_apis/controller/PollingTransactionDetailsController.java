package com.service.election_apis.controller;




import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.config.JwtService;
import com.service.election_apis.dto.RequestResponseMsg;
import com.service.election_apis.entity.PollingTransactionDetails;
import com.service.election_apis.service.PollingTransactionDetailsService;

@RestController
@RequestMapping("/pdms/v1/pstrandet")
//@CrossOrigin(origins = "*")
public class PollingTransactionDetailsController {

	private final PollingTransactionDetailsService service;
	private final JwtService jwtService;
	
    public PollingTransactionDetailsController(PollingTransactionDetailsService service, JwtService jwtService) {

        this.service = service;
        this.jwtService = jwtService;
    }


    // =====================================================
    // CREATE
    // =====================================================

//    @PostMapping()
//    public ResponseEntity<PollingTransactionDetails> createPSDetails(@RequestBody PollingTransactionDetails details) {
//    	
////    	System.out.println(
////		        "Polling Station ID = "
////		        + details + details.getAssignedVotersDetails() + "~~" + details.getTranId() + "~~" + details.getTranSubId()
////		    );
//
//
//        PollingTransactionDetails saved = service.createPollingTransactionDetails(details);
//
////        return ResponseEntity
////                .status(HttpStatus.CREATED)
////                .body(saved);
//        
//        
//        return new ResponseEntity<>(
//                saved,
//                HttpStatus.CREATED);
//    }


    // =====================================================
    // GET ALL
    // =====================================================

//    @GetMapping
//    public ResponseEntity<List<PollingTransactionDetails>>
//    getAll() {
//
//        return ResponseEntity.ok(
//                service.getAllPollingTransactionDetails()
//        );
//    }


    // =====================================================
    // GET BY COMPOSITE ID
    // =====================================================

    @GetMapping("/{pollingStationId}/{seatNo}")
    public ResponseEntity<PollingTransactionDetails>
    getById(

            @PathVariable Integer pollingStationId,

            @PathVariable Integer seatNo) {

        return ResponseEntity.ok(
                service.getPollingTransactionDetailsById(
                        pollingStationId,
                        seatNo
                )
        );
    }



    // =====================================================
    // UPDATE
    // =====================================================

//	@PutMapping("/{pollingStationId}/{seatNo}")
//	public ResponseEntity<PollingTransactionDetails> update(
//
//			@PathVariable Integer pollingStationId,
//
//			@PathVariable Integer seatNo,
//
//			@RequestBody PollingTransactionDetails details) {
//
//		return ResponseEntity.ok(service.updatePollingTransactionDetails(pollingStationId, seatNo, details));
//	}


	@PostMapping("/save")
	public RequestResponseMsg savePoll(@RequestBody PollingTransactionDetails details,
			@RequestHeader("Authorization") String authorizationHeader) {
		
		RequestResponseMsg requestResponseMsg = new RequestResponseMsg(0, "");//For response message
		String token = authorizationHeader.replaceFirst("(?i)^Bearer\\s+", "");

		Integer pollingStationId = jwtService.extractPollingStationId(token);

		// Always use the polling station ID from the JWT
		details.setPollingStationId(pollingStationId);
		details.setNamePollingStation(jwtService.extractPollingStationName(token));
		
		details.setElectionName(jwtService.extractElectionName(token));
		
		details.setBlockId(jwtService.extractBlockId(token));
		details.setBlockName(jwtService.extractBlockName(token));
		
		details.setWardId(jwtService.extractWardId(token));
		details.setWardName(jwtService.extractWardName(token));
		
//		details.setDistrictId(jwtService.extractDistrictId(token));
//		details.setDistrict(jwtService.extractDistrictName(token));
		
		details.setElectionId(jwtService.extractElectionId(token));
		details.setElectionName(jwtService.extractElectionName(token));
		
		details.setEntryBy(jwtService.extractUserId(token));
		details.setEntryByName(jwtService.extractEmpName(token));
		
//		details.setState_code(16);
//		details.setState_name("Tripura");
		PollingTransactionDetails resultDet = null;
		resultDet = service.saveUpdateDetails(details);
		
		if(resultDet!=null) {
			requestResponseMsg.setStatusCode(1);
			requestResponseMsg.setMessage("Saved Successfully");
			//ResponseEntity.ok(result);
		}
		else {
			requestResponseMsg.setStatusCode(0);
			requestResponseMsg.setMessage("Error.");
		}
		return requestResponseMsg;
		//return ResponseEntity.ok(service.saveUpdateDetails(details));
	}
	
    // =====================================================
    // DELETE
    // =====================================================

//    @DeleteMapping("/{pollingStationId}/{vcConstituencyNo}")
//    public ResponseEntity<Void>
//    delete(
//
//            @PathVariable Integer pollingStationId,
//
//            @PathVariable Integer vcConstituencyNo) {
//
//        service.deletePollingTransactionDetails(
//                pollingStationId,
//                vcConstituencyNo
//        );
//
//        return ResponseEntity.noContent().build();
//    }
}
