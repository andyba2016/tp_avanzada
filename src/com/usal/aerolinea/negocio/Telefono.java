package com.usal.aerolinea.negocio;

import java.io.Serializable;

public class Telefono implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nroPersonal;
	
	public Telefono(String celular) {
		super();
		this.celular = celular;
	}
	private String celular;
	private String nroLaboral;
	
	
	public String getNroPersonal() {
		return nroPersonal;
	}
	public void setNroPersonal(String nroPersonal) {
		this.nroPersonal = nroPersonal;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getNroLaboral() {
		return nroLaboral;
	}
	public void setNroLaboral(String nroLaboral) {
		this.nroLaboral = nroLaboral;
	}
	
	

}
