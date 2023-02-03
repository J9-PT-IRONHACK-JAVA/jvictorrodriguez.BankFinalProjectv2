package com.ironhack.bankproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserdetailsService userdetailsService;




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/Transaction/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/AdminAccess/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/AdminAccess/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/AdminAccess/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/AdminAccess/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/Transaction/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .userDetailsService(userdetailsService)
                .httpBasic()
                .and()
                .build();
    }
}
