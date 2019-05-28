package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/admin").hasAnyRole("ADMIN")
		.antMatchers("/hello").hasAnyRole("USER", "ADMIN")
		.antMatchers("/do").hasAnyRole("ADMIN")
		.anyRequest().authenticated();
		
		
		  http
		  .authorizeRequests().anyRequest().authenticated().and()
        .formLogin()
        .loginPage("/mylogin").loginProcessingUrl("/log")
			.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/admin")
        .permitAll();
		  
		  http.authorizeRequests().and().logout().logoutUrl("/mylogout")
		  .logoutSuccessUrl("/");
	}
	
	@Bean
	public NoOpPasswordEncoder noop() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
	
}
