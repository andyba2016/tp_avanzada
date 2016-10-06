package com.usal.aerolinea.presentacion;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.usal.aerolinea.negocio.IOManager;
import com.usal.aerolinea.negocio.Telefono;
import com.usal.aerolinea.negocio.Vuelo;
import com.usal.aerolinea.negocio.Cliente.Cliente;
import com.usal.aerolinea.negocio.Cliente.ClienteDAO;
import com.usal.aerolinea.negocio.Cliente.ClienteDAOImpl;

import net.miginfocom.swing.MigLayout;

public class PanelVuelos extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroVuelo;
	private JTextField txtAeropSalida;
	private JTable tablaVuelos;
	private DefaultTableModel header;
	private ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
	private JButton btnNuevoVuelo;
	private JButton btnModificarVuelo;
	private JButton btnEliminarVuelo;
	private JTextField txtCantAsientos;
	private JTextField txtAeropLlegada;
	private JTextField txtFechaHoraSalida;
	private JTextField txtTurnaround;
	private JTextField txtFechaHoraLlegada;
	//private VueloDAO vueloDAO = new VueloDAOImpl();
	private JButton btnAgregarVuelo;
	private ArrayList<JTextField> campos = new ArrayList<JTextField>();

	public PanelVuelos() {
		setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		setLayout(new MigLayout("", "[][112px][112px][112px][112px][112px][grow]", "[50:n][36px][36px][36px][36px][36px][216.00]"));
		
		// LABELS PANEL VUELOS
		JLabel lblDatosVuelo = new JLabel("Datos Vuelo");
		lblDatosVuelo.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblDatosVuelo, "cell 0 0,grow");
		JLabel lblNumeroVuelo = new JLabel("Numero");
		add(lblNumeroVuelo, "cell 0 1,alignx center,growy");
		JLabel lblCantAsientos = new JLabel("Cantidad Asientos");
		add(lblCantAsientos, "cell 2 1,alignx center,growy");
		JLabel lblAeropSalida = new JLabel("Aeropuerto Salida");
		add(lblAeropSalida, "cell 0 2,alignx center,growy");
		JLabel lblAeropLlegada = new JLabel("Aeropuerto Llegada");
		add(lblAeropLlegada, "cell 2 2,alignx center,growy");
		JLabel lblFechaHoraSalida = new JLabel("Fecha-Hora Salida");
		add(lblFechaHoraSalida, "cell 0 3,alignx center,growy");
		JLabel lblFechaHoraLlegada = new JLabel("Fecha-Hora Llegada");
		add(lblFechaHoraLlegada, "cell 2 3,alignx center,growy");
		JLabel lblTurnaround = new JLabel("Turnaround");
		add(lblTurnaround, "cell 0 4,alignx center,growy");
		
		
		// TEXTFIELDS PANEL VUELOS
		txtNumeroVuelo = new JTextField();
		add(txtNumeroVuelo, "cell 1 1,growx");
		txtNumeroVuelo.setColumns(5);
		txtCantAsientos = new JTextField();
		add(txtCantAsientos, "cell 3 1,growx");
		txtCantAsientos.setColumns(10);
		txtAeropLlegada = new JTextField();
		add(txtAeropLlegada, "cell 3 2,growx");
		txtAeropLlegada.setColumns(10);
		txtAeropSalida = new JTextField();
		add(txtAeropSalida, "cell 1 2,growx");
		txtAeropSalida.setColumns(10);
		txtFechaHoraSalida = new JTextField();
		add(txtFechaHoraSalida, "cell 1 3,growx");
		txtFechaHoraSalida.setColumns(10);
		txtFechaHoraLlegada = new JTextField();
		add(txtFechaHoraLlegada, "cell 3 3,growx");
		txtFechaHoraLlegada.setColumns(10);
		txtTurnaround = new JTextField();
		add(txtTurnaround, "cell 1 4,growx");
		txtTurnaround.setColumns(10);
		btnNuevoVuelo = new JButton("Nuevo Vuelo");
		add(btnNuevoVuelo, "cell 1 0,alignx center");
		btnNuevoVuelo.addActionListener(this);
		btnModificarVuelo = new JButton("Modificar Vuelo");
		add(btnModificarVuelo, "cell 2 0,alignx center");
		btnModificarVuelo.addActionListener(this);
		btnEliminarVuelo = new JButton("Eliminar Vuelo");
		add(btnEliminarVuelo, "cell 3 0,alignx center");
		btnEliminarVuelo.addActionListener(this);
		JLabel lblVuelos = new JLabel("Vuelos");
		add(lblVuelos, "cell 0 5,alignx center");
		
		
		// SCROLLPANE Y TABLE PANEL VUELOS
		String[] cols = {"Nº de vuelo","Salida","Llegada","Hora salida", "Hora llegada", "turnaround"};
		header = new DefaultTableModel(cols, 0);
		btnAgregarVuelo = new JButton("Agregar Vuelo");
		add(btnAgregarVuelo, "cell 1 5,alignx center");
		btnAgregarVuelo.addActionListener(this);
		btnAgregarVuelo.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 6 7 1,grow");
		tablaVuelos = new JTable(header);
		scrollPane.setViewportView(tablaVuelos);
		
		campos.add(txtNumeroVuelo);
		campos.add(txtAeropSalida);
		campos.add(txtCantAsientos);
		campos.add(txtAeropLlegada);
		campos.add(txtFechaHoraSalida);
		campos.add(txtTurnaround);
		campos.add(txtFechaHoraLlegada);
		
		CamposManager.deshabilitarCampos(campos);
