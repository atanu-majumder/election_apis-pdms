package com.service.election_apis.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
//9import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	
	private final SecretKey secretKey =
            Keys.hmacShaKeyFor(
                    "PDMS-SUPER-SECRET-KEY-CHANGE-THIS-TO-A-LONG-RANDOM-VALUE"
                            .getBytes()
            );

    private final long expirationTime =
            8 * 60 * 60 * 1000; // 8 hours

	
    public String generateToken(
            String mobileNo,
            Integer pollingStationId, String pollingStationName,
            Integer blockId, String blockName,
            Integer electionId, String electionName,
            Integer districtId, String districtName,
            Integer userId, String empName, 
            Integer wardId, String wardName) {

        Map<String, Object> claims = new HashMap<>();

        claims.put("polling_station_id", pollingStationId);
        claims.put("polling_station_name", pollingStationName);
        claims.put("block_id", blockId);
        claims.put("block_name", blockName);
        claims.put("ward_id", wardId);
        claims.put("ward_name", wardName);
        claims.put("election_id", electionId);
        claims.put("election_name", electionName);
        claims.put("district_id", districtId);
        claims.put("district_name", districtName);
        claims.put("user_id", userId);
        claims.put("emp_name", empName);
        claims.put("mobile_no", mobileNo);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationTime);
        String jti = UUID.randomUUID().toString();

        return Jwts.builder()
        		// Unique JWT ID
                .id(jti)
                .claims(claims)
                .subject(mobileNo)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }
        
    public String extractJti(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getId();
    }
    
    public Integer extractPollingStationId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("polling_station_id", Integer.class);
    }
    
    public String extractPollingStationName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("polling_station_name", String.class);
    }


    public Integer extractBlockId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("block_id", Integer.class);
    }


    public String extractBlockName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("block_name", String.class);
    }
    
    public Integer extractWardId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("ward_id", Integer.class);
    }


    public String extractWardName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("ward_name", String.class);
    }

    public Integer extractElectionId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("election_id", Integer.class);
    }

    public String extractElectionName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("election_name", String.class);
    }
    
    public Integer extractDistrictId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("district_id", Integer.class);
    }

    public String extractDistrictName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("district_name", String.class);
    }


    public String extractMobileNo(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }    
        
    public String extractEmpName(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("emp_name", String.class);
    }

    public Integer extractUserId(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("user_id", Integer.class);
    }

}
