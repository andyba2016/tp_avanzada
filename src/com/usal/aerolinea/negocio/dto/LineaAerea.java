package com.usal.aerolinea.negocio.dto;

import java.util.ArrayList;

public class LineaAerea {
	
	private String nombre;
	private String alianza;
	private ArrayList<Vuelo> vuelos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlianza() {
		return alianza;
	}
	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
