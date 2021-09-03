package com.co.gestion.salud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoActuRequest {
	
	@ApiModelProperty(notes = "Celular", example = "200", required = true)
	private Integer celular;

}
