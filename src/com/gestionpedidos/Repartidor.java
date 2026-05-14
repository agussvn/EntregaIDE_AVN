package com.gestionpedidos;

public class Repartidor extends Usuario {
	private String zonaReparto;
	private boolean disponible;
	
	public Repartidor(String nombre, String email, String telefono, String zonaReparto) {
		super(nombre, email, telefono);
		this.zonaReparto=zonaReparto;
		this.disponible=true;
	}
	
	public String getZonaReparto() { return zonaReparto; }
    public void setZonaReparto(String zonaReparto) { this.zonaReparto = zonaReparto; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
