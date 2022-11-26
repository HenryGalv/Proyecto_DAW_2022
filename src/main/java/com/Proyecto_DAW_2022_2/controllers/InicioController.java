package com.Proyecto_DAW_2022_2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_DAW_2022_2.entity.Categoria;
import com.Proyecto_DAW_2022_2.entity.Marca;
import com.Proyecto_DAW_2022_2.entity.Producto;
import com.Proyecto_DAW_2022_2.entity.Usuario;
import com.Proyecto_DAW_2022_2.services.CategoriaService;
import com.Proyecto_DAW_2022_2.services.MarcaService;
import com.Proyecto_DAW_2022_2.services.ProductoService;
import com.Proyecto_DAW_2022_2.services.UsuarioService;

@Controller
public class InicioController {
	@Autowired
	private UsuarioService servUsuario;
	@Autowired
	private ProductoService servProducto;
	@Autowired
	private CategoriaService servCategoria;
	@Autowired
	private MarcaService servMarca;
	@RequestMapping("/Inicio")
	public String lista(Model model) {
		List<Usuario> usuarios = servUsuario.listarUsuarios();
		int cantUsu = usuarios.size();
		List<Producto> productos = servProducto.listarProductos();
		int cantPro = productos.size();
		List<Categoria> categorias = servCategoria.listarCategorias();
		int cantCat = categorias.size();
		List<Marca> marcas = servMarca.listarMarcas();
		int cantMar = categorias.size();
		int cantEmp = 0;
		for(Usuario bean:usuarios) {
			if((bean.getTipoUsuario().getNombre().toString()).equals("EMPLEADO")) cantEmp++;
		}
		
		model.addAttribute("cantUsu", cantUsu);
		model.addAttribute("cantPro", cantPro);
		model.addAttribute("cantCat", cantCat);
		model.addAttribute("cantMar", cantMar);
		model.addAttribute("cantEmp", cantEmp);
		return "inicio";
	}
}
