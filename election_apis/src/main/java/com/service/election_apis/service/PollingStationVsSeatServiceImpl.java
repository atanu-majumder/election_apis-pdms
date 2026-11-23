package com.service.election_apis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.election_apis.entity.PollingStationVsSeat;
import com.service.election_apis.repo.PollingStationVsSeatRepository;
import com.service.election_apis.service.PollingStationVsSeatService;

@Service
public class PollingStationVsSeatServiceImpl implements PollingStationVsSeatService{

	 private final PollingStationVsSeatRepository repository;

	    public PollingStationVsSeatServiceImpl(
	            PollingStationVsSeatRepository repository) {
	        this.repository = repository;
	    }

	    @Override
	    public List<PollingStationVsSeat> getByPollingStationId(
	            Integer pollingStationId) {

	        return repository.findByPollingStationId(pollingStationId);
	    }

		@Override
		public PollingStationVsSeat getbyPollingStationIdAndseatNo(Integer pollingStationId, Integer seatNo) {
			// TODO Auto-generated method stub
			return repository.findByPollingStationIdAndSeatNo(pollingStationId, seatNo).orElse(null);
		}
}
