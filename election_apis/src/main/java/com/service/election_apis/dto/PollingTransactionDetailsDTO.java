package com.service.election_apis.dto;

import com.service.election_apis.entity.PollingTransactionDetails;

public class PollingTransactionDetailsDTO {

	
	private Integer tranId;
    private Long tranSubId;
    private Integer pollingStationId;

    private Integer seatNo;

    private Integer vcConstituencyNo;
    private String vcConstituencyName;

    private Integer electionId;
    private String electionName;

    private Long totFinalElectors;
    private Long totAssignedVoters;

    private VoteCountDTO voteCount;

    private Boolean isPollCompletedAt16;
    private Integer noSlipIssuedAfter16;
	public Integer getTranId() {
		return tranId;
	}
	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}
	public Long getTranSubId() {
		return tranSubId;
	}
	public void setTranSubId(Long tranSubId) {
		this.tranSubId = tranSubId;
	}
	public Integer getPollingStationId() {
		return pollingStationId;
	}
	public void setPollingStationId(Integer pollingStationId) {
		this.pollingStationId = pollingStationId;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getVcConstituencyNo() {
		return vcConstituencyNo;
	}
	public void setVcConstituencyNo(Integer vcConstituencyNo) {
		this.vcConstituencyNo = vcConstituencyNo;
	}
	public String getVcConstituencyName() {
		return vcConstituencyName;
	}
	public void setVcConstituencyName(String vcConstituencyName) {
		this.vcConstituencyName = vcConstituencyName;
	}
	public Integer getElectionId() {
		return electionId;
	}
	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}
	public String getElectionName() {
		return electionName;
	}
	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
	public Long getTotFinalElectors() {
		return totFinalElectors;
	}
	public void setTotFinalElectors(Long totFinalElectors) {
		this.totFinalElectors = totFinalElectors;
	}
	public Long getTotAssignedVoters() {
		return totAssignedVoters;
	}
	public void setTotAssignedVoters(Long totAssignedVoters) {
		this.totAssignedVoters = totAssignedVoters;
	}
	public VoteCountDTO getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(VoteCountDTO voteCount) {
		this.voteCount = voteCount;
	}
	public Boolean getIsPollCompletedAt16() {
		return isPollCompletedAt16;
	}
	public void setIsPollCompletedAt16(Boolean isPollCompletedAt16) {
		this.isPollCompletedAt16 = isPollCompletedAt16;
	}
	public Integer getNoSlipIssuedAfter16() {
		return noSlipIssuedAfter16;
	}
	public void setNoSlipIssuedAfter16(Integer noSlipIssuedAfter16) {
		this.noSlipIssuedAfter16 = noSlipIssuedAfter16;
	}

    
	
}
