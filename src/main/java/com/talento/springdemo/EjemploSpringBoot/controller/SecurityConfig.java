package com.talento.springdemo.EjemploSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("pancito")
			.password("{noop}123")//2$152asdasdasda546 no-operation
			.roles("ADMIN","USER")
			.and()
			.withUser("quequito")
			.password("{noop}123")
			.roles("USER");	
	}*/
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encriptarClave() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).
		passwordEncoder(encriptarClave());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/editar/**","/agregar/**","/eliminar")
		//** - es un comodin
			.hasRole("ADMIN")
		//usuario admin puede ingresar a X ruta
			.antMatchers("/")
			//todos los usuarios pueden ver el index
			.hasAnyRole("USER","ADMIN","GUESS")
			.and()
				.formLogin()
					.loginPage("/login")
			.and()
				.exceptionHandling().accessDeniedPage("/errores/403")
			;
	}
}
