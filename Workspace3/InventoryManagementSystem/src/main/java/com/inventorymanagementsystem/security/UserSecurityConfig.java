package com.inventorymanagementsystem.security;

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

import com.inventorymanagementsystem.filter.JwtAuthenticationFilter;
import com.inventorymanagementsystem.service.UserService;
@EnableWebSecurity
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		.antMatchers("/login").permitAll()
		.antMatchers("/user").permitAll()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/supplier/{username}").permitAll()
		.antMatchers("/customer/{username}").permitAll()
		.antMatchers("/role").permitAll()
		.antMatchers("/permission").permitAll()
		.antMatchers("/roles").permitAll()
		.antMatchers("/permissions").permitAll()
		.antMatchers("/home").hasRole("Admin")
		.antMatchers("/customer/**").permitAll()
		.antMatchers("/supplier/**").hasAnyRole("Admin","Supplier")
		.antMatchers("/inventory/**").permitAll()
		.antMatchers("/inventorys").permitAll()
		.antMatchers("stock/**").hasAnyRole("Admin","Supplier","Customer")
		.antMatchers("/payment/**").hasAnyRole("Admin","Supplier","Customer")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
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
