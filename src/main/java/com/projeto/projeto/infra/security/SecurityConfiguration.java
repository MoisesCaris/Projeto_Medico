package com.projeto.projeto.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/hospital/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/pacient/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/pacient/get/pacients").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/get/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/doctor/get/doctors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/pacient/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/consultation/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/hospital/change/{ID}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/doctor/registerdoctor").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/hospital/take/{city}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/hospital/get/{state}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/hospital/get/by/{name}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/consultation").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/bill/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/exams/register").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/doctor/").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.GET, "/bill/get/bill").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/bill/pay/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/bill/get/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/bill/get/open/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/bill/get/close/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/pacient/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/doctor/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
