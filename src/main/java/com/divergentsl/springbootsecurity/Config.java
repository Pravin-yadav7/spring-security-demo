package com.divergentsl.springbootsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;
	
	
	  @Bean public UserDetailsService userDetailsService(DataSource dataSource){
		  
		  return new JdbcUserDetailsManager(dataSource);
	  }
	  
	  @Bean public PasswordEncoder passwordEncoder() {
		  
		  return NoOpPasswordEncoder.getInstance(); 
	  }
	 

	  //InMemery configuration 
	/*@Bean
	public UserDetailsService userDetailsService() {

		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();

		UserDetails user = User.withUsername("pravin").password("77738").authorities("read").build();

		userDetailsService.createUser(user);

		return userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/

	protected void configure(HttpSecurity http) throws Exception {

		
		  http.httpBasic();
		  http.authorizeRequests().anyRequest().authenticated();

		// Giving access to a particular url/resource to a use with particular
		// authority
		 //http.authorizeRequests().antMatchers("/").hasAnyAuthority("read","write");

		// None of the requests need to be authenticated.
		//http.authorizeRequests().anyRequest().permitAll();

	}

	// Authentication configuration

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("pravin").password("77738").authorities("read").build();
		userDetailsService.createUser(user);
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());

		auth.authenticationProvider(authenticationProvider);

	}*/

}
