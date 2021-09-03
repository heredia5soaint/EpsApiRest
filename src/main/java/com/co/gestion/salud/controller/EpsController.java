package com.co.gestion.salud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.gestion.salud.dto.EpsActuRequest;
import com.co.gestion.salud.dto.EpsRequest;
import com.co.gestion.salud.dto.EpsResponse;
import com.co.gestion.salud.service.EpsService;
import com.co.gestion.salud.util.EntidadToConverter;

import io.swagger.annotations.ApiOperation;

@RestController
public class EpsController {

	@Autowired
	private EpsService epsService;

	@Autowired
	private EntidadToConverter entidadToConverter;

	@ApiOperation(value = "Lista todas las EPS")
	@GetMapping(value = "eps")
	public ResponseEntity<List<EpsResponse>> listaEps() {
		return new ResponseEntity<List<EpsResponse>>(entidadToConverter.epsConvertir(epsService.listarEps()),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista todas las EPS con un tipo mayor a 2")
	@GetMapping(value = "eps/tipo")
	public ResponseEntity<List<EpsResponse>> listarXTipo(){
		return new ResponseEntity<List<EpsResponse>>(entidadToConverter.epsConvertir(epsService.listarXTipo()),HttpStatus.OK);
	}

	@ApiOperation(value = "Busca una EPS por ID")
	@GetMapping(value = "eps/{id}")
	public ResponseEntity<EpsResponse> epsXId(@PathVariable Long id) {
		return new ResponseEntity<EpsResponse>(entidadToConverter.epsConvertir(epsService.epsXId(id)), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualiza la direccion y el telefono de una EPS")
	@PutMapping(value = "eps/{id}")
	public ResponseEntity<EpsResponse> epsActualizar(@PathVariable Long id,
			@RequestBody EpsActuRequest epsActuRequest) {
		return new ResponseEntity<EpsResponse>(
				entidadToConverter.epsConvertir(epsService.epsActualizar(id, epsActuRequest)), HttpStatus.OK);
	}

	@ApiOperation(value = "Inactiva una EPS, dado su ID")
	@DeleteMapping(value = "eps/{id}")
	public ResponseEntity<EpsResponse> epsEliminar(@PathVariable Long id) {
		return new ResponseEntity<EpsResponse>(entidadToConverter.epsConvertir(epsService.epsEliminar(id)),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Crea una EPS")
	@PostMapping(value = "eps")
	public ResponseEntity<EpsResponse> epsCrear(@RequestBody EpsRequest epsRequest) {
		return new ResponseEntity<EpsResponse>(entidadToConverter.epsConvertir(epsService.epsCrear(epsRequest)),
				HttpStatus.ACCEPTED);
	}
}
