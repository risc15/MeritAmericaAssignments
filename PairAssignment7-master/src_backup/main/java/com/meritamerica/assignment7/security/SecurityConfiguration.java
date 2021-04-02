package com.meritamerica.assignment7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.meritamerica.assignment7.filters.JwtRequestFilter;
import com.meritamerica.assignment7.services.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin(); // Needed to access h2 database console.
		http.addFilterBefore(jwtRequestFilter,  UsernamePasswordAuthenticationFilter.class);
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/h2-console/").permitAll()
				.antMatchers("/authenticate").permitAll()
				.antMatchers("/authenticate/CreateUser/**").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/CDOfferings").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/CDOfferings").hasAnyAuthority("ADMIN","USER")
				.antMatchers("/AccountHolders/**").hasAnyAuthority("ADMIN")
				.antMatchers("/Me/**").hasAnyAuthority("USER")
				//.anyRequest().permitAll()
				.and().exceptionHandling()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}