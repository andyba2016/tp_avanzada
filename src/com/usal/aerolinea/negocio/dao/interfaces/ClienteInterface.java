package com.usal.aerolinea.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.usal.aerolinea.negocio.dto.Cliente;

public interface ClienteInterface {
	
	public abstract boolean escribirClientes(ArrayList<Cliente> clientes) throws SQLException;
	public abstract ArrayList<Cliente> leerClientes() throws SQLException;
	

}
