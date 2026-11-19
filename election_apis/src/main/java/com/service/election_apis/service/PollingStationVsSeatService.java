package com.service.election_apis.service;

import java.util.List;

import com.service.election_apis.entity.PollingStationVsSeat;

public interface PollingStationVsSeatService {
	List<PollingStationVsSeat> getByPollingStationId(
            Integer pollingStationId);

}
