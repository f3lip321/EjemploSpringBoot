package com.talento.springdemo.EjemploSpringBoot.Entidad;

import java.io.Serializable;


import lombok.Data;


@Data
public class Rol implements Serializable {
	private static final long serialVersionUID=1L;
	
	
	private Long idRol;
	private String nombre;
}
