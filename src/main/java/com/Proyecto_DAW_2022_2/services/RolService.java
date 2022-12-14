package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.RolRepository;
import com.Proyecto_DAW_2022_2.entity.Rol;

@Service
public class RolService {
	@Autowired
	private RolRepository repo;
	
	public List<Rol> listarRoles(){
		return repo.findAll();
	}
}
