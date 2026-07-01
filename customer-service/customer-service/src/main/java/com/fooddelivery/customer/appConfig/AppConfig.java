package com.fooddelivery.customer.appConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails userDetails1 = User.builder().username("vijay1").password(passwordencoder().encode("abc")).roles("ADMIN1").build();
		
		//UserDetails userDetails2 = User.builder().username("vijay2").password(passwordencoder().encode("xyz")).roles("ADMIN2").build();
		
		
		return new InMemoryUserDetailsManager(userDetails1);
	}
	
	@Bean
	public PasswordEncoder  passwordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
	
	
	
	
	
	
	
	
	

}
