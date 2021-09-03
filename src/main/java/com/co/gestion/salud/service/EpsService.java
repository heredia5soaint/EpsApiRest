package com.co.gestion.salud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.gestion.salud.dto.EpsActuRequest;
import com.co.gestion.salud.dto.EpsRequest;
import com.co.gestion.salud.entities.Eps;
import com.co.gestion.salud.repository.EpsRepository;

@Service
public class EpsService {

	@Autowired
	private EpsRepository epsRepository;

	private final int CRITERIO_BUSQUEDA_TIPO = 2;

	private final Boolean ESTADO_INICIAL = true;

	public List<Eps> listarEps() {
		return epsRepository.findAll();
	}

	public Eps epsXId(Long id) {
		return epsRepository.findById(id).get();
	}

	public List<Eps> listarXTipo() {
		List<Eps> listaEps = new ArrayList<>();
		for (Eps eps : listarEps()) {
			if (eps.getTipo() > CRITERIO_BUSQUEDA_TIPO) {
				listaEps.add(eps);
			}
		}
		return listaEps;
	}

	public Eps epsActualizar(Long id, EpsActuRequest epsActuRequest) {
		Eps epsActualizar = epsXId(id);
		epsActualizar.setDireccion(epsActuRequest.getDireccion());
		epsActualizar.setTelefono(epsActuRequest.getTelefono());
		return epsRepository.save(epsActualizar);
	}

	public Eps epsEliminar(Long id) {
		Eps epsEliminar = epsXId(id);
		epsEliminar.setEstado(!epsEliminar.getEstado());
		return epsRepository.save(epsEliminar);
	}

	public Eps epsCrear(EpsRequest epsRequest) {
		Eps epsCrear = new Eps();
		epsCrear.setDireccion(epsRequest.getDireccion());
		epsCrear.setEstado(ESTADO_INICIAL);
		epsCrear.setNit(epsRequest.getNit());
		epsCrear.setNombre(epsRequest.getNombre());
		epsCrear.setTelefono(epsRequest.getTelefono());
		epsCrear.setTipo(epsRequest.getTipo());
		return epsRepository.save(epsCrear);
	}
}
