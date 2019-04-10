package com.cinte.experian.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CIUDAD")
	private Long idCiudad;
	@Column(name="CODIGO_CIUDAD")
	private String codigoCiudad;
	@JoinColumn(name="CODIGO_PAIS", referencedColumnName= "ID_PAIS")
	@ManyToOne(optional= false)
	private Pais pais;
	@Column(name="NOMBRE")
	private String nombre;
	
	
}