//		this.leerClientes();
//		actualizarTabla(clientes);
		
		
//		panelModCliente = new PanelModificarCliente();

	}
	
//	private void leerClientes(){
//		this.clientes = clienteDAO.leerClientes();
//	}
	
//	private void actualizarTabla(ArrayList<Cliente> clientes){
//		for (int i =0;i<clientes.size();i++){
//			Object[] c = {clientes.get(i).getNombre(),clientes.get(i).getApellido(),clientes.get(i).getDni(),
//					clientes.get(i).getCuit(), clientes.get(i).getEmail(), clientes.get(i).getTelefono()};
//			this.header.addRow(c);
//		}
//	}

//	private boolean camposCompletos(){
//		if(txtNumeroVuelo.getText().length()==0 || txtCantAsientos.getText().length()==0 || 
//				txtAeropSalida.getText().length()==0 || txtTelCliente.getText().length()==0 || txtFechaHoraSalida.getText().length()==0 || txtTurnaround.getText().length()==0){
//			return false;
//		}
//		else
//		{
//			System.out.println("campos validos");
//			return true;
//		}
//	} 
//	
//	private Cliente leerInput() {
//		Cliente c = new Cliente();
//		c.setNombre(txtNumeroVuelo.getText());
//		c.setApellido(txtCantAsientos.getText());
//		c.setDni(txtAeropSalida.getText());
//		c.setTelefono(new Telefono(txtTelCliente.getText()));
//		c.setCuit(txtFechaHoraSalida.getText());
//		c.setEmail(txtTurnaround.getText());
//		
//		return c;
//	}
//	
//	private void agregarCliente(Cliente c){
//		int i;
//		for(i=0; i<this.clientes.size();i++);
//		System.out.println("numero de personas actual: " + i);
//		
//		this.clientes.add(c);
//		
//		for(i=0; i<this.clientes.size();i++);
//		System.out.println("numero de personas luego: " + i);
//			
//	}
	
//	private void limpiarTabla(){
//		for (int i = 0; i < this.tablaClientes.getRowCount(); i++) {
//			this.header.removeRow(i);
//			i-=1;
//		}
//	}
//	

	// LISTENERS
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNuevoVuelo){
			IOManager.print("se abrio nuevo vuelo.");
			CamposManager.habilitarCampos(campos);
			btnAgregarVuelo.setEnabled(true);
		}
		else if(e.getSource()== btnAgregarVuelo){
//			if(this.camposCompletos()){
//				Cliente nuevoCliente = this.leerInput();
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
//			btnAgregarVuelo.setEnabled(false);
		}
		else if(e.getSource() == btnModificarVuelo){
//				this.setVisible(false);
//			try{
//				this.revalidate();
//				this.repaint();
//				this.getRootPane().getContentPane().add(panelModCliente);
//				panelModCliente.setVisible(true);
//				System.out.println("se abrio el panel de nuevo cliente.");
//				}catch(Exception exce){
//					System.out.println("Error"+exce.getCause());
//				}
		}
		else if(e.getSource()==btnEliminarVuelo){
			
		}
		
		
	}

}
