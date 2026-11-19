package com.service.election_apis.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_jwt_session", schema = "pdms")
public class UserJwtSession {

	@Id
    @Column(name = "mobile_no", length = 15)
    private String mobileNo;

    @Column(name = "jwt_jti", nullable = false, length = 100)
    private String jwtJti;

    @Column(name = "created_on", nullable = false)
    private OffsetDateTime createdOn;

    @Column(name = "expires_on")
    private OffsetDateTime expiresOn;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    @Column(name = "device_id")
    private String deviceId;
    
    @Column(name = "device_name")
    private String deviceName;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getJwtJti() {
        return jwtJti;
    }

    public void setJwtJti(String jwtJti) {
        this.jwtJti = jwtJti;
    }

    public OffsetDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(OffsetDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public OffsetDateTime getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(OffsetDateTime expiresOn) {
        this.expiresOn = expiresOn;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
