package com.service.election_apis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "polling_station_vs_seat", schema = "pdms")
@IdClass(PollingStationVsSeatId.class)
public class PollingStationVsSeat {
	
	@Id
    @Column(
            name = "polling_station_id",
            nullable = false
    )
    private Integer pollingStationId;

    @Id
    @Column(name="seat_no", nullable = false)
    private Integer seatNo;
    
    @Column(name = "polling_station_name")
    private String pollingStationName;
	
	@Column(name = "district_id")
    private Integer districtId;

    @Column(name = "block_id", nullable = false)
    private Integer blockId;
    
    @Column(name = "district_name")
    private String districtName;
    
    @Column(name = "block_name")
    private String blockName;

    @Column(name = "vc_constituency_no")
    private Integer vcConstituencyNo;

    @Column(name = "vc_constituency_name")
    private String vcConstituencyName;
    
    @Column(name="ward_id")
    private Integer wardId;
    
    @Column(name = "ward_name")
    private String wardName;
    
    @Column(name = "polling_station_code")
    private String pollingStationCode;

    @Column(name="election_id")
    private Integer electionId;
   
    @Column(name = "election_name")
    private String electionName;
    
    

    public PollingStationVsSeat() {
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



	public String getPollingStationName() {
		return pollingStationName;
	}



	public void setPollingStationName(String pollingStationName) {
		this.pollingStationName = pollingStationName;
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



	public String getPollingStationCode() {
		return pollingStationCode;
	}



	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}



	public Integer getElectionId() {
		return electionId;
	}



	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
	}



	public String getDistrictName() {
		return districtName;
	}



	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}



	public String getBlockName() {
		return blockName;
	}



	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}



	public String getElectionName() {
		return electionName;
	}



	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}
    
    

}
