package com.service.election_apis.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tools.jackson.databind.JsonNode;

@Entity
@Table(name = "polling_station_vs_milestone_status", schema = "pdms")

public class PollingStationVsMilestoneStatus {

	
	    @Id
	    @Column(name = "polling_station_id", nullable = false)
	    private Integer pollingStationId;
	    
	    @Column(name="polling_station_name")
	    private String pollingStationName;

	    @Column(name = "district_id")
	    private Integer districtId;

	    @Column(name = "district_name")
	    private String districtName;

	    @Column(name = "block_id")
	    private Integer blockId;

	    @Column(name = "block_name")
	    private String blockName;

	    @Column(name = "ward_id")
	    private Integer wardId;

	    @Column(name = "ward_name")
	    private String wardName;
	    
	    @Column(name = "milestone_1")
	    private Boolean milestone1;

	    @Column(name = "milestone_2")
	    private Boolean milestone2;

	    @Column(name = "milestone_3")
	    private Boolean milestone3;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_4", columnDefinition = "json")
	    private JsonNode milestone4;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_5", columnDefinition = "json")
	    private JsonNode milestone5;

	    @Column(name = "milestone_7")
	    private Boolean milestone7;

	    @Column(name = "milestone_8")
	    private String milestone8;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_9", columnDefinition = "json")
	    private JsonNode milestone9;

	    @Column(name = "milestone_10")
	    private LocalDateTime milestone10;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_11", columnDefinition = "json")
	    private JsonNode milestone11;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_12", columnDefinition = "json")
	    private JsonNode milestone12;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_13", columnDefinition = "json")
	    private JsonNode milestone13;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_14", columnDefinition = "json")
	    private JsonNode milestone14;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_15", columnDefinition = "json")
	    private JsonNode milestone15;

	    @Column(name = "milestone_16")
	    private Integer milestone16;

	    @JdbcTypeCode(SqlTypes.JSON)
	    @Column(name = "milestone_17", columnDefinition = "json")
	    private JsonNode milestone17;

	    public PollingStationVsMilestoneStatus() {
	    }

	    public Integer getPollingStationId() {
	        return pollingStationId;
	    }

	    public void setPollingStationId(Integer pollingStationId) {
	        this.pollingStationId = pollingStationId;
	    }

	    public String getPollingStationName() {
			return pollingStationName;
		}

		public void setPollingStationName(String pollingStationName) {
			this.pollingStationName = pollingStationName;
		}

		public Integer getDistrictId() {
			return districtId;
		}

		public void setDistrictId(Integer districtId) {
			this.districtId = districtId;
		}

		public String getDistrictName() {
			return districtName;
		}

		public void setDistrictName(String districtName) {
			this.districtName = districtName;
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

		public Boolean getMilestone1() {
	        return milestone1;
	    }

	    public void setMilestone1(Boolean milestone1) {
	        this.milestone1 = milestone1;
	    }

	    public Boolean getMilestone2() {
	        return milestone2;
	    }

	    public void setMilestone2(Boolean milestone2) {
	        this.milestone2 = milestone2;
	    }

	    public Boolean getMilestone3() {
	        return milestone3;
	    }

	    public void setMilestone3(Boolean milestone3) {
	        this.milestone3 = milestone3;
	    }

	    public JsonNode getMilestone4() {
	        return milestone4;
	    }

	    public void setMilestone4(JsonNode milestone4) {
	        this.milestone4 = milestone4;
	    }

	    public JsonNode getMilestone5() {
	        return milestone5;
	    }

	    public void setMilestone5(JsonNode milestone5) {
	        this.milestone5 = milestone5;
	    }

	    public Boolean getMilestone7() {
	        return milestone7;
	    }

	    public void setMilestone7(Boolean milestone7) {
	        this.milestone7 = milestone7;
	    }

	    public String getMilestone8() {
	        return milestone8;
	    }

	    public void setMilestone8(String milestone8) {
	        this.milestone8 = milestone8;
	    }

	    public JsonNode getMilestone9() {
	        return milestone9;
	    }

	    public void setMilestone9(JsonNode milestone9) {
	        this.milestone9 = milestone9;
	    }

	    public LocalDateTime getMilestone10() {
	        return milestone10;
	    }

	    public void setMilestone10(LocalDateTime milestone10) {
	        this.milestone10 = milestone10;
	    }

	    public JsonNode getMilestone11() {
	        return milestone11;
	    }

	    public void setMilestone11(JsonNode milestone11) {
	        this.milestone11 = milestone11;
	    }

	    public JsonNode getMilestone12() {
	        return milestone12;
	    }

	    public void setMilestone12(JsonNode milestone12) {
	        this.milestone12 = milestone12;
	    }

	    public JsonNode getMilestone13() {
	        return milestone13;
	    }

	    public void setMilestone13(JsonNode milestone13) {
	        this.milestone13 = milestone13;
	    }

	    public JsonNode getMilestone14() {
	        return milestone14;
	    }

	    public void setMilestone14(JsonNode milestone14) {
	        this.milestone14 = milestone14;
	    }

	    public JsonNode getMilestone15() {
	        return milestone15;
	    }

	    public void setMilestone15(JsonNode milestone15) {
	        this.milestone15 = milestone15;
	    }

	    public Integer getMilestone16() {
	        return milestone16;
	    }

	    public void setMilestone16(Integer milestone16) {
	        this.milestone16 = milestone16;
	    }

	    public JsonNode getMilestone17() {
	        return milestone17;
	    }

	    public void setMilestone17(JsonNode milestone17) {
	        this.milestone17 = milestone17;
	    }
}
