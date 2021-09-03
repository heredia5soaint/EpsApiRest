package com.co.gestion.salud.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.gestion.salud.dto.EpsResponse;
import com.co.gestion.salud.dto.MedicoResponse;
import com.co.gestion.salud.entities.Eps;
import com.co.gestion.salud.entities.Medico;

@Component
public class EntidadToConverter {

	@Autowired
	private ModelMapper modelMapper;

	public EpsResponse epsConvertir(Eps eps) {
		return modelMapper.map(eps, EpsResponse.class);
	}

	public List<EpsResponse> epsConvertir(List<Eps> eps) {
		return eps.stream().map(epsConvertir -> epsConvertir(epsConvertir)).collect(Collectors.toList());
	}

	public MedicoResponse medicoConvertir(Medico medico) {
		return modelMapper.map(medico, MedicoResponse.class);
	}

	public List<MedicoResponse> medicoConvertir(List<Medico> medicos) {
		return medicos.stream().map(medico -> medicoConvertir(medico)).collect(Collectors.toList());

	}
}
