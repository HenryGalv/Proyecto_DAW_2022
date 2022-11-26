package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.MarcaRepository;
import com.Proyecto_DAW_2022_2.entity.Marca;


@Service
public class MarcaService {
	@Autowired
	private MarcaRepository repo;
	
	public List<Marca> listarMarcas(){
		return repo.findAll();
	}
	public void grabar(Marca bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Marca buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
}
