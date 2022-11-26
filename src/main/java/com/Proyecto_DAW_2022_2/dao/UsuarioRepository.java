package com.Proyecto_DAW_2022_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_DAW_2022_2.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
}
