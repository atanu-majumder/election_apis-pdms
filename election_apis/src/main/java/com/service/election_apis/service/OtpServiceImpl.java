package com.service.election_apis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.service.election_apis.dto.OtpRequest;
import com.service.election_apis.dto.VerifyOtpRequest;
import com.service.election_apis.entity.OtpGeneration;
import com.service.election_apis.entity.UserDetail;
import com.service.election_apis.repo.OtpGenerationRepository;
import com.service.election_apis.repo.UserDetailRepository;

@Service
public class OtpServiceImpl implements OtpService{

	private final UserDetailRepository userDetailRepository;
    private final OtpGenerationRepository otpGenerationRepository;
    
    @Value("${sms_url}")
    private String smsUrl;
    @Value("${sms.gateway.username}")
    private String username;
    @Value("${pin}")
    private String pin;
    @Value("${signature}")
    private String signature;
    @Value("${dlt_entity_id}")
    private String dlt_entity_id;
    
    private final RestTemplate restTemplate = new RestTemplate();

    public OtpServiceImpl(
            UserDetailRepository userDetailRepository,
            OtpGenerationRepository otpGenerationRepository) {

        this.userDetailRepository = userDetailRepository;
        this.otpGenerationRepository = otpGenerationRepository;
    }

    @Override
    public OtpRequest generateOtp(OtpRequest request) {

        String mobileNo = request.getMobileNo();
        String ret_msg = "";
        String device_id = request.getDevice_id();
        String device_name = request.getDevice_name();
        OtpRequest otpRequest = new OtpRequest();
        // Validate mobile number
        if (mobileNo == null || mobileNo.trim().isEmpty()) {
            throw new RuntimeException("Mobile number is required");
        }

        mobileNo = mobileNo.trim();

        // Check mobile number in user_detail
		Optional<UserDetail> userOptional = userDetailRepository.findByMobileNo(mobileNo, true);

		if (userOptional.isEmpty()) {
			throw new ResponseStatusException(
	                HttpStatus.BAD_REQUEST,
	                "OTP not found for mobile number");
			//ret_msg = "Mobile number is not registered";
			
		} else {
			// Generate OTP
			int otp = 100000 + (int) (Math.random() * 900000);

			// Create OTP record
			OtpGeneration otpGeneration = new OtpGeneration();

			otpGeneration.setMobileNo(mobileNo);
			// otpGeneration.setOtpVal(otp); //DB will generate
			otpGeneration.setIsSent(0);
			otpGeneration.setIsResent(0);
			otpGeneration.setDeviceId(device_id);
			otpGeneration.setDeviceName(device_name);
			// Save
			otpGenerationRepository.save(otpGeneration);
			
			ret_msg = "OTP generated successfully for ******" + mobileNo.substring(6);
		}
		 // Fetch database-generated values
        //entityManager.refresh(savedOtp);
		otpRequest.setMobileNo("******" + mobileNo.substring(6));
		otpRequest.setRet_msg(ret_msg);
		otpRequest.setDevice_id("********");
		otpRequest.setDevice_name("********");
		Integer otp_val = 0 ;
		try {
			OtpGeneration otpGeneration = otpGenerationRepository.findTopByMobileNoAndDeviceIdOrderByGeneratedOnDesc(mobileNo, device_id)
					.orElseThrow(() -> new ResponseStatusException(
		                HttpStatus.BAD_REQUEST,
		                "OTP not found for mobile number"));

			otp_val = otpGeneration.getOtpVal();

			 String dlt_template_id = "1007801688393309554", message = "";
			 message = "ULB Election 2026 - PDMS, "+ otp_val + " is your OTP for login. -SEC Tripura.";
			 HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

	            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	            body.add("username", username);
	            body.add("pin", pin);
	            body.add("message", message);
	            body.add("mnumber", mobileNo);
	            body.add("signature", signature);
	            body.add("dlt_entity_id", dlt_entity_id);
	            body.add("dlt_template_id", dlt_template_id);

	            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

	            


	            ResponseEntity<String> response = restTemplate.postForEntity(smsUrl, requestEntity, String.class);

	            
	            System.out.print(response);
	            
			 
			 
		}
		catch(Exception pp) {
			pp.printStackTrace();
		}
		return otpRequest;
	}
    
    /*
    @Override
    public LoginResponse verifyOtp(VerifyOtpRequest request) {

        String mobileNo = request.getMobileNo();
        Integer enteredOtp = request.getOtp();

        // -----------------------------------------
        // 1. Validate request
        // -----------------------------------------

        if (mobileNo == null || mobileNo.trim().isEmpty()) {
            throw new RuntimeException("Mobile number is required");
        }

        if (enteredOtp == null) {
            throw new RuntimeException("OTP is required");
        }

        mobileNo = mobileNo.trim();

        // -----------------------------------------
        // 2. Find user
        // -----------------------------------------

        UserDetail user =
                userDetailRepository
                    .findByMobileNo(
                        mobileNo,
                        true                    
                    )
                    .orElseThrow(() ->
                        new RuntimeException(
                            "User not found or inactive"
                        )
                    );

        // -----------------------------------------
        // 3. Get latest OTP
        // -----------------------------------------

        OtpGeneration otpGeneration =
                otpGenerationRepository
                    .findTopByMobileNoOrderByGeneratedOnDesc(
                        mobileNo
                    )
                    .orElseThrow(() ->
                        new RuntimeException(
                            "OTP not generated"
                        )
                    );

        // -----------------------------------------
        // 4. Compare OTP
        // -----------------------------------------

        if (!enteredOtp.equals(otpGeneration.getOtpVal())) {

            throw new RuntimeException(
                "Invalid OTP"
            );
        }

        // -----------------------------------------
        // 5. Generate JWT
        // -----------------------------------------

        Instant now = Instant.now();

        JwtClaimsSet claims =
                JwtClaimsSet.builder()

                    .issuer("election-pdms")

                    .subject(user.getUsername())

                    .issuedAt(now)

                    .expiresAt(
                        now.plus(
                            8,
                            ChronoUnit.HOURS
                        )
                    )

                    .claim(
                        "userId",
                        user.getId()
                    )

                    .claim(
                        "mobileNo",
                        user.getMobileNo()
                    )

                    .claim(
                        "pollingStationId",
                        user.getPollingStationId()
                    )

                    .claim(
                        "blockId",
                        user.getBlockId()
                    )

                    .claim(
                        "role",
                        user.getDutyRole()
                    )

                    .build();

        String token =
                jwtEncoder
                    .encode(
                        JwtEncoderParameters.from(claims)
                    )
                    .getTokenValue();

        // -----------------------------------------
        // 6. Return JWT
        // -----------------------------------------

        return new LoginResponse(
            token,
            "Bearer",
            8 * 60 * 60
        );
    }
    */
}
