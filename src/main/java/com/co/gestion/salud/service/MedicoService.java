package com.co.gestion.salud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.gestion.salud.dto.MedicoActuRequest;
import com.co.gestion.salud.dto.MedicoRequest;
import com.co.gestion.salud.entities.Eps;
import com.co.gestion.salud.entities.Medico;
import com.co.gestion.salud.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private EpsService epsService;

	private final Boolean ESTADO_INICIAL = true;

	private final Boolean CRITERIO_BUSQUEDA_ESTADO = true;

	public List<Medico> listarMedicos() {
		return medicoRepository.findAll();
	}

	public Medico medicoXId(Long id) {
		return medicoRepository.findById(id).get();
	}

	public Medico medicoActualizar(Long id, MedicoActuRequest medicoActuRequest) {
		Medico medicoActualizar = medicoXId(id);
		medicoActualizar.setCelular(medicoActuRequest.getCelular());
		return medicoRepository.save(medicoActualizar);
	}

	public Medico medicoEliminar(Long id) {
		Medico medicoEliminar = medicoXId(id);
		medicoEliminar.setEstado(!medicoEliminar.getEstado());
		return medicoRepository.save(medicoEliminar);
	}

	public Medico medicoCrear(MedicoRequest medicoRequest) {
		Medico medicoCrear = new Medico();
		Eps epsConsultar = epsService.epsXId(medicoRequest.getId_eps());
		if (epsConsultar != null) {
			if (epsConsultar.getEstado()) {
				medicoCrear.setCedula(medicoRequest.getCedula());
				medicoCrear.setCelular(medicoRequest.getCelular());
				medicoCrear.setEps(epsConsultar);
				medicoCrear.setEstado(ESTADO_INICIAL);
				medicoCrear.setNombre(medicoRequest.getNombre());
				return medicoRepository.save(medicoCrear);
			}
		}
		return null;
	}

	public List<Medico> listarXEstado() {
		return medicoRepository.findByEstado(CRITERIO_BUSQUEDA_ESTADO);
	}

	public List<Medico> listarXEps(Long id) {
		return medicoRepository.findByEps(epsService.epsXId(id));
	}
}
