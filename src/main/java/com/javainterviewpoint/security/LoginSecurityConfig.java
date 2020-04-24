package com.javainterviewpoint.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	AdminAuthenticationProvider authenticationProvider;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider).eraseCredentials(false);
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.inMemoryAuthentication()
//			.withUser("user1")
//			.password("test123")
//			.authorities("ROLE_USER")
//			.and()
//			.withUser("admin1").password("admin123").authorities("ROLE_USER","ROLE_ADMIN");
//	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/*/**").antMatchers("/uploadpdf.htm").antMatchers("/img/*/**").antMatchers("/fonts/*/**"). 
		antMatchers("/health.do");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*.authorizeRequests()
    	.antMatchers( "/login.htm" ).permitAll()
    	.antMatchers("/dashboard.").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    	.antMatchers("/userPage").access("hasRole('ROLE_USER')")
		.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")*/
		
		http
		.exceptionHandling()
        .accessDeniedPage( "/403" )
        .and()
        .authorizeRequests()
        	.antMatchers( "/login.htm" ).permitAll()
        	.antMatchers("/uploadpdf.htm").permitAll()
        	.anyRequest().authenticated()
        	.and()
        .formLogin()
        	.loginPage( "/login.htm" )
        	.loginProcessingUrl( "/login.htm" ).defaultSuccessUrl("/documentmgmt.htm", true)
        	.failureUrl( "/login.htm?error" )
        	.usernameParameter( "username" )
        	.passwordParameter( "password" )
        	.and()
			.logout().logoutSuccessUrl("/login.htm?logout"); 	
	}
}