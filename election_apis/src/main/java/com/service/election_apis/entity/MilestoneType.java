package com.service.election_apis.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="milestone_type", schema="pdms")
public class MilestoneType {
	
    @Id
    @Column(name = "milestone_id")
    private Integer milestoneId;

    @Column(name = "milestone_type", length = 200)
    private String milestoneType;
    
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="milestone_design_desc", columnDefinition = "json")
    private String milestoneDesignDesc;
    

    public MilestoneType() {
    }

    public MilestoneType(Integer milestoneId, String milestoneType, String milestoneDesignDesc) {
        this.milestoneId = milestoneId;
        this.milestoneType = milestoneType;
        this.milestoneDesignDesc = milestoneDesignDesc;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    public String getMilestoneType() {
        return milestoneType;
    }

    public void setMilestoneType(String milestoneType) {
        this.milestoneType = milestoneType;
    }

	public String getMilestoneDesignDesc() {
		return milestoneDesignDesc;
	}

	public void setMilestoneDesignDesc(String milestoneDesignDesc) {
		this.milestoneDesignDesc = milestoneDesignDesc;
	}

    
}
