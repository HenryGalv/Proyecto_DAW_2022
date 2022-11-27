package com.Proyecto_DAW_2022_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_DAW_2022_2.services.ProductoService;

@Controller
@RequestMapping("/Pedidos")
public class MantenimientoPedidoController {
	
	@Autowired
	private ProductoService servProducto;
	
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("productos",servProducto.listarProductos());
		return "mantenimiento-productos";
	}
	
}
