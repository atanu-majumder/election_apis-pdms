package com.service.election_apis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.election_apis.dto.LoginResponse;
import com.service.election_apis.dto.OtpRequest;
import com.service.election_apis.dto.VerifyOtpRequest;
import com.service.election_apis.service.AuthService;
import com.service.election_apis.service.OtpService;
import com.service.election_apis.service.AuthService;

@RestController
@RequestMapping("/pdms/v1/auth")
public class OtpController {
	
	private final OtpService otpService;
	private final AuthService authService;

    public OtpController(OtpService otpService, AuthService authService) {
        this.otpService = otpService;
        this.authService = authService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<OtpRequest> sendOtp(
            @RequestBody OtpRequest request) {

    	OtpRequest response = otpService.generateOtp(request);

        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/verify-otp")
    public ResponseEntity<LoginResponse> verifyOtp(
            @RequestBody VerifyOtpRequest request) {

        return ResponseEntity.ok(authService.verifyOtp(request));
    }

    
//    
//    @PostMapping("/verify-otp")
//    public ResponseEntity<LoginResponse> verifyOtp(
//            @RequestBody VerifyOtpRequest request) {
//
//        return ResponseEntity.ok(
//            AuthService.verifyOtp(request)
//        );
//    }

}
