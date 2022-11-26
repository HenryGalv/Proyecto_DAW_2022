package com.Proyecto_DAW_2022_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_DAW_2022_2.entity.Ciudad;
import com.Proyecto_DAW_2022_2.entity.Distrito;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{
	@Query("select tp from Distrito tp where tp.ciudad.id=?1")
	public List<Distrito> findAllByIdCiudad(int idCiu);
	
}
