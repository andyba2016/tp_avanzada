package com.usal.aerolinea.negocio.Cliente;

import java.util.ArrayList;

public interface ClienteDAO {
	
	public abstract boolean escribirClientes(ArrayList<Cliente> clientes);
	public abstract ArrayList<Cliente> leerClientes();
	

}
