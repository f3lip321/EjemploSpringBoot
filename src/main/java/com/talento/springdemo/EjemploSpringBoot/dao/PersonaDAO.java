package com.talento.springdemo.EjemploSpringBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.talento.springdemo.EjemploSpringBoot.Entidad.Persona;

public interface PersonaDAO extends CrudRepository<Persona,Long> {

}
