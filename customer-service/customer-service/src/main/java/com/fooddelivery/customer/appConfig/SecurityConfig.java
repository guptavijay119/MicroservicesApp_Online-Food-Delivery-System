package com.fooddelivery.customer.appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fooddelivery.customer.security.JWTAuthenticationEntryPoint;
import com.fooddelivery.customer.security.JwtAuthenticationFilter;
@Configuration
public class SecurityConfig {

    private final AppConfig appConfig;


    @Autowired
    private JWTAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    SecurityConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/login").permitAll()
                    .requestMatchers("/auth/register").permitAll()
                    .requestMatchers("/home/**").authenticated()
                    .anyRequest().authenticated()
            )
            .addFilterBefore(filter,
                    UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}