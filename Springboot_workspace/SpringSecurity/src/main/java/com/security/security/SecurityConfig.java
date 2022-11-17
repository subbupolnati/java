package com.security.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("enfec").password(this.passwordEncoder().encode("enfec")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("subbu").password(this.passwordEncoder().encode("abc")).roles("NORMAL");
	}
	
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
