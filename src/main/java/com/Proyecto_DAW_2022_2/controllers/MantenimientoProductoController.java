package com.Proyecto_DAW_2022_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyecto_DAW_2022_2.entity.Categoria;
import com.Proyecto_DAW_2022_2.entity.Marca;
import com.Proyecto_DAW_2022_2.entity.Producto;
import com.Proyecto_DAW_2022_2.services.CategoriaService;
import com.Proyecto_DAW_2022_2.services.MarcaService;
import com.Proyecto_DAW_2022_2.services.ProductoService;

@Controller
@RequestMapping("/Productos")
public class MantenimientoProductoController {
	@Autowired
	private CategoriaService servCategoria;
	@Autowired
	private MarcaService servMarca;
	@Autowired
	private ProductoService servProducto;
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("categorias", servCategoria.listarCategorias());
		model.addAttribute("marcas", servMarca.listarMarcas());
		model.addAttribute("productos",servProducto.listarProductos());
		return "mantenimiento-productos";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Producto buscar(@RequestParam("id") int id) {
		Producto bean=servProducto.buscar(id);
		return bean;
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id,
						@RequestParam("nombre") String nombre,
						@RequestParam("descripcion") String descripcion,
						@RequestParam("precio") double precio,
						@RequestParam("stock") int stock,
						@RequestParam("estado") int estado,
						@RequestParam("categoria") int idCat,
						@RequestParam("marca") int idMar,
						RedirectAttributes redirect) {
		try {
			Producto bean = new Producto();
			bean.setId(id);
			bean.setNombre(nombre);
			bean.setDescripcion(descripcion);
			bean.setPrecio(precio);
			bean.setEstado(estado);
			bean.setStock(stock);
			Categoria cat = new Categoria();
			cat.setId(idCat);
			bean.setCategoria(cat);
			Marca mar = new Marca();
			mar.setId(idMar);
			bean.setMarca(mar);
			servProducto.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Producto registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Producto actualizada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/Productos/Lista";
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		try {
			servProducto.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Producto eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/Productos/Lista";
	}
}
