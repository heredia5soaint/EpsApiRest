package com.co.gestion.salud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoRequest {

	@ApiModelProperty(notes = "Nombre", example = "Pedro", position = 1, required = true)
	private String nombre;
	@ApiModelProperty(notes = "Cedula", example = "100", position = 2, required = true)
	private Integer cedula;
	@ApiModelProperty(notes = "Celular", example = "200", position = 3, required = true)
	private Integer celular;
	@ApiModelProperty(notes = "EPS", example = "1", position = 4, required = true)
	private Long id_eps;
}
