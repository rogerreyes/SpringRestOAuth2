package com.cinte.experian.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PAIS")
	private Long idPais;
	@Column(name="CODIGO")
	private String codigo;
	@Column(name="NOMBRE")
	private String nombre;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "pais")
	private List<Ciudad> ciudades;

	
	
	

}
