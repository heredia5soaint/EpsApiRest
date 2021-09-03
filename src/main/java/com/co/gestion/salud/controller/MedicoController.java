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

import com.co.gestion.salud.dto.MedicoActuRequest;
import com.co.gestion.salud.dto.MedicoRequest;
import com.co.gestion.salud.dto.MedicoResponse;
import com.co.gestion.salud.service.MedicoService;
import com.co.gestion.salud.util.EntidadToConverter;

import io.swagger.annotations.ApiOperation;

@RestController
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private EntidadToConverter entidadToConverter;

	@ApiOperation(value = "Lista todos los medicos")
	@GetMapping(value = "medico")
	public ResponseEntity<List<MedicoResponse>> listaMedicos() {
		return new ResponseEntity<List<MedicoResponse>>(
				entidadToConverter.medicoConvertir(medicoService.listarMedicos()), HttpStatus.OK);
	}

	@ApiOperation(value = "Busca un medico por su ID")
	@GetMapping(value = "medico/{id}")
	public ResponseEntity<MedicoResponse> medicoXId(@PathVariable Long id) {
		return new ResponseEntity<MedicoResponse>(entidadToConverter.medicoConvertir(medicoService.medicoXId(id)),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista todos los medicos activos")
	@GetMapping(value = "medico/tipo")
	public ResponseEntity<List<MedicoResponse>> medicoXEstado(){
		return new ResponseEntity<List<MedicoResponse>>(entidadToConverter.medicoConvertir(medicoService.listarXEstado()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Lista todos los medicos de una determinada EPS")
	@GetMapping(value = "medico/eps/{id}")
	public ResponseEntity<List<MedicoResponse>> medicosXEps(@PathVariable Long id){
		return new ResponseEntity<List<MedicoResponse>>(entidadToConverter.medicoConvertir(medicoService.listarXEps(id)),HttpStatus.OK);
	}

	@ApiOperation(value = "Actualiza el celular de un medico")
	@PutMapping(value = "medico/{id}")
	public ResponseEntity<MedicoResponse> medicoActualizar(@PathVariable Long id,
			@RequestBody MedicoActuRequest medicoActuRequest) {
		return new ResponseEntity<MedicoResponse>(
				entidadToConverter.medicoConvertir(medicoService.medicoActualizar(id, medicoActuRequest)),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Inactiva a un medico, dado su ID")
	@DeleteMapping(value = "medico/{id}")
	public ResponseEntity<MedicoResponse> medicoEliminar(@PathVariable Long id) {
		return new ResponseEntity<MedicoResponse>(entidadToConverter.medicoConvertir(medicoService.medicoEliminar(id)),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Crea a un medico")
	@PostMapping(value = "medico")
	public ResponseEntity<MedicoResponse> medicoCrear(@RequestBody MedicoRequest medicoRequest) {
		return new ResponseEntity<MedicoResponse>(
				entidadToConverter.medicoConvertir(medicoService.medicoCrear(medicoRequest)), HttpStatus.ACCEPTED);
	}
}
