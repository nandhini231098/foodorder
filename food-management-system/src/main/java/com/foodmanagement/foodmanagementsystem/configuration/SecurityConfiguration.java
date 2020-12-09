package com.foodmanagement.foodmanagementsystem.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableJpaAuditing
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
		
    
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select customer_name, password,true" + " from customer where customer_name=?")
		.authoritiesByUsernameQuery("select customer_name as customer_name,role" + " from customer where customer_name=?")
		.passwordEncoder(new BCryptPasswordEncoder());
		
		
	 auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
	
		/*
		 * http .csrf().disable() .authorizeRequests() .antMatchers("/").permitAll()
		 * .antMatchers("/user/*").hasAuthority("ROLE_USER")
		 * .antMatchers("/admin/*").hasAuthority("ROLE_ADMIN") .and()
		 * .formLogin().loginPage("/login") .defaultSuccessUrl("/home", true)
		 * 
		 * .failureUrl("/loginPage?error").permitAll() .and()
		 * .logout().logoutUrl("/logout").logoutSuccessUrl("/welcome")
		 * .and().exceptionHandling().accessDeniedPage("/accessdenied");
		 * 
		 */
		http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/actuator/**").permitAll()
        .antMatchers("/welcome").permitAll()
        .antMatchers("/items/*").hasAuthority("ROLE_USER")
        .antMatchers("/admin/additem","/admin/list/*","/admin/items/1","/admin/feedback").hasAuthority("ROLE_ADMIN")
        .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/loginPage?error").permitAll()       
        .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/welcome")
        .and().exceptionHandling().accessDeniedPage("/accessdenied");
	
	}
	
	
}
	
	
	
	
	


