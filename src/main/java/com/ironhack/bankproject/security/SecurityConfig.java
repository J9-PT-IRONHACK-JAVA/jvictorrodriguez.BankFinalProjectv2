package com.ironhack.bankproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


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
                .requestMatchers(HttpMethod.POST, "/Transaction/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .userDetailsService(jpaUserDetailsService)
                .httpBasic()
                .and()
                .build();
    }
}
