package com.service.election_apis.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.service.election_apis.config.JwtService;
import com.service.election_apis.dto.LoginResponse;
import com.service.election_apis.dto.VerifyOtpRequest;
import com.service.election_apis.entity.OtpGeneration;
import com.service.election_apis.entity.UserDetail;
import com.service.election_apis.entity.UserJwtSession;
import com.service.election_apis.repo.OtpGenerationRepository;
import com.service.election_apis.repo.PollingStationVsSeatRepository;
import com.service.election_apis.repo.UserDetailRepository;
import com.service.election_apis.repo.UserJwtSessionRepository;
import com.service.election_apis.entity.PollingStationVsSeat;

@Service
public class AuthServiceImpl implements AuthService {

	private final OtpGenerationRepository otpGenerationRepository;
	private final UserDetailRepository userDetailRepository;
	private final JwtService jwtService;
	private final UserJwtSessionRepository userJwtSessionRepository;
	private final PollingStationVsSeatRepository pollingStationVsSeatRepository;

	public AuthServiceImpl(OtpGenerationRepository otpGenerationRepository, UserDetailRepository userDetailRepository,
			JwtService jwtService, UserJwtSessionRepository userJwtSessionRepository, PollingStationVsSeatRepository pollingStationVsSeatRepository) {

		this.otpGenerationRepository = otpGenerationRepository;
		this.userDetailRepository = userDetailRepository;
		this.jwtService = jwtService;
		this.userJwtSessionRepository = userJwtSessionRepository;
		this.pollingStationVsSeatRepository = pollingStationVsSeatRepository;
	}

	@Override
	public LoginResponse verifyOtp(VerifyOtpRequest request) {

		try {
		String mobileNo = request.getMobileNo();
		Integer otp = request.getOtpVal();
		String device_id = request.getDevice_id();
		String device_name = request.getDevice_name();

		// 1. Get latest OTP
		OtpGeneration otpGeneration = otpGenerationRepository.findTopByMobileNoAndDeviceIdOrderByGeneratedOnDesc(mobileNo, device_id)
		//		OtpGeneration otpGeneration = otpGenerationRepository.findTopByMobileNoOrderByGeneratedOnDesc(mobileNo)
				// .findTopByMobileNoOrderByOtpIdDesc(mobileNo)
				//.orElseThrow(() -> new RuntimeException("OTP not found"));
			.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "OTP not found for mobile number"));

		// 2. Verify OTP Timeout. Verify OTP expiry - 120 seconds
		OffsetDateTime generatedOn = otpGeneration.getGeneratedOn();

		if (generatedOn == null || generatedOn.plusSeconds(1000).isBefore(OffsetDateTime.now())) {

			throw new RuntimeException("OTP has expired");
		}

		// 3. Verify OTP
		if (otpGeneration.getOtpVal() == null || !otpGeneration.getOtpVal().equals(otp)) {

			throw new RuntimeException("Invalid OTP");
		}

		// 4. Get Active user
		UserDetail user = userDetailRepository.findByMobileNo(mobileNo, true)
				.orElseThrow(() -> new RuntimeException("Active user not found"));
		
		PollingStationVsSeat pollingStationVsSeat = pollingStationVsSeatRepository.findByPollingStationIdAndSeatNo(user.getPollingStationId(), 1)
				.orElseThrow(() -> new RuntimeException("Polling Station not found"));;

		// 5. Generate New JWT
		//String token = jwtService.generateToken(mobileNo, user.getPollingStationId(), user.getPollingStationName(), 
//				user.getBlockId(), user.getBlockName(), user.getElectionId(), user.getElectionName(),  
//				user.getDistrictId(), user.getDistrictName(), user.getId().intValue(), user.getEmpName(), 
//				user.getWardId(), user.getWardName());
		
		String token1 = jwtService.generateToken(mobileNo, user.getPollingStationId(), pollingStationVsSeat.getPollingStationName(), 
				pollingStationVsSeat.getBlockId(), pollingStationVsSeat.getBlockName(), pollingStationVsSeat.getElectionId(), pollingStationVsSeat.getElectionName(),  
				pollingStationVsSeat.getDistrictId(), pollingStationVsSeat.getDistrictName(), user.getId().intValue(), user.getEmpName(), 
				pollingStationVsSeat.getWardId(), pollingStationVsSeat.getWardName());
		
		// 6. Get JTI from newly generated JWT
        String jti = jwtService.extractJti(token1);

        // 7. Save/replace current JWT session
        UserJwtSession session =
                userJwtSessionRepository
                        .findById(mobileNo)
                        .orElse(new UserJwtSession());

        session.setMobileNo(mobileNo);
        session.setDeviceId(device_id);
        session.setDeviceName(device_name);
        session.setJwtJti(jti);
        session.setCreatedOn(OffsetDateTime.now());
        session.setExpiresOn(
                OffsetDateTime.now().plusHours(1)
        );
        session.setIsActive(true);

        userJwtSessionRepository.save(session);
        
     // Retrieve seats mapped to the user's polling station
        List<PollingStationVsSeat> seatMappings =
                pollingStationVsSeatRepository.findByPollingStationId(
                        user.getPollingStationId());

        // Extract seat numbers
        List<Integer> seatNos = seatMappings.stream()
                .map(PollingStationVsSeat::getSeatNo)
                .collect(Collectors.toList());
        
		// 8. Return New JWT
        LoginResponse response =  new LoginResponse(token1,
				// "Bearer",
				user.getPollingStationId(), pollingStationVsSeat.getBlockId(), pollingStationVsSeat.getElectionId(), 
				user.getEmpName(), user.getDesignation(), user.getGender(), pollingStationVsSeat.getPollingStationName(), 
				pollingStationVsSeat.getDistrictName(), pollingStationVsSeat.getBlockName(), pollingStationVsSeat.getWardId(), pollingStationVsSeat.getWardName());
        
        response.setSeatNos(seatNos);
        return response;
		
	}
	
	catch(RuntimeException pp) {
		pp.getMessage();
		return new LoginResponse(pp.getMessage(), 0,0,0, "", "", "", "", "", "", 0 ,"");
		}
	}
}