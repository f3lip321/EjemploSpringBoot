package com.talento.springdemo.EjemploSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talento.springdemo.EjemploSpringBoot.Entidad.Persona;

public interface PersonaDAO extends JpaRepository<Persona,Long> {
	Persona findByUsername(String username);
}
