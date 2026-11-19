package com.service.election_apis.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.election_apis.entity.PollingStationVsMilestoneStatus;
import com.service.election_apis.repo.PollingStationVsMilestoneStatusRepository;
import com.service.election_apis.service.PollingStationVsMilestoneStatusService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PollingStationVsMilestoneStatusServiceImpl implements PollingStationVsMilestoneStatusService{

	private final PollingStationVsMilestoneStatusRepository repository;

    public PollingStationVsMilestoneStatusServiceImpl(
            PollingStationVsMilestoneStatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PollingStationVsMilestoneStatus> getAllMilestoneStatus() {

        return repository.findAll();
    }

    @Override
    public PollingStationVsMilestoneStatus getMilestoneStatusByPollingStationId(
            Integer pollingStationId) {

        return repository.findById(pollingStationId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Milestone status not found for polling station ID: "
                                + pollingStationId));
    }
}
