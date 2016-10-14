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
import com.usal.aerolinea.negocio.Cliente.Cliente;
import com.usal.aerolinea.negocio.Cliente.ClienteDAO;
import com.usal.aerolinea.negocio.Cliente.ClienteDAOImpl;

import net.miginfocom.swing.MigLayout;

public class PanelClientes extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreCliente;
	private JTextField txtDniCliente;
	private JTable tablaClientes;
	private DefaultTableModel header;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JButton btnNuevoCliente;
	private JButton btnModificarCliente;
	private JButton btnEliminarCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtNacCliente;
	private JTextField txtCuitCliente;
	private JTextField txtEmailCliente;
	private JTextField txtTelCliente;
	private JTextField txtPasaporteCliente;
	private JTextField txtPasajeroFrec;
	private JTextField txtDirCliente;
	private ClienteDAO clienteDAO = new ClienteDAOImpl();
	private JButton btnAgregarCliente;
	private ModificarCliente modCliente;
	private ArrayList<JTextField> campos = new ArrayList<JTextField>();
	
	public PanelClientes(VentanaPrincipal ppal) {
		setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		setLayout(new MigLayout("", "[][112px][112px][112px][112px][112px][grow]", "[50:n][36px][36px][36px][36px][36px][36px][36px][216.00]"));
		
		
		// LABELS PANEL CLIENTE
		JLabel lblDatosCliente = new JLabel("Datos Cliente");
		lblDatosCliente.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(lblDatosCliente, "cell 0 0,grow");
		JLabel lblNombreCliente = new JLabel("Nombre");
		add(lblNombreCliente, "cell 0 1,alignx center,growy");
		JLabel lblApellidoCliente = new JLabel("Apellido");
		add(lblApellidoCliente, "cell 2 1,alignx center,growy");
		JLabel lblDniCliente = new JLabel("DNI");
		add(lblDniCliente, "cell 0 2,alignx center,growy");
		JLabel lblFechaNac = new JLabel("Fecha Nac");
		add(lblFechaNac, "cell 2 2,alignx center,growy");
		JLabel lblCuitCliente = new JLabel("Cuit");
		add(lblCuitCliente, "cell 0 3,alignx center,growy");
		JLabel lblPasaporteCliente = new JLabel("Pasaporte");
		add(lblPasaporteCliente, "cell 2 3,alignx center,growy");
		JLabel lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		add(lblPasajeroFrecuente, "cell 2 4,alignx center,growy");
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "cell 0 4,alignx center,growy");
		JLabel lblTelefono = new JLabel("Telefono");
		add(lblTelefono, "cell 0 5,alignx center,growy");
		JLabel lblDireccionCliente = new JLabel("Direccion");
		add(lblDireccionCliente, "cell 2 5,alignx center,growy");
		JLabel lblClientes = new JLabel("Clientes");
		add(lblClientes, "cell 0 7,alignx center");
		
		
		// TEXTFIELDS PANEL CLIENTES
		txtNombreCliente = new JTextField();
		add(txtNombreCliente, "cell 1 1,growx");
		txtNombreCliente.setColumns(5);
		txtApellidoCliente = new JTextField();
		add(txtApellidoCliente, "cell 3 1,growx");
		txtApellidoCliente.setColumns(10);
		txtNacCliente = new JTextField();
		add(txtNacCliente, "cell 3 2,growx");
		txtNacCliente.setColumns(10);
		txtDniCliente = new JTextField();
		add(txtDniCliente, "cell 1 2,growx");
		txtDniCliente.setColumns(10);
		txtCuitCliente = new JTextField();
		add(txtCuitCliente, "cell 1 3,growx");
		txtCuitCliente.setColumns(10);
		txtPasaporteCliente = new JTextField();
		add(txtPasaporteCliente, "cell 3 3,growx");
		txtPasaporteCliente.setColumns(10);
		txtEmailCliente = new JTextField();
		add(txtEmailCliente, "cell 1 4,growx");
		txtEmailCliente.setColumns(10);
		txtPasajeroFrec = new JTextField();
		add(txtPasajeroFrec, "cell 3 4,growx");
		txtPasajeroFrec.setColumns(10);
		txtTelCliente = new JTextField();
		add(txtTelCliente, "cell 1 5,growx");
		txtTelCliente.setColumns(10);
		txtDirCliente = new JTextField();
		add(txtDirCliente, "cell 3 5,growx");
		txtDirCliente.setColumns(10);
		
		// BUTTONS PANEL CLIENTES
		JButton btnVerInfo = new JButton("Ver info");
		add(btnVerInfo, "cell 4 4,growx");
		JButton btnVerInfo_1 = new JButton("Ver info");
		add(btnVerInfo_1, "cell 4 5,growx");
		JButton btnVerInfo_2 = new JButton("Ver info");
		add(btnVerInfo_2, "cell 4 3,growx");
		btnNuevoCliente = new JButton("Nuevo Cliente");
		add(btnNuevoCliente, "cell 1 0,alignx center");
		btnNuevoCliente.addActionListener(this);
		btnModificarCliente = new JButton("Modificar Cliente");
		add(btnModificarCliente, "cell 2 0,alignx center");
		btnModificarCliente.addActionListener(this);
		btnEliminarCliente = new JButton("Eliminar Cliente");
		add(btnEliminarCliente, "cell 3 0,alignx center");
		btnEliminarCliente.addActionListener(this);
		btnAgregarCliente = new JButton("Agregar Cliente");
		add(btnAgregarCliente, "cell 1 6,alignx center");
		btnAgregarCliente.addActionListener(this);
		btnAgregarCliente.setEnabled(false);
		
		
		// SCROLLPANE Y TABLE PANEL CLIENTES
		String[] cols = {"nombre","apellido","dni","cuit", "telefono", "Nº pasajero frecuente"};
		header = new DefaultTableModel(cols, 0);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 8 7 1,grow");
		tablaClientes = new JTable(header);
		scrollPane.setViewportView(tablaClientes);
		
		campos.add(txtNombreCliente);
		campos.add(txtDniCliente);
		campos.add(txtApellidoCliente);
		campos.add(txtNacCliente);
		campos.add(txtCuitCliente);
		campos.add(txtEmailCliente);
		campos.add(txtTelCliente);
		campos.add(txtPasaporteCliente);
		campos.add(txtPasajeroFrec);
		campos.add(txtDirCliente);
		
		CamposManager.deshabilitarCampos(campos);
		this.leerClientes();
		actualizarTabla(clientes);
		
