package com.usal.aerolinea.gui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.usal.aerolinea.negocio.dto.Cliente;
import com.usal.aerolinea.negocio.dto.IOManager;
import com.usal.aerolinea.negocio.dto.LineaAerea;
import com.usal.aerolinea.negocio.dto.Telefono;

import net.miginfocom.swing.MigLayout;

public class PanelAereas extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreLinAerea;
	private JTextField txtAlianza;
	private JTable tablaLinAereas;
	private DefaultTableModel header;
	private ArrayList<LineaAerea> linAereas = new ArrayList<LineaAerea>();
	private JButton btnNuevaLinAerea;
	private JButton btnModificarLinAerea;
	private JButton btnEliminarLinAerea;
	private JButton btnAgregarLinAerea;
	private ArrayList<JTextField> campos = new ArrayList<JTextField>();
	
	
	public PanelAereas() {
		setBackground(SystemColor.textHighlight);
		setLayout(new MigLayout("", "[][112px][112px][112px][112px][112px][grow]", "[50:n][36px][36px][36px][216.00]"));
		
		// LABELS PANEL LINEAS AEREAS
		JLabel lblDatosAerea = new JLabel("Datos Linea Aerea");
		lblDatosAerea.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblDatosAerea, "cell 0 0,grow");
		JLabel lblNombreLAerea = new JLabel("Nombre");
		add(lblNombreLAerea, "cell 0 1,alignx left,growy");
		JLabel lblAlianza = new JLabel("Alianza");
		add(lblAlianza, "cell 0 2,alignx left,growy");
		
		
		// TEXTFIELDS PANEL LINEAS AEREAS
		txtNombreLinAerea = new JTextField();
		add(txtNombreLinAerea, "cell 1 1,growx");
		txtNombreLinAerea.setColumns(5);
		txtAlianza = new JTextField();
		add(txtAlianza, "cell 1 2,growx");
		txtAlianza.setColumns(10);
		
		// BUTTONS PANEL LINEAS AEREAS
		btnNuevaLinAerea = new JButton("Nueva L. Aerea");
		add(btnNuevaLinAerea, "cell 1 0,alignx center");
		btnNuevaLinAerea.addActionListener(this);
		btnModificarLinAerea = new JButton("Modificar L. Aerea");
		add(btnModificarLinAerea, "cell 2 0,alignx center");
		btnModificarLinAerea.addActionListener(this);
		btnEliminarLinAerea = new JButton("Eliminar L. Aerea");
		add(btnEliminarLinAerea, "cell 3 0,alignx center");
		btnEliminarLinAerea.addActionListener(this);
		btnAgregarLinAerea = new JButton("Agregar L. Aerea");
		add(btnAgregarLinAerea, "cell 1 3");
		btnAgregarLinAerea.addActionListener(this);
		
		// SCROLLPANE Y TABLE PANEL LINEAS AEREAS
		String[] cols = {"nombre","alianza","cantidad de vuelos"};
		header = new DefaultTableModel(cols, 0);
		JLabel lblLineasAereas = new JLabel("Líneas Aéreas");
		add(lblLineasAereas, "cell 0 3,alignx left");
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 4 3 1,grow");
		tablaLinAereas = new JTable(header);
		scrollPane.setViewportView(tablaLinAereas);
		
		campos.add(txtNombreLinAerea);
		campos.add(txtAlianza);
		
		CamposManager.deshabilitarCampos(campos);

	}
	
//	private void leerLinAereas(){
//		this.linAereas = linAereaDAO.leerClientes();
//	}
	
//	private void actualizarTabla(ArrayList<Cliente> clientes){
//		for (int i =0;i<clientes.size();i++){
//			Object[] c = {clientes.get(i).getNombre(),clientes.get(i).getApellido(),clientes.get(i).getDni(),
//					clientes.get(i).getCuit(), clientes.get(i).getEmail(), clientes.get(i).getTelefono()};
//			this.header.addRow(c);
//		}
//	}
	
	private LineaAerea leerInput() {
		LineaAerea linAerea = new LineaAerea();
		linAerea.setNombre(txtNombreLinAerea.getText());
		linAerea.setAlianza(txtAlianza.getText());
		
		return linAerea;
	}
	
	private void agregarLineaAerea(LineaAerea linAerea){
		int i;
		for(i=0; i<this.linAereas.size();i++);
		System.out.println("numero de lineas actual: " + i);
		
		this.linAereas.add(linAerea);
		
		for(i=0; i<this.linAereas.size();i++);
		System.out.println("numero de lineas luego: " + i);
			
	}
	
	private void limpiarTabla(){
		for (int i = 0; i < this.tablaLinAereas.getRowCount(); i++) {
			this.header.removeRow(i);
			i-=1;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNuevaLinAerea){
			IOManager.print("se abrio nuevo cliente.");
			CamposManager.habilitarCampos(campos);
			btnAgregarLinAerea.setEnabled(true);
		}
		else if(e.getSource()== btnAgregarLinAerea){
//			if(this.camposCompletos()){
//				LineaAerea nuevaLinAerea = this.leerInput();
//				this.agregarCliente(nuevoCliente);
//				if(clienteDAO.escribirClientes(clientes)){
//					JOptionPane.showMessageDialog(null, "Cliente agregado correctamente!");
//				}	
//			}
//			else{
//				JOptionPane.showMessageDialog(null, "Tiene campos incompletos. Pruebe nuevamente");
//			}
//			this.limpiarCampos();
//			this.deshabilitarCampos();
//			this.limpiarTabla();
//			this.actualizarTabla(this.clientes);
//			btnAgregarCliente.setEnabled(false);
		}
		else if(e.getSource() == btnModificarLinAerea){
//				this.setVisible(false);
//			try{
//				this.revalidate();
//				this.repaint();
//				this.getRootPane().getContentPane().add(panelModCliente);  ver si se puede abrir una ventana externa
//				panelModCliente.setVisible(true);
//				System.out.println("se abrio el panel de nuevo cliente.");
//				}catch(Exception exce){
//					System.out.println("Error"+exce.getCause());
//				}
		}
		else if(e.getSource()==btnEliminarLinAerea){
			
		}
		
	}

}
