package com.lerner.securitylearnersec01.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class ProjectSecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/myAccount","/myBalance","/myCards","/myLoans").authenticated()
				.requestMatchers("/notices","/contact").permitAll());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("ravindra")
//                .password("12345")
//                .roles("ADMIN")
//                .build();
        
        UserDetails admin = User.withUsername("ravindra")
                .password("{noop}12345")
                .authorities("ADMIN")
                .build();
        
        UserDetails user = User.withUsername("alok")
                .password("{bcrypt}$2a$12$pLKNTckp9hanlFqhdj7Q4uUQmB7sVp4exlIcDiOYEmFdKmX1xwHlS")
                .authorities("read")
                .build();
        
        
        return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();	
	}
	
	@Bean
	public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
	}
	

}
