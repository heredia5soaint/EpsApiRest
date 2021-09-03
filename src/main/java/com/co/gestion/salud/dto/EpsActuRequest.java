package com.co.gestion.salud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpsActuRequest {

	@ApiModelProperty(notes = "Dirección", example = "Calle x #y - z", position = 1, required = true)
	private String direccion;
	@ApiModelProperty(notes = "Teléfono", example = "333", position = 2, required = true)
	private Integer telefono;
}
