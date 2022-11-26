package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.CategoriaRepository;
import com.Proyecto_DAW_2022_2.entity.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> listarCategorias(){
		return repo.findAll();
	}
	public void grabar(Categoria bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Categoria buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
}
