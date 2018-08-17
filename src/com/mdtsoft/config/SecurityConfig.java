package com.mdtsoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ComboPooledDataSource comboPooledDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(comboPooledDataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/customers").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.GET, "/api/customers/*").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER")
			.antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER")
			.antMatchers(HttpMethod.DELETE, "/api/customers/*").hasRole("ADMIN")
			.and()
			.formLogin()	
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
}
