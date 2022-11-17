package com.employee_timesheet.security;

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

import com.employee_timesheet.filter.JwtAuthenticationFilter;
import com.employee_timesheet.service.CustomUserDetailService;

@EnableWebSecurity
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/v1/timesheet/user").permitAll()
		.antMatchers("/v1/timesheet/user/**").hasAnyRole("HR")
		.antMatchers("/v1/timesheet/users").hasAnyRole("HR")
		.antMatchers("/v1/timesheet/client/**").hasAnyRole("HR")
		.antMatchers("/v1/timesheet/client").hasAnyRole("HR")
		.antMatchers("/v1/timesheet/clients").hasAnyRole("HR")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
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
