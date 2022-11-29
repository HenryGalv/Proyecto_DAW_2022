package com.Proyecto_DAW_2022_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_DAW_2022_2.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("select c from Cliente c where c.apellido like ?1")
	public List<Cliente> listAllAtCliente(String ape);

}
