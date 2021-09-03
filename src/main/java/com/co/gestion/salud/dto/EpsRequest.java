package com.co.gestion.salud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpsRequest {
	
	@ApiModelProperty(notes = "Nombre", example = "Salud X", position = 1, required = true)
	private String nombre;
	@ApiModelProperty(notes = "NIT", example = "900", position = 2, required = true)
	private Integer nit;
	@ApiModelProperty(notes = "Tipo", example = "1", position = 3, required = true)
	private Integer tipo;
	@ApiModelProperty(notes = "Dirección", example = "Calle x #y - z", position = 4, required = true)
	private String direccion;
	@ApiModelProperty(notes = "Teléfono", example = "300", position = 5, required = true)
	private Integer telefono;
	
}
