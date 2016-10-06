package com.usal.aerolinea.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.usal.aerolinea.negocio.IOManager;
import com.usal.aerolinea.negocio.Cliente.Cliente;

public class FileManagerCliente {
	
	private String ruta = "clientes.dat";
	
	
	public ArrayList<Cliente> leer(){
		
		File file = new File(ruta);
		FileInputStream fileInput = null;
		ObjectInputStream objInput = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			if(!file.exists()){
				IOManager.print("ERROR: No existe el archivo. No hay datos para leer.");
			}else{
				fileInput = new FileInputStream(file);
				objInput = new ObjectInputStream(fileInput);
				clientes = (ArrayList<Cliente>) objInput.readObject();
			}
				
		}catch(Exception e){
			IOManager.print("ERROR: No se pudo leer los datos.");
		
		} finally {
			try{
				if(objInput!=null){
					objInput.close();
					fileInput.close();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return clientes;
	}
	
	public boolean escribir(ArrayList<Cliente> clientes){
		FileOutputStream fileOut=null;
		ObjectOutputStream objOut=null;
		File file = new File(ruta);
		boolean ok = false;
		
		try {
				if(!file.exists()){
					file.createNewFile();
					IOManager.print("Se creo un nuevo archivo. OK");
				}else{
					IOManager.print("Archivo ya existente.");
				}
				fileOut = new FileOutputStream(file);
				objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(clientes);
				ok=true;
				
			}catch (IOException e){
					IOManager.print("No existe el archivo. Error al crear archivo");
					e.printStackTrace();
			}finally{
				try {
					objOut.close();
					fileOut.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		return ok;
		
	}
}
