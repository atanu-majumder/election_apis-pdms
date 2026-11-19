package com.service.election_apis.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.service.election_apis.entity.PollingTransactionDetails;
import com.service.election_apis.entity.PollingTransactionDetailsId;

@Repository
public interface PollingTransactionDetailsRepository extends JpaRepository<PollingTransactionDetails, PollingTransactionDetailsId>{

	List<PollingTransactionDetails> findByPollingStationId(Integer pollingStationId);
	List<PollingTransactionDetails> findByPollingStationIdIn(
            List<Integer> pollingStationIds);
	
	Optional<PollingTransactionDetails> findByPollingStationIdAndSeatNo(
	        Integer pollingStationId,
	        Integer seatNo);
}
