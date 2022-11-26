package com.Proyecto_DAW_2022_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_DAW_2022_2.dao.UsuarioRepository;
import com.Proyecto_DAW_2022_2.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> listarUsuarios(){
		return repo.findAll();
	}
	public void grabar(Usuario bean) {
		repo.save(bean);
	}
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	public Usuario buscar(Integer id) {
		return repo.findById(id).orElse(null);
	}	
	
}
