package com.talento.springdemo.EjemploSpringBoot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("pancito")
		.password("{noop}123") //no operation
		.roles("ADMIN,USER")
		.and()
		.withUser("quequito")
		.password("{noop}123")
		.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/editar/**","/agregar/**","/eliminar/**")
			.hasRole("ADMIN")
		//usuario admin puede ingresar a X ruta
			.antMatchers("/")
			//todos los usuarios pueden ver el index
			.hasAnyRole("USER","ADMIN")
			.and()
				.formLogin()
					.loginPage("/login")
			.and()
				.exceptionHandling().accessDeniedPage("/errores/403")
			;
	}	
}
