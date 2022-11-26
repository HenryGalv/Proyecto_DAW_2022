package com.Proyecto_DAW_2022_2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_DAW_2022_2.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
