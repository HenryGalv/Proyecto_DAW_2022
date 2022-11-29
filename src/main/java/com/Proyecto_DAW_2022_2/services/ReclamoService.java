package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Proyecto_DAW_2022_2.dao.ReclamoRepository;

import com.Proyecto_DAW_2022_2.entity.Reclamo;

@Service
public class ReclamoService {
	@Autowired
	private ReclamoRepository repo;

	public List<Reclamo> listarReclamo(){
		return repo.findAll();
	}
	public void grabar(Reclamo bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Reclamo buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
}
