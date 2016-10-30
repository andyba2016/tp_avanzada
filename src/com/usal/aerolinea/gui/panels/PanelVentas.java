package com.usal.aerolinea.gui.panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.usal.aerolinea.negocio.dto.IOManager;
import com.usal.aerolinea.negocio.dto.Vuelo;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class PanelVentas extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtDniCliente;
	private JTextField txtAerolinea;
	private JTable tablaVuelos;
	private DefaultTableModel header;
	private ArrayList<Vuelo> ventas = new ArrayList<Vuelo>();
	private JButton btnNuevaVenta;
	private JButton btnModificarVenta;
	private JButton btnEliminarVenta;
	private JTextField txtNumeroVuelo;
	private JTextField txtFechaHoraPago;
	//private VueloDAO vueloDAO = new VueloDAOImpl();
	private JButton btnGenerarVenta;
	private JComboBox comboBoxFormaPago;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date date = new Date();
	ArrayList<JTextField> campos = new ArrayList<JTextField>();
	

	public PanelVentas() {
		setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		setLayout(new MigLayout("", "[][126.00px][112px][112px][112px][112px][grow]", "[50:n][36px][36px][36px][36px][36px][216.00]"));
		
		// LABELS PANEL VUELOS
		JLabel lblDatosVenta = new JLabel("Datos Venta");
		lblDatosVenta.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblDatosVenta, "cell 0 0,grow");
		JLabel lblDniCliente = new JLabel("DNI Cliente");
		add(lblDniCliente, "cell 0 1,alignx left,growy");
		JLabel lblNumeroVuelo = new JLabel("Nº de Vuelo");
		add(lblNumeroVuelo, "cell 2 1,alignx center,growy");
		JLabel lblAerolinea = new JLabel("Aerolinea");
		add(lblAerolinea, "cell 0 2,alignx left,growy");
		JLabel lblFechaHoraPago = new JLabel("Fecha-Hora Pago");
		add(lblFechaHoraPago, "cell 2 2,alignx center,growy");
		JLabel lblFechaHoraSalida = new JLabel("Forma de pago");
		add(lblFechaHoraSalida, "cell 0 3,alignx trailing,growy");
		
		
		// TEXTFIELDS PANEL VUELOS
		txtDniCliente = new JTextField();
		add(txtDniCliente, "cell 1 1,growx");
		txtDniCliente.setColumns(5);
		txtNumeroVuelo = new JTextField();
		add(txtNumeroVuelo, "cell 3 1,growx");
		txtNumeroVuelo.setColumns(10);
		txtFechaHoraPago = new JTextField();
		add(txtFechaHoraPago, "cell 3 2,growx");
		txtFechaHoraPago.setColumns(10);
		txtAerolinea = new JTextField();
		add(txtAerolinea, "cell 1 2,growx");
		txtAerolinea.setColumns(10);
		btnNuevaVenta = new JButton("Nueva venta");
		add(btnNuevaVenta, "cell 1 0,alignx center");
		btnNuevaVenta.addActionListener(this);
		btnModificarVenta = new JButton("Modificar venta");
		add(btnModificarVenta, "cell 2 0,alignx center");
		btnModificarVenta.addActionListener(this);
		btnEliminarVenta = new JButton("Eliminar venta");
		add(btnEliminarVenta, "cell 3 0,alignx center");
		btnEliminarVenta.addActionListener(this);
		
		comboBoxFormaPago = new JComboBox();
		add(comboBoxFormaPago, "cell 1 3,growx");
		JLabel lblVentas = new JLabel("Ventas");
		add(lblVentas, "cell 0 5,alignx left");
		
		
		// SCROLLPANE Y TABLE PANEL VENTAS
		String[] cols = {"DNI Cliente","Nº Vuelo","Aerolinea","Forma de pago"};
		header = new DefaultTableModel(cols, 0);
		btnGenerarVenta = new JButton("Generar venta");
		add(btnGenerarVenta, "cell 1 5,alignx center");
		btnGenerarVenta.addActionListener(this);
		btnGenerarVenta.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 6 7 1,grow");
		tablaVuelos = new JTable(header);
		scrollPane.setViewportView(tablaVuelos);
		
		campos.add(txtDniCliente);
		campos.add(txtNumeroVuelo);
		campos.add(txtFechaHoraPago);
		campos.add(txtAerolinea);	
		
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
		
		if(e.getSource() == btnNuevaVenta){
			IOManager.print("se abrio nuevo vuelo.");
			CamposManager.habilitarCampos(campos);
			txtFechaHoraPago.setText(dateFormat.format(date));
			btnGenerarVenta.setEnabled(true);
		}
		else if(e.getSource()== btnGenerarVenta){
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
		else if(e.getSource() == btnModificarVenta){
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
		else if(e.getSource()==btnEliminarVenta){
			
		}
		
		
	}

}
