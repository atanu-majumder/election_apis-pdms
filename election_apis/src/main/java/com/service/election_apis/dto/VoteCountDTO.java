package com.service.election_apis.dto;

public class VoteCountDTO {

	
	private Integer turnout7To9;
    private Integer turnout9To11;
    private Integer turnout11To13;
    private Integer turnout13To15;
    private Integer turnout15To16;
    private Integer turnoutAfter16;

    private Long totalVoteCast;
    private Long finalVoteCast;

    private Double percentageVote;

	public Integer getTurnout7To9() {
		return turnout7To9;
	}

	public void setTurnout7To9(Integer turnout7To9) {
		this.turnout7To9 = turnout7To9;
	}

	public Integer getTurnout9To11() {
		return turnout9To11;
	}

	public void setTurnout9To11(Integer turnout9To11) {
		this.turnout9To11 = turnout9To11;
	}

	public Integer getTurnout11To13() {
		return turnout11To13;
	}

	public void setTurnout11To13(Integer turnout11To13) {
		this.turnout11To13 = turnout11To13;
	}

	public Integer getTurnout13To15() {
		return turnout13To15;
	}

	public void setTurnout13To15(Integer turnout13To15) {
		this.turnout13To15 = turnout13To15;
	}

	public Integer getTurnout15To16() {
		return turnout15To16;
	}

	public void setTurnout15To16(Integer turnout15To16) {
		this.turnout15To16 = turnout15To16;
	}

	public Integer getTurnoutAfter16() {
		return turnoutAfter16;
	}

	public void setTurnoutAfter16(Integer turnoutAfter16) {
		this.turnoutAfter16 = turnoutAfter16;
	}

	public Long getTotalVoteCast() {
		return totalVoteCast;
	}

	public void setTotalVoteCast(Long totalVoteCast) {
		this.totalVoteCast = totalVoteCast;
	}

	public Long getFinalVoteCast() {
		return finalVoteCast;
	}

	public void setFinalVoteCast(Long finalVoteCast) {
		this.finalVoteCast = finalVoteCast;
	}

	public Double getPercentageVote() {
		return percentageVote;
	}

	public void setPercentageVote(Double percentageVote) {
		this.percentageVote = percentageVote;
	}
    
    
}
