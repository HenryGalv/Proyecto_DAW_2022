package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.CiudadRepository;
import com.Proyecto_DAW_2022_2.entity.Ciudad;
import com.Proyecto_DAW_2022_2.entity.Distrito;

@Service
public class CiudadService {
	@Autowired
	private CiudadRepository repo;
	public List<Ciudad> listarCiudades(){
		return repo.findAll();
	}
	public List<Distrito> listarDistritoPorIdCiudad(int idCiu){
		return repo.findAllByIdCiudad(idCiu);
	}
}
