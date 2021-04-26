package com.talento.springdemo.EjemploSpringBoot.Entidad;

import java.io.Serializable;

import javax.persistence.*;


import lombok.Data;

@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRol;
	private String nombre;
}
