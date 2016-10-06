package com.usal.aerolinea.negocio;

import java.util.Date;

public class Pasaporte {
	
	private String nroPasaporte;
	private String paisEmision;
	private String autoridadEmision;
	private Date fechaEmision;
	private Date fechaVto;
	
	
	public String getNroPasaporte() {
		return nroPasaporte;
	}
	public void setNroPasaporte(String nroPasaporte) {
		this.nroPasaporte = nroPasaporte;
	}
	public String getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(String paisEmision) {
		this.paisEmision = paisEmision;
	}
	public String getAutoridadEmision() {
		return autoridadEmision;
	}
	public void setAutoridadEmision(String autoridadEmision) {
		this.autoridadEmision = autoridadEmision;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVto() {
		return fechaVto;
	}
	public void setFechaVto(Date fechaVto) {
		this.fechaVto = fechaVto;
	}
	

}
