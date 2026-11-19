package com.service.election_apis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.entity.PollingStationVsSeat;
import com.service.election_apis.service.PollingStationVsSeatService;

@RestController
@RequestMapping("/pdms/v1/psseat")
public class PollingStationVsSeatController {

	
	private final PollingStationVsSeatService service;

    public PollingStationVsSeatController(
            PollingStationVsSeatService service) {
        this.service = service;
    }

    @GetMapping("/{pollingStationId}")
    public ResponseEntity<List<PollingStationVsSeat>> getByPollingStationId(
            @PathVariable Integer pollingStationId) {

        List<PollingStationVsSeat> result =
                service.getByPollingStationId(pollingStationId);

        return ResponseEntity.ok(result);
    }
}
