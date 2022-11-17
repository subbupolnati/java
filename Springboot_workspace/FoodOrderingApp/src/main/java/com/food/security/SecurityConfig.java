package com.food.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.food.service.CustomUserDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService cs;
	
	public CustomUserDetailService getCs() {
		return cs;
	}
	public void setCs(CustomUserDetailService cs) {
		this.cs = cs;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/createNewUser").permitAll()
		.antMatchers("/usersave").permitAll()
		.antMatchers("/home").hasRole("admin")
		.antMatchers("/food/**").hasRole("admin")
		.antMatchers("/save").hasRole("admin")
		.antMatchers("food/**").hasAnyRole("user","admin")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		//http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("admin");
		//auth.inMemoryAuthentication().withUser("subbu").password(this.passwordEncoder().encode("abc")).roles("admin");
		auth.userDetailsService(cs).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

