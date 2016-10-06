package com.usal.aerolinea.negocio.Cliente;

import java.util.ArrayList;

import com.usal.aerolinea.negocio.IOManager;
import com.usal.aerolinea.persistencia.FileManagerCliente;


public class ClienteDAOImpl implements ClienteDAO{

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
	
	/*
	public void mostrarTodos(){
		
		for(int i=0;i<this.clientes.size();i++){
			Cliente cliente = this.clientes.get(i);
			//IOManager.print(auto);
		}
		
	}
	
	public void mostrarPorMarca(String marca){
		
		for(int i=0;i<this.autos.size();i++){
			Auto auto = this.autos.get(i);
			if(auto.getMarca().equals(marca)){
				IOManager.print(auto);
			}	
		}
	}
	
	public void mostrarPorKm(int km){
		
		for(int i=0;i<this.autos.size();i++){
			Auto auto = this.autos.get(i);
			if(auto.getKm()<=km){
				IOManager.print(auto);
			}	
		}
	}
	
	public void mostrarMayorKm(){
		int mayor =-1;
		Auto autoMayor = null;
		for(int i=0;i<this.autos.size();i++){
			Auto auto = this.autos.get(i);
			if(auto.getKm()>mayor){
				autoMayor = auto;
			}	
		}
		if(autoMayor == null){
			IOManager.print("error al mostrar mayor auto");
		}
		else{
			IOManager.print(autoMayor);
		}
	}
	
	public void mostrarMenoraMayorKm(){
		
		ArrayList<Auto> autosOrdenados = new ArrayList<Auto>();
		autosOrdenados.addAll(this.autos);
		Auto autoAux = new Auto();
		for(int i=0;i<(autosOrdenados.size())-1;i++){
			for(int j=i+1;j<autosOrdenados.size();j++){
				if(autosOrdenados.get(i).getKm()>autosOrdenados.get(j).getKm()){
					autoAux = autosOrdenados.get(i);
					autosOrdenados.set(i, autosOrdenados.get(j));
					autosOrdenados.set(j, autoAux);
				}
			}
		}
		
		for(int i=0;i<autosOrdenados.size();i++){
			IOManager.print(autosOrdenados.get(i));
		}
	}
	
	public boolean agregarAuto(Auto auto){
		if(!this.existe(auto.getDominio())){
			this.autos.add(auto);
			this.escribirAutos(this.autos);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean modificarAuto(String dom){
		boolean bandera = false;
		if(this.existe(dom)){
			IOManager.print("Ingrese marca: ");
			String nuevaMarca = IOManager.getCadena();
			IOManager.print("Ingrese modelo: ");
			String nuevoModelo = IOManager.getCadena();
			IOManager.print("Ingrese km: ");
			int nuevoKm = IOManager.getEntero(0, 500000);
			IOManager.print("Ingrese dominio: ");
			String nuevoDominio = IOManager.getCadena();
			Auto autoNuevo = new Auto(nuevaMarca,nuevoModelo,nuevoKm,nuevoDominio);
			
			for(int i=0;i<this.autos.size();i++){
				if(this.autos.get(i).getDominio().equals(dom)){
					this.autos.set(i, autoNuevo);
					bandera = true;
				}
			}
			this.escribirAutos(this.autos);
		}
		return bandera;
		
	}
	
	public boolean eliminarAuto(String dom){
		boolean bandera=false;
		int rem = -1;
		if(this.existe(dom)){
			for(int i=0;i<this.autos.size();i++){
				if(this.autos.get(i).getDominio().equals(dom)){
					bandera=true;
					 rem = i;
//					for(int j=i+1;j<this.autos.size();j++){
//						this.autos.set(i, this.autos.get(j));
//					}
				}	
			}
		}
		this.autos.remove(rem);
		this.escribirAutos(this.autos);
		return bandera;
	}

	public boolean existe(String dom){
		
		for(int i=0;i<this.autos.size();i++){
			if(this.autos.get(i).getDominio().equals(dom)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean buscarPatente(Persona p){
		
		if(this.existe(p.getPatente())){
			for(int i=0;i<this.autos.size();i++){
				if(this.autos.get(i).getDominio().equals(p.getPatente())){
					IOManager.print(p);
					IOManager.print(this.autos.get(i));
					return true;
				}	
			}
		}
		return false;
	}
	
	*/
	

}
