package com.usal.aerolinea.negocio.Cliente;

import java.util.ArrayList;

import com.usal.aerolinea.negocio.IOManager;
import com.usal.aerolinea.persistencia.FileManagerCliente;

public class ClienteDAOImpleDb implements ClienteDAO{
	
	FileManagerCliente fmClientes = new FileManagerCliente();
	
	public ArrayList<Cliente> leerClientes(){
		
		return fmClientes.leer();
	}
	
	public boolean escribirClientes(ArrayList<Cliente> clientes){
		boolean ok = false;
		if(fmClientes.escribir(clientes)){
			IOManager.print("Se escribio OK");
			ok=true;
		}
		else{
			IOManager.print("Error al escribir");
		}
		return ok;
	}
	
	

}
