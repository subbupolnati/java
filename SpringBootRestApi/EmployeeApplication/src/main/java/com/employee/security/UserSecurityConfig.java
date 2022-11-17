package com.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.employee.filter.JwtAuthenticationFilter;
import com.employee.service.CredentialService;
@EnableWebSecurity
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CredentialService credentialService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	public CredentialService getCredentialService() {
		return credentialService;
	}
	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	public JwtAuthenticationFilter getJwtFilter() {
		return jwtFilter;
	}
	public void setJwtFilter(JwtAuthenticationFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/credentialregisterpage").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/logout").permitAll()
		.antMatchers("/homepage").hasRole("Admin")
		.antMatchers("/credential/save").permitAll()
		.antMatchers("/employee/**").permitAll()
		.antMatchers("/employee/employeesave").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(credentialService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManager();
	}
}
