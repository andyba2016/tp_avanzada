package com.usal.aerolinea.presentacion;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ModificarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelModificarCliente panelModCliente;

	public ModificarCliente() {
		panelModCliente = new PanelModificarCliente();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panelModCliente.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelModCliente.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panelModCliente);

	}

}
