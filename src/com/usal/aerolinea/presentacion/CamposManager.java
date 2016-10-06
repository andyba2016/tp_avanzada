package com.usal.aerolinea.presentacion;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

// clase que se encarga del manejo de campos en paneles

public final class CamposManager {
	
	private CamposManager(){
		
	}
	
	// tiene que ser visible por las demas (dentro del paquete)
	static boolean camposCompletos(ArrayList<JTextField> campos){
		
		for(int i=0;i<campos.size();i++){
			if(campos.get(i).getText().length()==0){
				return false;
			}
		}
		return true;
	}
	
	static void limpiarCampos(ArrayList<JTextField> campos) {
		
		for(int i=0;i<campos.size();i++){
			campos.get(i).setText(null);
		}
		
	}
	
	static void habilitarCampos(ArrayList<JTextField> campos){
		
		for(int i=0;i<campos.size();i++){
			campos.get(i).setEnabled(true);
			campos.get(i).setBackground(Color.WHITE);
		}
		
	}
	
	static void deshabilitarCampos(ArrayList<JTextField> campos){
		
		for(int i=0;i<campos.size();i++){
			campos.get(i).setEnabled(false);
			campos.get(i).setBackground(Color.LIGHT_GRAY);
		}
	}
	

}
