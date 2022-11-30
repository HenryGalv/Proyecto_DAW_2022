package com.Proyecto_DAW_2022_2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Proyecto_DAW_2022_2.entity.Categoria;
import com.Proyecto_DAW_2022_2.entity.Cliente;
import com.Proyecto_DAW_2022_2.entity.Enlace;
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

@SessionAttributes({"ENLACES","USUARIO"})
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
	@Autowired
	private PostulanteService servPostulante;
	@Autowired
	private ClienteService servCliente;
	@Autowired
	private ReclamoService servReclamo;
	/*@Autowired
	private PedidoService servPedido;*/
	@RequestMapping("/Inicio")
	public String lista(Model model, Authentication auth) {
		String vLogin = auth.getName();
		Usuario u = servUsuario.loginUsuario(vLogin);
		List<Enlace> lista = servUsuario.enlacesDelUsuario(u.getRol().getId());
		model.addAttribute("USUARIO",u);
		model.addAttribute("ENLACES",lista);
		List<Postulante> postulantes = servPostulante.listarPostulantes();
		int cantPost = postulantes.size();
		List<Cliente> clientes = servCliente.listarClientes();
		int cantCli = clientes.size();
		List<Reclamo> reclamos = servReclamo.listarReclamo();
		int cantRecl = reclamos.size();
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
		model.addAttribute("cantPost", cantPost);
		model.addAttribute("cantCli", cantCli);
		model.addAttribute("cantRecl", cantRecl);
		model.addAttribute("cantUsu", cantUsu);
		model.addAttribute("cantPro", cantPro);
		model.addAttribute("cantCat", cantCat);
		model.addAttribute("cantMar", cantMar);
		model.addAttribute("cantEmp", cantEmp);
		return "inicio";
	}
}
