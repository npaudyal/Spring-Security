package com.paudyal.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory auth
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("John").password("test123").roles("EMPLOYEE"))
									 .withUser(users.username("Mary").password("test123").roles("MANAGER", "EMPLOYEE"))
									 .withUser(users.username("Sujan").password("test123").roles("ADMIN", "EMPLOYEE"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll()
				.and()
				.logout().permitAll();
		
	}
	
}
