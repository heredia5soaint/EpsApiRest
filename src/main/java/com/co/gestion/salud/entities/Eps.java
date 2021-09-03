package com.co.gestion.salud.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Eps {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_eps")
	private Long id;
	@Column(name = "nombre_eps", length = 30)
	private String nombre;
	@Column(name = "nit_eps")
	private Integer nit;
	@Column(name = "tipo_eps")
	private Integer tipo;
	@Column(name = "direccion_eps", length = 30)
	private String direccion;
	@Column(name = "telefono_eps")
	private Integer telefono;
	@Column(name = "estado_eps")
	private Boolean estado;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "eps")
	private List<Medico> medicos;
}