//		panelModCliente = new PanelModificarCliente();

	}
	
	private void leerClientes(){
		this.clientes = clienteDAO.leerClientes();
	}
	
	private void actualizarTabla(ArrayList<Cliente> clientes){
		for (int i =0;i<clientes.size();i++){
			Object[] c = {clientes.get(i).getNombre(),clientes.get(i).getApellido(),clientes.get(i).getDni(),
					clientes.get(i).getCuit(), clientes.get(i).getEmail(), clientes.get(i).getTelefono()};
			this.header.addRow(c);
		}
	}
	
	private Cliente leerInput() {
		Cliente c = new Cliente();
		c.setNombre(txtNombreCliente.getText());
		c.setApellido(txtApellidoCliente.getText());
		c.setDni(txtDniCliente.getText());
		c.setTelefono(new Telefono(txtTelCliente.getText()));
		c.setCuit(txtCuitCliente.getText());
		c.setEmail(txtEmailCliente.getText());
		
		return c;
	}
	
	private void agregarCliente(Cliente c){
		this.clientes.clear();
		this.clientes.add(c);		
	}
	
	private void limpiarTabla(){
		for (int i = 0; i < this.tablaClientes.getRowCount(); i++) {
			this.header.removeRow(i);
			i-=1;
		}
	}

	// LISTENERS
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNuevoCliente){
			IOManager.print("se abrio nuevo cliente.");
			CamposManager.habilitarCampos(campos);
			btnAgregarCliente.setEnabled(true);
		}
		else if(e.getSource()== btnAgregarCliente){
			if(CamposManager.camposCompletos(campos)){
				Cliente nuevoCliente = this.leerInput();
				this.agregarCliente(nuevoCliente);
				if(clienteDAO.escribirClientes(clientes)){
					JOptionPane.showMessageDialog(null, "Cliente agregado correctamente!");
				}	
			}
			else{
				JOptionPane.showMessageDialog(null, "Tiene campos incompletos. Pruebe nuevamente");
			}
			CamposManager.limpiarCampos(campos);
			CamposManager.deshabilitarCampos(campos);
			this.limpiarTabla();
			this.leerClientes();
			this.actualizarTabla(this.clientes);
			btnAgregarCliente.setEnabled(false);
		}
		else if(e.getSource() == btnModificarCliente){
				PanelModificarCliente panelModCliente = new PanelModificarCliente();
				modCliente = new ModificarCliente();
				modCliente.getContentPane().add(panelModCliente);
				modCliente.setVisible(true);
				IOManager.print("se abrio mod cliente.");
			try{
//				this.revalidate();
//				this.repaint();
				System.out.println("se abrio el panel de mod cliente2.");
				}catch(Exception exce){
					System.out.println("Error"+exce.getCause());
				}
		}
		else if(e.getSource()==btnEliminarCliente){
			
		}
		
		
	}

}