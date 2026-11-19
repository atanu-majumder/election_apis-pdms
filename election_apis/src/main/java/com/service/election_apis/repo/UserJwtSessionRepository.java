package com.service.election_apis.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.election_apis.entity.UserJwtSession;

public interface UserJwtSessionRepository extends JpaRepository<UserJwtSession, String>{

	Optional<UserJwtSession> findByMobileNoAndJwtJtiAndIsActive(
            String mobileNo,
            String jwtJti,
            Boolean isActive);
}
