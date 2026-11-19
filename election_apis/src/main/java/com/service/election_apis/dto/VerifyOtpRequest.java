package com.service.election_apis.dto;

public class VerifyOtpRequest {

	private String mobileNo;
    private Integer otpVal;
    private String device_id;
	private String device_name;

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

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
    
    

//    public Integer getOtp() {
//        return otp;
//    }
//
//    public void setOtp(Integer otp) {
//        this.otp = otp;
//    }
}
