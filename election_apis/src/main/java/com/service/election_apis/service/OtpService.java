package com.service.election_apis.service;

import com.service.election_apis.dto.OtpRequest;
import com.service.election_apis.dto.VerifyOtpRequest;

public interface OtpService {

	OtpRequest generateOtp(OtpRequest  request);
	//LoginResponse verifyOtp(VerifyOtpRequest request);
}
