package com.talento.springdemo.EjemploSpringBoot.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talento.springdemo.EjemploSpringBoot.Entidad.Persona;
import com.talento.springdemo.EjemploSpringBoot.Entidad.Rol;
import com.talento.springdemo.EjemploSpringBoot.dao.PersonaDAO;

@Service("userDetailsService")
public class PersonaImplement implements PersonaService, UserDetailsService  {

	@Autowired
	private PersonaDAO personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly=true)
	public Persona buscarPersona(Persona persona) {
		return personaDao.findById(persona.getIdPersona()).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Persona user=personaDao.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		var roles = new ArrayList<GrantedAuthority>();
		for(Rol rol: user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));//nombre
			//del tipo de usuario
		}
		
		return new User(user.getUsername(),user.getPassword(),roles);
		//return un nuevo Usuario - username, password - roles
	}
}
