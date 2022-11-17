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
import com.employee.service.CustomUserDetailService;
@EnableWebSecurity
@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService cs;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	public CustomUserDetailService getCs() {
		return cs;
	}
	public void setCs(CustomUserDetailService cs) {
		this.cs = cs;
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
		.antMatchers("/home").permitAll()
		.antMatchers("/userregister").permitAll()
		.antMatchers("/login").permitAll()
		//.antMatchers("/employees").permitAll()
		//.antMatchers("/employee").permitAll()
		//.antMatchers("/employee/**").permitAll()
		//.antMatchers("/dept").permitAll()
		//.antMatchers("/dept/**").permitAll()
		.antMatchers("/employees").hasRole("ADMIN")
		.antMatchers("/dept").hasRole("ADMIN")
		.antMatchers("/employee/**").hasAnyRole("ADMIN","NORMAL")
		.antMatchers("/dept/**").hasAnyRole("ADMIN","NORMAL")
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("enfec").password(this.passwordEncoder().encode("enfec")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("subbu").password(this.passwordEncoder().encode("abc")).roles("NORMAL");
		auth.userDetailsService(cs).passwordEncoder(passwordEncoder());
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
