package com.example.sabonchi.demoSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	    @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .authorizeHttpRequests(
	                        authorizeHttp -> {
	                            authorizeHttp.requestMatchers("/cards/").permitAll();
	                            authorizeHttp.requestMatchers("/favicon.svg").permitAll();
	                            authorizeHttp.requestMatchers("/css/*").permitAll();
	                            authorizeHttp.requestMatchers("/error").permitAll();
	                            authorizeHttp.anyRequest().authenticated();
	                        })
	                .oauth2Login(withDefaults())
	                .build();
	    }
}
