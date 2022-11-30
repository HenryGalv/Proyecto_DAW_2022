package com.Proyecto_DAW_2022_2.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyecto_DAW_2022_2.entity.Cliente;
import com.Proyecto_DAW_2022_2.entity.Reclamo;
import com.Proyecto_DAW_2022_2.services.ClienteService;
import com.Proyecto_DAW_2022_2.services.ReclamoService;

@Controller
@RequestMapping("/Reclamos")
public class MantenimientoReclamoController {
	@Autowired
	private ReclamoService servReclamo;
	@Autowired
	private ClienteService serviceCliente;
	
	@RequestMapping("/Lista")
	public String lista(Model model) {
		
		model.addAttribute("reclamos",servReclamo.listarReclamo());
		model.addAttribute("clientes",serviceCliente.listarClientes());
		return "mantenimiento-reclamos";
		}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Reclamo buscar(@RequestParam("id") int id) {
		Reclamo bean=servReclamo.buscar(id);
		return bean;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id,
			            @RequestParam("fecha") String fecha,
						@RequestParam("descripcion") String descripcion,
						@RequestParam("cliente") int idcli,
						@RequestParam("estado") int estado,
						
						RedirectAttributes redirect) {
		try {
			Reclamo bean = new Reclamo();
			bean.setId(id);
			bean.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			bean.setDescripcion(descripcion);			
			bean.setEstado(estado);			
			Cliente cli = new Cliente();
			cli.setId(idcli);
			bean.setCliente(cli);			
			servReclamo.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Reclamo registrada");
			else
				redirect.addFlashAttribute("MENSAJE","Reclamo actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/Reclamos/Lista";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id, RedirectAttributes redirect) {
		try {
			servReclamo.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Reclamo eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/Reclamos/Lista";
	}
	
}
