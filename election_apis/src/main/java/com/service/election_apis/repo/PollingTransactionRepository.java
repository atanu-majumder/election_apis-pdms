package com.service.election_apis.repo;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.service.election_apis.entity.PollingTransaction;


@Repository

public interface PollingTransactionRepository extends JpaRepository<PollingTransaction, Integer>{

	 //Optional<PollingTransaction> findByPollingStationId(Integer pollingStationId);
	//Optional<PollingTransaction>  findByPollingStationId(Integer polling_station_id);
	List<PollingTransaction> findByElectionIdAndDistrictIdAndBlockId
    (
            Integer election_id,
            Integer district_id,
            Integer blockId);
	//List<PollingTransaction> findByDistrict_id(Integer district_id);
    
	
}
