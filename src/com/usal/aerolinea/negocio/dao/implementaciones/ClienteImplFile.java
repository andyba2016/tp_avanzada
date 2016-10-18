package com.usal.aerolinea.negocio.dao.implementaciones;

import java.sql.SQLException;
import java.util.ArrayList;

import com.usal.aerolinea.negocio.dao.interfaces.ClienteInterface;
import com.usal.aerolinea.negocio.dto.Cliente;
import com.usal.aerolinea.negocio.dto.IOManager;
import com.usal.aerolinea.persistencia.DBManagerCliente;
import com.usal.aerolinea.persistencia.FileManagerCliente;


public class ClienteImplFile implements ClienteInterface{

	//FileManagerCliente fmClientes = new FileManagerCliente();
	DBManagerCliente fmClientes = new DBManagerCliente();
	
	public ArrayList<Cliente> leerClientes(){
		
		try {
			return fmClientes.leer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean escribirClientes(ArrayList<Cliente> clientes){
		boolean ok = false;
		try {
			if(fmClientes.escribir(clientes)){
				IOManager.print("Se escribio OK");
				ok=true;
			}
			else{
				IOManager.print("Error al escribir");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	
	
	

}
