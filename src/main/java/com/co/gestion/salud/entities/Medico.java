package com.co.gestion.salud.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico")
	private Long id;
	@Column(name = "nombre_medico", length = 30)
	private String nombre;
	@Column(name = "cedula_medico")
	private Integer cedula;
	@Column(name = "celular_celular")
	private Integer celular;
	@Column(name = "estado_medico")
	private Boolean estado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Eps eps;
}
