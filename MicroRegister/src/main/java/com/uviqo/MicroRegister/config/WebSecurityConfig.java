package com.uviqo.MicroRegister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    // ALTHOUGH THIS SEEMS LIKE USELESS CODE,
	    // IT'S REQUIRED TO PREVENT SPRING BOOT AUTO-CONFIGURATION
	    return super.authenticationManagerBean();
	}
	

}
