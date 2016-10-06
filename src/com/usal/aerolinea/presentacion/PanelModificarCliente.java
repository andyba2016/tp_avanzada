package com.usal.aerolinea.presentacion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class PanelModificarCliente extends JPanel implements ActionListener{
	
	private JTextField textField;
	private JTextField textField_1;
	JButton btnNewButton;

	public PanelModificarCliente() {
		setBackground(SystemColor.textHighlight);
		setLayout(new MigLayout("", "[][92.00px][32px,grow]", "[][25px][25px][][grow]"));
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		add(lblBuscarPor, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DNI", "Apellido"}));
		add(comboBox, "cell 1 0,growx");
		
		JLabel lblDni = new JLabel("DNI");
		add(lblDni, "cell 0 1,alignx center");
		
		textField = new JTextField();
		add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		add(lblApellido, "cell 0 2,alignx center");
		
		btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 1 3");
		btnNewButton.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 4 3 1,grow");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnNewButton){
			System.out.println("se abrio la pest");
		}
		
	}

}
