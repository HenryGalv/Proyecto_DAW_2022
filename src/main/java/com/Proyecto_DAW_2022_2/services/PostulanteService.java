package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.PostulanteRepository;
import com.Proyecto_DAW_2022_2.entity.Postulante;

@Service
public class PostulanteService {
	@Autowired
	private PostulanteRepository repo;
	public List<Postulante> listarPostulantes(){
		return repo.findAll();
	}
	public void grabar(Postulante bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Postulante buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
}
