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
                        .requestMatchers(HttpMethod.POST, "/hospital/register").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.POST, "/pacient/register").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/pacient/get/pacients").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/users/get/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/doctor/get/doctors").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.POST, "/pacient/register").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.POST, "/consultation/register").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.PATCH, "/hospital/change/{ID}").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.POST,"/doctor/registerdoctor").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/hospital/take/{city}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/hospital/get/{state}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/hospital/get/by/{name}").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/consultation").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.POST, "/bill/register").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.POST, "/exams/register").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/doctor/").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.GET, "/bill/get/bill").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/bill/pay/{id}").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/bill/get/{id}").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/bill/get/open/{id}").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/bill/get/close/{id}").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/pacient/{id}").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.GET, "/consultation/get/doctor/{id}").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.GET, "/exams/get/pacient/{id}").hasRole("DOCTOR")
                        .requestMatchers(HttpMethod.POST, "/hospitalization/register").hasRole("ADMINSYS")
                        .requestMatchers(HttpMethod.GET, "/hospitalization/exit/{id}").hasRole("ADMINSYS")
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
