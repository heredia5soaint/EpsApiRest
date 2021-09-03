package com.co.gestion.salud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.gestion.salud.entities.Eps;
import com.co.gestion.salud.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	
	public List<Medico> findByEstado(Boolean estado);
	
	public List<Medico> findByEps(Eps eps);
}
