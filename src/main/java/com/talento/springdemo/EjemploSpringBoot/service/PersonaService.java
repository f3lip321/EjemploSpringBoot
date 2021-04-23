package com.talento.springdemo.EjemploSpringBoot.service;

import java.util.List;

import com.talento.springdemo.EjemploSpringBoot.Entidad.Persona;
public interface PersonaService {

	public List<Persona> listarPersonas();
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona buscarPersona(Persona persona);
}

