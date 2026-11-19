package com.service.election_apis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.jwtAuthenticationFilter =
                jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth
            		.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                // Login APIs
                .requestMatchers(
                    "/pdms/v1/auth/**",
                    "/pdms/v1/milestone-status/**"
                ).permitAll()

                // Swagger
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/election_apis/pdms/v1/auth/**").permitAll()
//                        .requestMatchers(
//                            "/election_apis/swagger-ui/**",
//                            "/election_apis/swagger-ui.html",
//                            "/election_apis/v3/api-docs/**"
//                        ).permitAll()
            
                //For Reports
//                .requestMatchers("/polling-monitoring/**")
//                .hasRole("PRESIDING_OFFICER")
                
                
             // Polling Transaction Details APIs
//                .requestMatchers(
//                    "/pdms/v1/pstrandet/**"
//                )
//                .hasRole("PRESIDING_OFFICER")
                
              //For Polling details update
//                .requestMatchers("/pdms/v1/pstran/**")
//                .hasRole("...")
//                
                // Everything else requires JWT
                .anyRequest().authenticated()
            )

            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
