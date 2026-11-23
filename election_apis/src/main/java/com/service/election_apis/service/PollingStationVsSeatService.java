package com.service.election_apis.service;

import java.util.List;

import com.service.election_apis.entity.PollingStationVsSeat;
import com.service.election_apis.entity.PollingTransaction;

public interface PollingStationVsSeatService {
	
	List<PollingStationVsSeat> getByPollingStationId(Integer pollingStationId);
	PollingStationVsSeat getbyPollingStationIdAndseatNo(Integer pollingStationId, Integer seatNo);

}
