package com.service.election_apis.service;

import com.service.election_apis.dto.PollingMonitoringResponse;

public interface PollingMonitoringService {

	PollingMonitoringResponse getPollingMonitoring(
            Integer election_id,
            Integer districtId,
            Integer blockId);
}
