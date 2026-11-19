package com.service.election_apis.entity;

import java.time.OffsetDateTime;

import org.hibernate.annotations.Generated;
import org.hibernate.generator.EventType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "otp_generation", schema = "pdms")
public class OtpGeneration {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "otp_id")
    private Integer otpId;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "otp_val", insertable = false, updatable = false)
    @Generated(event = EventType.INSERT)
    private Integer otpVal;

    @Column(name = "generated_on", insertable = false, updatable = false)
    private OffsetDateTime generatedOn;

    @Column(name = "is_sent")
    private Integer isSent = 0;

    @Column(name = "is_resent")
    private Integer isResent = 0;
    
    @Column(name = "is_verified")
    private Integer isVerified = 0;
    
    @Column(name = "verified_on", insertable = false, updatable = false)
    private OffsetDateTime verifiedOn;
    
    @Column(name = "device_id")
    private String deviceId;
    
    @Column(name = "device_name")
    private String deviceName;
    
    
	public Integer getOtpId() {
		return otpId;
	}

	public void setOtpId(Integer otpId) {
		this.otpId = otpId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getOtpVal() {
		return otpVal;
	}

	public void setOtpVal(Integer otpVal) {
		this.otpVal = otpVal;
	}

	public OffsetDateTime getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(OffsetDateTime generatedOn) {
		this.generatedOn = generatedOn;
	}

	public Integer getIsSent() {
		return isSent;
	}

	public void setIsSent(Integer isSent) {
		this.isSent = isSent;
	}

	public Integer getIsResent() {
		return isResent;
	}

	public void setIsResent(Integer isResent) {
		this.isResent = isResent;
	}

	public Integer getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Integer isVerified) {
		this.isVerified = isVerified;
	}

	public OffsetDateTime getVerifiedOn() {
		return verifiedOn;
	}

	public void setVerifiedOn(OffsetDateTime verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

		
	
    
	
    
}
