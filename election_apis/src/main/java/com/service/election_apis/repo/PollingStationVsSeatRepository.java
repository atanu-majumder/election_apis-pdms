package com.service.election_apis.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.election_apis.entity.PollingStationVsSeat;
import com.service.election_apis.entity.PollingStationVsSeatId;

@Repository
public interface PollingStationVsSeatRepository extends JpaRepository<PollingStationVsSeat, PollingStationVsSeatId>{

	List<PollingStationVsSeat> findByPollingStationId(Integer 
			pollingStationId);
	
	Optional<PollingStationVsSeat> findByPollingStationIdAndSeatNo(Integer pollingStationId, Integer seatNo);
}
