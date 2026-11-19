package com.service.election_apis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.dto.PollingMonitoringResponse;
import com.service.election_apis.service.PollingMonitoringService;

@RestController
@RequestMapping("/pdms/v1/polling-monitoring")
public class PollingMonitoringController {

	private final PollingMonitoringService pollingMonitoringService;

	public PollingMonitoringController(PollingMonitoringService pollingMonitoringService) {

		this.pollingMonitoringService = pollingMonitoringService;
	}

	@GetMapping("/{electionId}/{districtId}/{blockId}")
	public ResponseEntity<PollingMonitoringResponse> getPollingMonitoring(@PathVariable Integer electionId,
			@PathVariable Integer districtId, @PathVariable Integer blockId) {

		return ResponseEntity.ok(pollingMonitoringService.getPollingMonitoring(electionId, districtId, blockId));
	}
}
