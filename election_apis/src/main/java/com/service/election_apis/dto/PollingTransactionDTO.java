package com.service.election_apis.dto;

import java.time.LocalDateTime;


public class PollingTransactionDTO {

	 private Integer tranId;
	    private Integer pollingStationId;

	    private Integer electionId;
	    private String electionName;

	    private Integer districtId;
	    private String district;

	    private Integer blockId;
	    private String blockName;

	    private String lawOrderAtPs;

	    private LocalDateTime mockPollConductedOn;
	    private Boolean isPollStartedAt7am;
	    private LocalDateTime pollingPartyDespatched;
	    private LocalDateTime pollingPartyReached;
	    private LocalDateTime pollStartedAt;

	    private String stateName;
	    private Integer stateCode;

	    private Integer totalPollingAgent;

	    private String villageCommiteeName;
	    private String weatherAtPs;
	    private Integer wardId;
	    private String wardName;
	    
	    
		public Integer getTranId() {
			return tranId;
		}
		public void setTranId(Integer tranId) {
			this.tranId = tranId;
		}
		public Integer getPollingStationId() {
			return pollingStationId;
		}
		public void setPollingStationId(Integer pollingStationId) {
			this.pollingStationId = pollingStationId;
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
		public Integer getDistrictId() {
			return districtId;
		}
		public void setDistrictId(Integer districtId) {
			this.districtId = districtId;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public Integer getBlockId() {
			return blockId;
		}
		public void setBlockId(Integer blockId) {
			this.blockId = blockId;
		}
		public String getBlockName() {
			return blockName;
		}
		public void setBlockName(String blockName) {
			this.blockName = blockName;
		}
		public String getLawOrderAtPs() {
			return lawOrderAtPs;
		}
		public void setLawOrderAtPs(String lawOrderAtPs) {
			this.lawOrderAtPs = lawOrderAtPs;
		}
		
		public LocalDateTime getPollingPartyDespatched() {
			return pollingPartyDespatched;
		}
		public void setPollingPartyDespatched(LocalDateTime pollingPartyDespatched) {
			this.pollingPartyDespatched = pollingPartyDespatched;
		}
		public LocalDateTime getPollingPartyReached() {
			return pollingPartyReached;
		}
		public void setPollingPartyReached(LocalDateTime pollingPartyReached) {
			this.pollingPartyReached = pollingPartyReached;
		}
		public LocalDateTime getPollStartedAt() {
			return pollStartedAt;
		}
		public void setPollStartedAt(LocalDateTime pollStartedAt) {
			this.pollStartedAt = pollStartedAt;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		public Integer getStateCode() {
			return stateCode;
		}
		public void setStateCode(Integer stateCode) {
			this.stateCode = stateCode;
		}
		public Integer getTotalPollingAgent() {
			return totalPollingAgent;
		}
		public void setTotalPollingAgent(Integer totalPollingAgent) {
			this.totalPollingAgent = totalPollingAgent;
		}
		public String getVillageCommiteeName() {
			return villageCommiteeName;
		}
		public void setVillageCommiteeName(String villageCommiteeName) {
			this.villageCommiteeName = villageCommiteeName;
		}
		public String getWeatherAtPs() {
			return weatherAtPs;
		}
		public void setWeatherAtPs(String weatherAtPs) {
			this.weatherAtPs = weatherAtPs;
		}
		public LocalDateTime getMockPollConductedOn() {
			return mockPollConductedOn;
		}
		public void setMockPollConductedOn(LocalDateTime mockPollConductedOn) {
			this.mockPollConductedOn = mockPollConductedOn;
		}
		public Boolean getIsPollStartedAt7am() {
			return isPollStartedAt7am;
		}
		public void setIsPollStartedAt7am(Boolean isPollStartedAt7am) {
			this.isPollStartedAt7am = isPollStartedAt7am;
		}
		public Integer getWardId() {
			return wardId;
		}
		public void setWardId(Integer wardId) {
			this.wardId = wardId;
		}
		public String getWardName() {
			return wardName;
		}
		public void setWardName(String wardName) {
			this.wardName = wardName;
		}

	    
	    
}
