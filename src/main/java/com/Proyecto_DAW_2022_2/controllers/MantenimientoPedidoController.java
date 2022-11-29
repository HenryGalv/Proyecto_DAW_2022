package com.Proyecto_DAW_2022_2.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Proyecto_DAW_2022_2.entity.Cliente;
import com.Proyecto_DAW_2022_2.entity.DetallePedido;
import com.Proyecto_DAW_2022_2.services.ClienteService;
import com.Proyecto_DAW_2022_2.services.ProductoService;

@Controller
@RequestMapping("/Pedidos")
public class MantenimientoPedidoController {
	
	@Autowired
	private ProductoService servProducto;
	@Autowired
	private ClienteService servCliente;
	@RequestMapping("/Lista")
	public String lista(Model model) {
		model.addAttribute("productos",servProducto.listarProductos());
		return "mantenimiento-pedidos";
	}
	@RequestMapping("/Registrar")
	public String registrarPedido(Model model) {
		model.addAttribute("productos",servProducto.listarProductos());
		return "registro-pedido";
	}

	@RequestMapping("/adicionar")
	@ResponseBody
	public List<DetallePedido> adicionar(@RequestParam("id") int id, 
							@RequestParam("nombre")String nom,
							@RequestParam("precio")double pre,
							@RequestParam("cantidad")int cantidad,
							HttpSession session) {
		List<DetallePedido> data =null;
		if(session.getAttribute("carrito")==null)
			data = new ArrayList<DetallePedido>();
		else
			data = (List<DetallePedido>) session.getAttribute("carrito");
		DetallePedido bean = new DetallePedido();
		bean.setId(id);
		bean.setNombre(nom);
		bean.setPrecio(pre);
		bean.setCantidad(cantidad);		
		data.add(bean);
		session.setAttribute("carrito",data);		
		return data;
	}
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<DetallePedido> eliminar(@RequestParam("id") int id, HttpSession session){
		List<DetallePedido> data = (List<DetallePedido>) session.getAttribute("carrito");
		for (DetallePedido d:data) {
			if(d.getId()==id) {
				data.remove(d);
				break;
			}
		}
		session.setAttribute("carrito", data);
		return data;
	}
	@RequestMapping("/listarClientes")
	@ResponseBody
	public List<Cliente> listarClientes(@RequestParam("apellido") String ape){
		List<Cliente> data = servCliente.listarClientesPorApellido(ape + "%");
		return data;
	}
}
