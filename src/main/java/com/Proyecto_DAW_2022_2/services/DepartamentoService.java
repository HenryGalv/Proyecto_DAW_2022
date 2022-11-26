package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.DepartamentoRepository;
import com.Proyecto_DAW_2022_2.entity.Ciudad;
import com.Proyecto_DAW_2022_2.entity.Departamento;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository repo;
	public List<Departamento> listarDepartamentos(){
		return repo.findAll();
	}
	public List<Ciudad> listarCiudadPorIdDepartamento(int idDep){
		return repo.findAllByIdDepartamento(idDep);
	}
}
