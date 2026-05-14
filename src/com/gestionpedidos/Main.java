package com.gestionpedidos;

public class Main {
	public static void main (String[] args) {
		 
		Cliente cliente = new Cliente("Joshua Anthony", "josh@email.com", "4747575487");
		Repartidor repartidor = new Repartidor("Lucía Lousa", "LuciaL@gmail.com","43747374","Zona Centro");
		
		
		Producto hamburguesa = new Producto("Hamburguesa Completa",8.50,"Comida");
		Producto patatas = new Producto("Patatas Fritas",5.50,"Comida");
	
		
		System.out.println("--- Creando Pedido ---");
        Pedido pedido1 = new Pedido(101, cliente);

      
        pedido1.asignarRepartidor(repartidor);

      
        pedido1.agregarProducto(hamburguesa);
        pedido1.agregarProducto(patatas);
        
       
        pedido1.agregarProducto(hamburguesa); 

        System.out.println("Total del pedido: " + pedido1.calcularTotal() + "€");

        System.out.println("\n--- Proceso de Reparto ---");
     
        pedido1.entregarPedido();

        
        pedido1.asignarRepartidor(repartidor);

        
        Cliente cliente2 = new Cliente("Luis", "luis@email.com", "622111222");
        Pedido pedido2 = new Pedido(102, cliente2);
        pedido2.agregarProducto(patatas);
        pedido2.asignarRepartidor(repartidor); 

       
        pedido1.entregarPedido();

      
        pedido2.asignarRepartidor(repartidor);
    }
}
		
		