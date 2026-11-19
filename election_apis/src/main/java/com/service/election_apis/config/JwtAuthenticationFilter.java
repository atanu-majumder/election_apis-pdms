package com.service.election_apis.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.service.election_apis.repo.UserJwtSessionRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JwtService jwtService;
	private final UserJwtSessionRepository userJwtSessionRepository;

    public JwtAuthenticationFilter(JwtService jwtService,
            UserJwtSessionRepository userJwtSessionRepository) {
        this.jwtService = jwtService;
        this.userJwtSessionRepository = userJwtSessionRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String requestPath = request.getServletPath();

        // Authentication APIs do not require JWT
        if (requestPath.contains("/pdms/v1/auth") || requestPath.contains("/pdms/v1/milestone-status")
        		|| requestPath.contains("/swagger-ui")
        		|| requestPath.contains("/pdms/v1/swagger-ui/index.html")
        		|| requestPath.contains("/v3/api-docs")
                || requestPath.contains("/swagger-ui.html")) {
            filterChain.doFilter(request, response);
            return;
        }
        String servletPath = request.getServletPath();
//        if (servletPath.contains("/pdms/v1/auth")
//                || servletPath.contains("/swagger-ui")
//                || servletPath.contains("/v3/api-docs")
//                || servletPath.contains("/swagger-ui.html")) {
//            filterChain.doFilter(request, response);
//            return;
//        }

        String authHeader =
                request.getHeader("Authorization");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED);

            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"JWT token is required\"}"
            );

            return;
        }

        String token =
                authHeader.substring(7);

        try {

            Claims claims =
                    Jwts.parser()
                            .verifyWith(
                                    jwtService.getSecretKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();
         // -----------------------------------------
            // Get JWT claims
            // -----------------------------------------
            String mobileNo =
                    claims.getSubject();

            String jti =
                    claims.getId();
            
            Integer pollingStationId =
                    claims.get("polling_station_id",
                            Integer.class);

            Integer blockId =
                    claims.get("block_id",
                            Integer.class);

            Integer electionId =
                    claims.get("election_id",
                            Integer.class);

            // -----------------------------------------
            // Check current JWT session
            // -----------------------------------------

            boolean validSession =
                    userJwtSessionRepository
                            .findByMobileNoAndJwtJtiAndIsActive(
                                    mobileNo,
                                    jti,
                                    true
                            )
                            .isPresent();

            if (!validSession) {

                sendUnauthorized(
                        response,
                        "JWT token has been revoked or replaced"
                );

                return;
            }
            
            // Create authentication
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            mobileNo,
                            null,
                            Collections.singletonList(
                                    new SimpleGrantedAuthority(
                                            "ROLE_PRESIDING_OFFICER"
                                    )
                            )
                    );

            // Store JWT information in request
            request.setAttribute(
                    "polling_station_id",
                    pollingStationId);

            request.setAttribute(
                    "block_id",
                    blockId);

            request.setAttribute(
                    "election_id",
                    electionId);

            request.setAttribute(
                    "mobile_no",
                    mobileNo);

         // -----------------------------------------
            // Set Spring Security authentication
            // -----------------------------------------

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);

            filterChain.doFilter(request, response);
            System.out.print("hello");

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED);

            response.setContentType("application/json");

            response.getWriter().write("{\"message\":\"Invalid or expired JWT token\"}");
        }
//        System.out.println("Request URI: " + request.getRequestURI());
//
//        System.out.println("Authentication: " +
//            SecurityContextHolder.getContext().getAuthentication());
//
//        System.out.println("Is Authenticated: " +
//            (SecurityContextHolder.getContext().getAuthentication() != null &&
//             SecurityContextHolder.getContext().getAuthentication().isAuthenticated()));
        //filterChain.doFilter(request, response);
    }
    
    
    private void sendUnauthorized(
            HttpServletResponse response,
            String message)
            throws IOException {

        response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
        );

        response.setContentType(
                "application/json"
        );

        response.getWriter().write(
                "{\"message\":\""
                        + message
                        + "\"}"
        );
    }
}
