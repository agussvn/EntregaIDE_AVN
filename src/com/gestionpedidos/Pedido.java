package com.gestionpedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private LocalDate fecha;
    private EstadoPedido estado;
    private Cliente cliente;
    private Repartidor repartidor;
    private List<Producto> productos; 

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.estado = EstadoPedido.PENDIENTE;
        this.cliente = cliente;
        this.repartidor = null;
        this.productos = new ArrayList<>();
        cliente.agregarPedido(this); 
    }
   
    public boolean agregarProducto(Producto nuevoProducto) {
        if (this.estado != EstadoPedido.PENDIENTE) {
            System.out.println("No se pueden añadir productos a un pedido que ya no está pendiente.");
            return false;
        }

        
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nuevoProducto.getNombre())) {
                System.out.println("El producto '" + nuevoProducto.getNombre() + "' ya está en el pedido (Duplicado detectado).");
                return false; 
            }
        }

        productos.add(nuevoProducto);
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void asignarRepartidor(Repartidor repartidor) {
        if (productos.isEmpty()) {
            System.out.println("Error: No se puede asignar repartidor a un pedido vacío.");
            return;
        }
        if (repartidor == null || !repartidor.isDisponible()) {
            System.out.println("Error: El repartidor no está disponible.");
            return;
        }
        if (this.estado != EstadoPedido.PENDIENTE) {
            System.out.println("Error: Solo se pueden asignar repartidores a pedidos PENDIENTES.");
            return;
        }

        this.repartidor = repartidor;
        this.estado = EstadoPedido.EN_REPARTO;
        repartidor.setDisponible(false); 
        System.out.println("Pedido " + id + " asignado a " + repartidor.getNombre() + ". Estado: EN REPARTO.");
    }

   
    public void entregarPedido() {
        if (this.estado != EstadoPedido.EN_REPARTO) {
            System.out.println("Error: No se puede entregar un pedido que no esté EN REPARTO.");
            return;
        }

        this.estado = EstadoPedido.ENTREGADO;
        if (this.repartidor != null) {
            this.repartidor.setDisponible(true); 
            System.out.println("Pedido " + id + " entregado con éxito. El repartidor " + repartidor.getNombre() + " vuelve a estar DISPONIBLE.");
        }
    }

    
    public int getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public EstadoPedido getEstado() { return estado; }
    public Cliente getCliente() { return cliente; }
    public Repartidor getRepartidor() { return repartidor; }
    public List<Producto> getProductos() { return productos; }
}