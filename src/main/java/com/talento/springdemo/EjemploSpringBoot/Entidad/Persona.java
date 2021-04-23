package com.talento.springdemo.EjemploSpringBoot.Entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Johana
 *
 */
@Data
@Entity
@Table(name="persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fecha_nac;
	private String username;
	private String password;
	private int telefono;
	private boolean estado;
	//private int edad;
	
	
}
