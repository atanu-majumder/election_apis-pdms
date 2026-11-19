package com.service.election_apis.dto;

import java.util.List;

public class PollingMonitoringResponse {

	
	private Integer electionId;
    private Integer districtId;
    private Integer blockId;

    private Integer totalPollingStations;

    private List<PollingStationMonitoringDTO> pollingStations;

	public Integer getElectionId() {
		return electionId;
	}

	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getBlockId() {
		return blockId;
	}

	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}

	public Integer getTotalPollingStations() {
		return totalPollingStations;
	}

	public void setTotalPollingStations(Integer totalPollingStations) {
		this.totalPollingStations = totalPollingStations;
	}

	public List<PollingStationMonitoringDTO> getPollingStations() {
		return pollingStations;
	}

	public void setPollingStations(List<PollingStationMonitoringDTO> pollingStations) {
		this.pollingStations = pollingStations;
	}
    
    
}
