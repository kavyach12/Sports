package com.example.sports.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF for simplicity (only for development/hackathon)
            .csrf(csrf -> csrf.disable())
            // Allow all requests without authentication
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )
            // Disable form login (optional)
            .formLogin(login -> login.disable())
            // Disable HTTP Basic authentication (optional)
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
