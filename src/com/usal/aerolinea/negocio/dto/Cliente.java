package com.usal.aerolinea.negocio.dto;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String dni;
	//private Pasaporte pasaporte;
	private String cuit;
	private Date fechaNac;
	private String email;
	private Telefono telefono;
	//private PasajeroFrecuente nroPasajeroFrecuente;
	
	public Cliente(){
		
	}
	
	public Cliente(String nombre, String apellido, String dni, String cuit, Date fechaNac, String email,
			Telefono telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuit = cuit;
		this.fechaNac = fechaNac;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
//	public Pasaporte getPasaporte() {
//		return pasaporte;
//	}
//	public void setPasaporte(Pasaporte pasaporte) {
//		this.pasaporte = pasaporte;
//	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
//	public PasajeroFrecuente getNroPasajeroFrecuente() {
//		return nroPasajeroFrecuente;
//	}
//	public void setNroPasajeroFrecuente(PasajeroFrecuente nroPasajeroFrecuente) {
//		this.nroPasajeroFrecuente = nroPasajeroFrecuente;
//	}
	
	

}
