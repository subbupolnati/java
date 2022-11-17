package com.airlinesproducer.security;

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

import com.airlinesproducer.filter.JwtAuthenticationFilter;
import com.airlinesproducer.service.CustomUserDetailService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	public CustomUserDetailService getCustomUserDetailService() {
		return customUserDetailService;
	}
	public void setCs(CustomUserDetailService customUserDetailService) {
		this.customUserDetailService = customUserDetailService;
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
		.csrf().disable()
		.cors()
		.disable()
		.authorizeHttpRequests()
		//.antMatchers("/home").permitAll()
		.antMatchers("/userregister").permitAll()
		.antMatchers("/login").permitAll()
		//.antMatchers("/airlines").permitAll()
		//.antMatchers("/passenger").permitAll()
		//.antMatchers("/airlines/**").permitAll()
		//.antMatchers("/passenger/**").permitAll()
		.antMatchers("/airlines").hasRole("ADMIN")
		.antMatchers("/passenger").hasRole("ADMIN")
		.antMatchers("/airlines/**").hasAnyRole("ADMIN","NORMAL")
		.antMatchers("/passenger/**").hasAnyRole("ADMIN","NORMAL")
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
