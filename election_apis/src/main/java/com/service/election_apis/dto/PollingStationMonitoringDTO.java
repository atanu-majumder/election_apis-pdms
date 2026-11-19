package com.service.election_apis.dto;

import java.util.List;

public class PollingStationMonitoringDTO {

	private Integer pollingStationId;
    private String namePollingStation;

    private PollingTransactionDTO pollingTransaction;

    public Integer getPollingStationId() {
		return pollingStationId;
	}

	public void setPollingStationId(Integer pollingStationId) {
		this.pollingStationId = pollingStationId;
	}

	public String getNamePollingStation() {
		return namePollingStation;
	}

	public void setNamePollingStation(String namePollingStation) {
		this.namePollingStation = namePollingStation;
	}

	public PollingTransactionDTO getPollingTransaction() {
		return pollingTransaction;
	}

	public void setPollingTransaction(PollingTransactionDTO pollingTransaction) {
		this.pollingTransaction = pollingTransaction;
	}

	public List<PollingTransactionDetailsDTO> getPollingTransactionDetails() {
		return pollingTransactionDetails;
	}

	public void setPollingTransactionDetails(List<PollingTransactionDetailsDTO> pollingTransactionDetails) {
		this.pollingTransactionDetails = pollingTransactionDetails;
	}

	private List<PollingTransactionDetailsDTO>
            pollingTransactionDetails;
    
    
}
