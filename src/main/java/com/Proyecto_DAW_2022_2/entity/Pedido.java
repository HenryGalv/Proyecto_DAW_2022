package com.Proyecto_DAW_2022_2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;
	@Column(name="precio_envio")
	private double precioEnvio;
	private int estado;
	
}
