package com.mohit.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	private final JwtFilter jwtFilter;

	public SecurityConfig(JwtFilter jwtFilter) {
	    this.jwtFilter = jwtFilter;
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**").permitAll()
                    .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
                    .requestMatchers("/api/jobs/create").hasAuthority("ROLE_RECRUITER")
                    .requestMatchers("/api/apply/**").hasAuthority("ROLE_USER")
                    .requestMatchers("/api/user/**").hasAuthority("ROLE_USER")
                    .requestMatchers("/api/auth/user/**").hasAuthority("ROLE_USER")
                    .requestMatchers("/api/auth/admin/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}