package com.service.election_apis.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

//import org.springframework.boot.jackson.autoconfigure.JacksonProperties.Json;

//import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.*;
//import com.fasterxml.jackson.databind.JsonNode;
import tools.jackson.databind.JsonNode;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//import jakarta.persistence.Table;


@Entity
@Table(name = "polling_transaction", schema = "pdms")
public class PollingTransaction {

	@Column
	private Integer tran_id;
	
	@Id
	@Column(nullable = false)
	private Integer polling_station_id;
	
	@Column
    private String name_polling_station;
//	@Column
//    private Integer block_id;
	@Column
    private String block_name;
//	@Column
//    private Integer district_id;
	@Column
    private String district;
	
//	@Column(nullable = false)
//    private Integer election_id;
	
	@Column(name = "election_id", nullable = false)
	private Integer electionId;

	@Column(name = "district_id")
	private Integer districtId;

	@Column(name = "block_id")
	private Integer blockId;
		
	@Column(nullable = false)
    private String election_name;
	@Column
    private String law_order_at_ps;
	@Column
    private LocalDateTime mock_poll_conducted_on;
	
	@Column
    private Boolean is_poll_started_at7am;  //UI will have Boolean response
	
	@Column
	private LocalDateTime poll_started_at;
	
	@Column(columnDefinition = "json")
	@JdbcTypeCode(SqlTypes.JSON)
    private JsonNode polling_agent_details;
	
	@Column(name="is_polling_party_despatched")
    private Boolean isPollingPartyDespatched;
	
	@Column(name="is_polling_party_reached")
    private Boolean isPollingPartyReached;
	
	@Column
    private LocalDateTime polling_party_despatched_on;
	@Column
    private LocalDateTime polling_party_reached_on;
	
	@Column(nullable = false)
    private Integer entry_by;
	@Column
	private String entry_by_name;
	@Column
    private Integer state_code;
	@Column
    private String state_name;
	@Column
    private Integer total_polling_agent ;
    
	@Column
    private String village_commitee_name;
	@Column
    private String weather_at_ps;
	@Column
	private Integer no_slip_issued_after_16;
	
	@Column(name = "milestone_id")
	private Integer milestoneId;
	
	@Column(name = "is_mock_poll_conducted")
	private Boolean isMockPollConducted;
	
	@Column(name = "ward_id")
	private Integer wardId;
	
	@Column(name="ward_name")
	private String wardName;
	
//	@Column(name="form_data",columnDefinition = "json")
//	@JdbcTypeCode(SqlTypes.JSON)
//	private String formData;


    public PollingTransaction() {
    }



	public Integer getPolling_station_id() {
		return polling_station_id;
	}



	public void setPolling_station_id(Integer polling_station_id) {
		this.polling_station_id = polling_station_id;
	}


	public String getBlock_name() {
		return block_name;
	}


	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}


	public String getEntry_by_name() {
		return entry_by_name;
	}



	public void setEntry_by_name(String entry_by_name) {
		this.entry_by_name = entry_by_name;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



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



	public LocalDateTime getPoll_started_at() {
		return poll_started_at;
	}



	public void setPoll_started_at(LocalDateTime poll_started_at) {
		this.poll_started_at = poll_started_at;
	}



	public String getElection_name() {
		return election_name;
	}



	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}



	public String getLaw_order_at_ps() {
		return law_order_at_ps;
	}



	public void setLaw_order_at_ps(String law_order_at_ps) {
		this.law_order_at_ps = law_order_at_ps;
	}


	public String getName_polling_station() {
		return name_polling_station;
	}



	public void setName_polling_station(String name_polling_station) {
		this.name_polling_station = name_polling_station;
	}


	public JsonNode getPolling_agent_details() {
		return polling_agent_details;
	}



	public void setPolling_agent_details(JsonNode polling_agent_details) {
		this.polling_agent_details = polling_agent_details;
	}



	public Boolean getIsPollingPartyDespatched() {
		return isPollingPartyDespatched;
	}



	public void setIsPollingPartyDespatched(Boolean isPollingPartyDespatched) {
		this.isPollingPartyDespatched = isPollingPartyDespatched;
	}



	public Boolean getIsPollingPartyReached() {
		return isPollingPartyReached;
	}



	public void setIsPollingPartyReached(Boolean isPollingPartyReached) {
		this.isPollingPartyReached = isPollingPartyReached;
	}



	public LocalDateTime getPolling_party_despatched_on() {
		return polling_party_despatched_on;
	}



	public void setPolling_party_despatched_on(LocalDateTime polling_party_despatched_on) {
		this.polling_party_despatched_on = polling_party_despatched_on;
	}



	public LocalDateTime getPolling_party_reached_on() {
		return polling_party_reached_on;
	}



	public void setPolling_party_reached_on(LocalDateTime polling_party_reached_on) {
		this.polling_party_reached_on = polling_party_reached_on;
	}



	public Integer getEntry_by() {
		return entry_by;
	}



	public void setEntry_by(Integer entry_by) {
		this.entry_by = entry_by;
	}



	public Integer getTotal_polling_agent() {
		return total_polling_agent;
	}



	public void setTotal_polling_agent(Integer total_polling_agent) {
		this.total_polling_agent = total_polling_agent;
	}


	public String getWeather_at_ps() {
		return weather_at_ps;
	}



	public void setWeather_at_ps(String weather_at_ps) {
		this.weather_at_ps = weather_at_ps;
	}



	public Integer getTran_id() {
		return tran_id;
	}



	public void setTran_id(Integer tran_id) {
		this.tran_id = tran_id;
	}



	public Integer getState_code() {
		return state_code;
	}



	public void setState_code(Integer state_code) {
		this.state_code = state_code;
	}



	public String getState_name() {
		return state_name;
	}



	public void setState_name(String state_name) {
		this.state_name = state_name;
	}



	public String getVillage_commitee_name() {
		return village_commitee_name;
	}



	public void setVillage_commitee_name(String village_commitee_name) {
		this.village_commitee_name = village_commitee_name;
	}



	public Integer getNo_slip_issued_after_16() {
		return no_slip_issued_after_16;
	}



	public void setNo_slip_issued_after_16(Integer no_slip_issued_after_16) {
		this.no_slip_issued_after_16 = no_slip_issued_after_16;
	}



	public LocalDateTime getMock_poll_conducted_on() {
		return mock_poll_conducted_on;
	}



	public void setMock_poll_conducted_on(LocalDateTime mock_poll_conducted_on) {
		this.mock_poll_conducted_on = mock_poll_conducted_on;
	}



	public Boolean getIs_poll_started_at7am() {
		return is_poll_started_at7am;
	}



	public void setIs_poll_started_at7am(Boolean is_poll_started_at7am) {
		this.is_poll_started_at7am = is_poll_started_at7am;
	}



	public Integer getMilestoneId() {
		return milestoneId;
	}



	public void setMilestoneId(Integer milestoneId) {
		this.milestoneId = milestoneId;
	}



	public Boolean getIsMockPollConducted() {
		return isMockPollConducted;
	}



	public void setIsMockPollConducted(Boolean isMockPollConducted) {
		this.isMockPollConducted = isMockPollConducted;
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
