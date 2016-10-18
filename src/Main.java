import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;

import com.usal.aerolinea.negocio.dao.implementaciones.ClienteImplFile;
import com.usal.aerolinea.negocio.dao.interfaces.ClienteInterface;
import com.usal.aerolinea.negocio.dto.Cliente;
import com.usal.aerolinea.negocio.dto.Telefono;
import com.usal.aerolinea.presentacion.VentanaPrincipal;

import javax.swing.JMenuBar;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new VentanaPrincipal();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
}
