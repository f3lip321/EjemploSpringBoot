package com.talento.springdemo.EjemploSpringBoot.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talento.springdemo.EjemploSpringBoot.Entidad.Persona;
import com.talento.springdemo.EjemploSpringBoot.dao.PersonaDAO;

@Service
public class PersonaImplement implements PersonaService {

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
}
