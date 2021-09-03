package com.co.gestion.salud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponse {
	
	@ApiModelProperty(position = 1)
	private Long id;
	@ApiModelProperty(position = 2)
	private String nombre;
	@ApiModelProperty(position = 3)
	private Integer cedula;
	@ApiModelProperty(position = 4)
	private Integer celular;
	@ApiModelProperty(position = 5)
	private Boolean estado;
}
