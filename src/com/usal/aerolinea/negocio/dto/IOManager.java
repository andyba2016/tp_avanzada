package com.usal.aerolinea.negocio.dto;

import java.util.*;

public class IOManager {

	
	public static String getCadena(){
		Scanner Scan = new Scanner(System.in);
		return Scan.nextLine();
	}
	
	public static String getCadena(int b){
		boolean ok=false;
		Scanner Scan = new Scanner(System.in);
		String a=Scan.nextLine();
		if (a.length()<=b){
			ok=true;
			return a;
			}else {
			IOManager.print("Debe Ingresar menor cantidad de caracteres");
			return getCadena(b);
		}
		
		
	}
	
	public static int getEntero(){
		
		Scanner Scan = new Scanner(System.in);
		
	while (!Scan.hasNextInt()){
		IOManager.print("Debe Ingresar un entero");
		Scan.nextLine();
	}
		return Scan.nextInt();
		
	}

	
	public static int getEntero(int nmin,int nmax){
		boolean ok=false;
		int n=0;
		while(!ok){
			 n = IOManager.getEntero();
			if(n<nmin || n>nmax){
				System.out.println("Debe ingresar un numero valido");
				}else{
					ok=true;
					}
			}
		return n;
	}
	
	public static int getEntero(int cmin, int cmid , int cmax){
		boolean ok=false;
		int n=0;
		while(!ok){
			 n = IOManager.getEntero();
			if(n!=cmin && n!=cmid && n!=cmax){
				System.out.println("Debe ingresar un numero valido");
				}else{
					ok=true;
					}
			}
		return n;
	}
	
	
	public static void print(String cadena){
		System.out.println(cadena);
	}
	
	public static void print(int n){// lo declaro Static para no tener que instanciar en c/clase IOManager IO = new IOManager();
		System.out.println(n);
	}
	
	/*public static void print(Auto auto){
		IOManager.print("*********************");
		System.out.println("Marca: "+ auto.getMarca());
		System.out.println("Modelo: "+ auto.getModelo());
		System.out.println("Kilometros: "+ auto.getKm());
		System.out.println("Dominio: "+ auto.getDominio());
		IOManager.print("*********************");
	}
	
	public static void print(Persona p){
		IOManager.print("*********************");
		System.out.println("Apellido: "+ p.getApellido());
		System.out.println("DNI: "+ p.getDni());
		IOManager.print("*********************");
	}*/
	
	public static float getFloat(){
		
		Scanner Scan = new Scanner(System.in);
		
	while (!Scan.hasNextFloat()){
		IOManager.print("Debe Ingresar un Flotante");
		Scan.nextLine();
	}
		return Scan.nextFloat();
		
	}
	
	
	public static void print(float n){
		System.out.println(n);
	}
	
}
