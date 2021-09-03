package com.co.gestion.salud.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpsResponse {

	@ApiModelProperty(position = 1)
	private Long id;
	@ApiModelProperty(position = 2)
	private String nombre;
	@ApiModelProperty(position = 3)
	private Integer nit;
	@ApiModelProperty(position = 4)
	private Integer tipo;
	@ApiModelProperty(position = 5)
	private String direccion;
	@ApiModelProperty(position = 6)
	private Integer telefono;
	@ApiModelProperty(position = 7)
	private Boolean estado;
	
	@ApiModelProperty(position = 8)
	private List<MedicoResponse> medicos;

	
	
}
