package com.Proyecto_DAW_2022_2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Proyecto_DAW_2022_2.entity.Ciudad;
import com.Proyecto_DAW_2022_2.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	@Query("select tp from Ciudad tp where tp.departamento.id=?1")
	public List<Ciudad> findAllByIdDepartamento(int idDep);
	
}
