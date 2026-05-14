package com.gestionpedidos;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	private List<Pedido> pedidos;
	
	public Cliente(String nombre, String email, String telefono) {
		super(nombre, email, telefono);
		this.pedidos= new ArrayList<>();
	}
	
	public List<Pedido> getPedidos(){
		return pedidos;
	}
	
	public void agregarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

}
