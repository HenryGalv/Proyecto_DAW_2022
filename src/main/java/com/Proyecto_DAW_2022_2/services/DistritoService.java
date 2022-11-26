package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.DistritoRepository;
import com.Proyecto_DAW_2022_2.entity.Distrito;

@Service
public class DistritoService {
	@Autowired
	private DistritoRepository repo;
	public List<Distrito> listarDistritos(){
		return repo.findAll();
	}
}
