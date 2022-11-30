package com.Proyecto_DAW_2022_2.controllers;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_DAW_2022_2.entity.Categoria;
import com.Proyecto_DAW_2022_2.entity.Cliente;
import com.Proyecto_DAW_2022_2.entity.Marca;
import com.Proyecto_DAW_2022_2.entity.Postulante;
import com.Proyecto_DAW_2022_2.entity.Producto;
import com.Proyecto_DAW_2022_2.entity.Reclamo;
import com.Proyecto_DAW_2022_2.entity.Usuario;
import com.Proyecto_DAW_2022_2.services.CategoriaService;
import com.Proyecto_DAW_2022_2.services.ClienteService;
import com.Proyecto_DAW_2022_2.services.MarcaService;
import com.Proyecto_DAW_2022_2.services.PostulanteService;
import com.Proyecto_DAW_2022_2.services.ProductoService;
import com.Proyecto_DAW_2022_2.services.ReclamoService;
import com.Proyecto_DAW_2022_2.services.UsuarioService;
import com.Proyecto_DAW_2022_2.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	@Autowired
	private ClienteService servCliente;
	@Autowired
	private ProductoService servProd;
	@Autowired
	private UsuarioService servUsuario;
	@Autowired
	private CategoriaService servCategoria;
	@Autowired
	private MarcaService servMarca;
	@Autowired
	private PostulanteService servPostulante;
	@Autowired
	private ReclamoService servReclamo;
	
	@RequestMapping("/cliente")
	public void inicio (HttpServletResponse response) {
		try {
			List<Cliente> data = servCliente.listarClientes();
			//
			File file= ResourceUtils.getFile("classpath:reporte_clientes.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/producto")
	public void inicio2 (HttpServletResponse response) {
		try {
			List<Producto> data = servProd.listarProductos();
			//
			File file= ResourceUtils.getFile("classpath:reporte_productos.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/usuarios")
	public void inicio3 (HttpServletResponse response) {
		try {
			List<Usuario> data = servUsuario.listarUsuarios() ;
			//
			File file= ResourceUtils.getFile("classpath:reporte_usuarios.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/categorias")
	public void inicio4 (HttpServletResponse response) {
		try {
			List<Categoria> data = servCategoria.listarCategorias() ;
			//
			File file= ResourceUtils.getFile("classpath:reporte_categorias.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/marcas")
	public void inicio5 (HttpServletResponse response) {
		try {
			List<Marca> data = servMarca.listarMarcas() ;
			//
			File file= ResourceUtils.getFile("classpath:reporte_marcas.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/postulantes")
	public void inicio6 (HttpServletResponse response) {
		try {
			List<Postulante> data = servPostulante.listarPostulantes() ;
			//
			File file= ResourceUtils.getFile("classpath:reporte_postulantes.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/reclamos")
	public void inicio7 (HttpServletResponse response) {
		try {
			List<Reclamo> data = servReclamo.listarReclamo() ;
			//
			File file= ResourceUtils.getFile("classpath:reporte_reclamos.jrxml");
			//
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
			//
			JasperPrint print= Libreria.generarReporte(file, info);
			//
			response.setContentType("application/pdf");	
			//
			OutputStream salida= response.getOutputStream();
			//
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
