package com.service.election_apis.service;

import com.service.election_apis.dto.LoginResponse;
//import com.service.election_apis.dto.OtpRequest;
import com.service.election_apis.dto.VerifyOtpRequest;

public interface AuthService {

	//String generateOtp(OtpRequest request);
	
	LoginResponse verifyOtp(VerifyOtpRequest request);

    //LoginResponse verifyOtp(VerifyOtpRequest request);

}
