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
	
	@Column(name = "district_id")
    private Integer districtId;

    @Column(name = "block_id", nullable = false)
    private Integer blockId;

    @Column(name = "vc_constituency_no")
    private Integer vcConstituencyNo;

    @Column(name = "vc_constituency_name")
    private String vcConstituencyName;

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

}
