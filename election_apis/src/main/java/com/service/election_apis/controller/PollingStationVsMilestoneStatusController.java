package com.service.election_apis.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.election_apis.entity.PollingStationVsMilestoneStatus;
import com.service.election_apis.service.PollingStationVsMilestoneStatusService;

@RestController
@RequestMapping("/pdms/v1/milestone-status")

public class PollingStationVsMilestoneStatusController {

	private final PollingStationVsMilestoneStatusService service;

    public PollingStationVsMilestoneStatusController(
            PollingStationVsMilestoneStatusService service) {
        this.service = service;
    }

    // Get all polling station milestone status
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllMilestoneStatus() {
//
//        List<PollingStationVsMilestoneStatus> result =
//                service.getAllMilestoneStatus();
//
//        return ResponseEntity.ok(result);
//    }

    // Get milestone status by polling station ID
    @GetMapping("/{pollingStationId}")
    public ResponseEntity<?> getMilestoneStatusByPollingStationId(
            @PathVariable Integer pollingStationId) {

        try {

            PollingStationVsMilestoneStatus result =
                    service.getMilestoneStatusByPollingStationId(
                            pollingStationId);

            return ResponseEntity.ok(result);

        } catch (jakarta.persistence.EntityNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }	
}
