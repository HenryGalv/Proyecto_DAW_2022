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
import com.Proyecto_DAW_2022_2.services.CategoriaService;
import com.Proyecto_DAW_2022_2.services.MarcaService;

@Controller
@RequestMapping("/CategoriasMarcas")
public class MantenimientoMarcaCategoriaController {
	@Autowired
	private CategoriaService servCategoria;
	@Autowired
	private MarcaService servMarca;
	
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("categorias", servCategoria.listarCategorias());
		model.addAttribute("marcas", servMarca.listarMarcas());
		return "mantenimiento-categorias-marcas";
	}
	@RequestMapping("/buscarCategoria")
	@ResponseBody
	public Categoria buscaCategoria(@RequestParam("id") int id) {
		Categoria bean=servCategoria.buscar(id);
		return bean;
	}
	@RequestMapping("/buscarMarca")
	@ResponseBody
	public Marca buscarMarca(@RequestParam("id") int id) {
		Marca bean=servMarca.buscar(id);
		return bean;
	}
	@RequestMapping("/grabarCategoria")
	public String grabarCategoria(@RequestParam("id") int id,
									@RequestParam("nombre") String nombre,
									RedirectAttributes redirect) {
		try {
			Categoria bean = new Categoria();
			bean.setId(id);
			bean.setNombre(nombre);
			servCategoria.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Categoria registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Categoria actualizada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/grabarMarca")
	public String grabarMarca(@RequestParam("id") int id,
								@RequestParam("nombre") String nombre,
								RedirectAttributes redirect) {
		try {
			Marca bean = new Marca();
			bean.setId(id);
			bean.setNombre(nombre);
			servMarca.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Marca registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Marca actualizada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/eliminarCategoria")
	public String eliminarCategoria(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servCategoria.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Categoria eliminada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
	@RequestMapping("/eliminarMarca")
	public String eliminarMarca(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servMarca.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Marca eliminada");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/CategoriasMarcas/Lista";
	}
}
