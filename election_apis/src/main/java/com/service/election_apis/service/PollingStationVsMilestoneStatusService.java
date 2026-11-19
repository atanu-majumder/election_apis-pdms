package com.service.election_apis.service;

import java.util.List;

import com.service.election_apis.entity.PollingStationVsMilestoneStatus;

public interface PollingStationVsMilestoneStatusService {

	List<PollingStationVsMilestoneStatus> getAllMilestoneStatus();

    PollingStationVsMilestoneStatus getMilestoneStatusByPollingStationId(
            Integer pollingStationId);
}
