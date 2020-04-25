package com.SpringMVCBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration				//for configuration
@EnableWebSecurity			//to enable Web Secuiruty
//@EnableOAuth2Sso			//Single sign on
public class AppSecuirityConfig extends WebSecurityConfigurerAdapter  // to get all the secuirity config
{
	@Autowired
	private UserDetailsService userDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests().antMatchers("/login").permitAll()
//			.anyRequest().authenticated();
//	}
	
	
	@Bean					//to get object of the USerDetailsService method
	@Override  
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("souma").password("12345").roles("USER").build()); //static username and password
		return new InMemoryUserDetailsManager(users);
	}
	
//	@Bean
//	public AuthenticationProvider authenticationProvider() 
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);						//get user details from Database	
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());				//Encrypt the password using BCrypt
//		return provider;
//	}
	
	
}
