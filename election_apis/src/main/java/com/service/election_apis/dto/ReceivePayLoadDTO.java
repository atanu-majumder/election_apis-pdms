package com.service.election_apis.dto;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

public class ReceivePayLoadDTO {

private Integer milestoneId;

    
    private String electionId;

   
    private Integer pollingStationId;

   
    @JdbcTypeCode(SqlTypes.JSON)
    private Integer formData = 0;


	public Integer getMilestoneId() {
		return milestoneId;
	}


	public void setMilestoneId(Integer milestoneId) {
		this.milestoneId = milestoneId;
	}


	public String getElectionId() {
		return electionId;
	}


	public void setElectionId(String electionId) {
		this.electionId = electionId;
	}


	public Integer getPollingStationId() {
		return pollingStationId;
	}


	public void setPollingStationId(Integer pollingStationId) {
		this.pollingStationId = pollingStationId;
	}


	public Integer getFormData() {
		return formData;
	}


	public void setFormData(Integer formData) {
		this.formData = formData;
	}
    
    

}
