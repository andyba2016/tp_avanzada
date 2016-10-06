package com.usal.aerolinea.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.usal.aerolinea.negocio.Telefono;
import com.usal.aerolinea.negocio.Cliente.Cliente;
import com.usal.aerolinea.negocio.Cliente.ClienteDAO;
import com.usal.aerolinea.negocio.Cliente.ClienteDAOImpl;

import java.awt.Dimension;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JMenuItem mntmAbmClientes;
	private JMenuItem mntmAbmAereas;
	private JMenuItem mntmAbmVuelos;
	private JMenuItem mntmAbmVentas;
	private JMenuItem mntmClientes;
	private JMenuItem mntmLineaAerea;
	private JMenuItem mntmVuelo;
	private JMenuItem mntmVenta;
	private JPanel panelClientes;
	private JPanel panelAereas;
	private JPanel panelVentas;
	private JPanel panelVuelos;

	public VentanaPrincipal() {
		
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setPreferredSize(new Dimension(900, 600));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmAbmClientes = new JMenuItem("ABM Clientes");
		mnArchivo.add(mntmAbmClientes);
		mntmAbmClientes.addActionListener(this);
		
		mntmAbmAereas = new JMenuItem("ABM Lineas Aereas");
		mnArchivo.add(mntmAbmAereas);
		mntmAbmAereas.addActionListener(this);
		
		mntmAbmVuelos= new JMenuItem("ABM Vuelos");
		mnArchivo.add(mntmAbmVuelos);
		mntmAbmVuelos.addActionListener(this);
		
		mntmAbmVentas = new JMenuItem("ABM Ventas");
		mnArchivo.add(mntmAbmVentas);
		mntmAbmVentas.addActionListener(this);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnArchivo.add(mnConsultas);
		mnConsultas.addActionListener(this);
		
		mntmClientes = new JMenuItem("Clientes");
		mnConsultas.add(mntmClientes);
		mntmClientes.addActionListener(this);
		
		mntmLineaAerea = new JMenuItem("Linea Aerea");
		mnConsultas.add(mntmLineaAerea);
		mntmLineaAerea.addActionListener(this);
		
		mntmVuelo = new JMenuItem("Vuelo");
		mnConsultas.add(mntmVuelo);
		mntmVuelo.addActionListener(this);
		
		mntmVenta = new JMenuItem("Venta");
		mnConsultas.add(mntmVenta);
		mntmVenta.addActionListener(this);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnAyuda.add(mntmSalir);
		
		panelClientes = new PanelClientes(VentanaPrincipal.this);
		panelAereas = new PanelAereas();
		panelVuelos = new PanelVuelos();
		panelVentas = new PanelVentas();
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		panelClientes.setVisible(false);
		panelAereas.setVisible(false);
		panelVuelos.setVisible(false);
		panelVentas.setVisible(false);
		
		if(e.getSource()==mntmAbmClientes){
			
			try{
				getContentPane().add(panelClientes);
				panelClientes.setVisible(true);
				//System.out.println("se abrio el panel de nuevo cliente.");
				}catch(Exception exce){
					System.out.println("Error"+exce.getCause());
				}
		}else if(e.getSource()==mntmAbmAereas){
			
			try{
				getContentPane().add(panelAereas);
				panelAereas.setVisible(true);
				//System.out.println("se abrio el panel de nueva linea aerea.");
				}catch(Exception exce){
					System.out.println("Error"+exce.getCause());
				}
		}else if(e.getSource()==mntmAbmVuelos){
			
			try{
				getContentPane().add(panelVuelos);
				panelVuelos.setVisible(true);
				//System.out.println("se abrio el panel de nuevo vuelo.");
				}catch(Exception exce){
					System.out.println("Error"+exce.getCause());
				}
		}else if(e.getSource()==mntmAbmVentas){
			
			try{
				getContentPane().add(panelVentas);
				panelVentas.setVisible(true);
				//System.out.println("se abrio el panel de nueva venta.");
				}catch(Exception exce){
					System.out.println("Error"+exce.getCause());
				}
		}
		
	}

}
