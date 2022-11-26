package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.TipoUsuarioRepository;
import com.Proyecto_DAW_2022_2.entity.TipoUsuario;

@Service
public class TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository repo;
	public List<TipoUsuario> listarTipoUsuario(){
		return repo.findAll();
	}
}	
