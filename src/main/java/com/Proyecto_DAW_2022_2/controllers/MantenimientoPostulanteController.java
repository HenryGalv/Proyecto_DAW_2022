package com.Proyecto_DAW_2022_2.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Proyecto_DAW_2022_2.entity.Ciudad;
import com.Proyecto_DAW_2022_2.entity.Departamento;
import com.Proyecto_DAW_2022_2.entity.Distrito;
import com.Proyecto_DAW_2022_2.entity.Postulante;
import com.Proyecto_DAW_2022_2.entity.Rol;
import com.Proyecto_DAW_2022_2.entity.TipoUsuario;
import com.Proyecto_DAW_2022_2.services.CiudadService;
import com.Proyecto_DAW_2022_2.services.DepartamentoService;
import com.Proyecto_DAW_2022_2.services.PostulanteService;

@Controller
@RequestMapping("/Postulantes")
public class MantenimientoPostulanteController {
	@Autowired
	private DepartamentoService servDepartamento;
	@Autowired
	private CiudadService servCiudad;
	@Autowired
	private PostulanteService servPostulante;
	
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("departamentos", servDepartamento.listarDepartamentos());
		model.addAttribute("postulantes", servPostulante.listarPostulantes());		
		return "mantenimiento-postulantes";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Postulante buscar(@RequestParam("id") int id) {
		Postulante bean=servPostulante.buscar(id);
		return bean;
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("id") int id,
						@RequestParam("nombre") String nombre,
						@RequestParam("apellido") String apellido,
						@RequestParam("experiencia") String experiencia,
						@RequestParam("cursos") String cursos,
						@RequestParam("idioma") String idioma,
						@RequestParam("correo") String correo,
						@RequestParam("phone") String celular,
						@RequestParam("fechaNacimiento") String fechaNac,
						@RequestParam("estado") int estado,
						@RequestParam("departamento") int idDep,
						@RequestParam("ciudad") int idCiu,
						@RequestParam("distrito") int idDis,
						@RequestParam("direccion") String direccion,
						RedirectAttributes redirect) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Postulante bean = new Postulante();
			bean.setId(id);
			bean.setNombre(nombre);
			bean.setApellido(apellido);
			bean.setIdioma(idioma);
			bean.setExperiencia(experiencia);
			bean.setCursos(cursos);
			bean.setCorreo(correo);
			bean.setCelular(celular);
			if(!(fechaNac =="")) bean.setFechaNac(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNac));
			bean.setEstado(estado);
			if(idDep != 0) {
				Departamento dep = new Departamento();
				dep.setId(idDep);
				bean.setDepartamento(dep);				
			}else bean.setDepartamento(null);
			if(idCiu != 0) {
				Ciudad ciu = new Ciudad();
				ciu.setId(idCiu);
				bean.setCiudad(ciu);			
			}else bean.setCiudad(null);
			if(idDis != 0) {
				Distrito dis = new Distrito();				
				dis.setId(idDis);
				bean.setDistrito(dis);
			}else bean.setDistrito(null);			
			bean.setDireccion(direccion);
			servPostulante.grabar(bean);
			if(id==0)
				redirect.addFlashAttribute("MENSAJE","Postulante registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Postulante actualizado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/Postulantes/Lista";
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id,RedirectAttributes redirect) {
		try {
			servPostulante.eliminar(id);
			redirect.addFlashAttribute("MENSAJE","Postulante eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/Postulantes/Lista";
	}
	@RequestMapping("/buscarPorDepartamento")
	@ResponseBody
	public List<Ciudad> buscarPorDepartamento(@RequestParam("id") int id) {
		List<Ciudad> data=servDepartamento.listarCiudadPorIdDepartamento(id);
		return data;
	}
	@RequestMapping("/buscarPorCiudad")
	@ResponseBody
	public List<Distrito> buscarPorCiudad(@RequestParam("id") int id) {
		List<Distrito> data=servCiudad.listarDistritoPorIdCiudad(id);
		return data;
	}
}
