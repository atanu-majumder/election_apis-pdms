package com.service.election_apis.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.election_apis.entity.OtpGeneration;

@Repository
public interface OtpGenerationRepository extends JpaRepository<OtpGeneration, Integer>{

	Optional<OtpGeneration> findTopByMobileNoOrderByGeneratedOnDesc(String mobileNo);
	
	Optional<OtpGeneration> findTopByMobileNoOrderByOtpIdDesc(String mobileNo);
	
	Optional<OtpGeneration> findTopByMobileNoAndDeviceIdOrderByGeneratedOnDesc(String mobileNo, String deviceId);
	
	//Optional<OtpGeneration> findTopByMobileNoOrderByGeneratedOnDesc(String mobileNo);
}
