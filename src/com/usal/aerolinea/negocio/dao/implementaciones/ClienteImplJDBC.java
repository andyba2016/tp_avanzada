package com.usal.aerolinea.negocio.dao.implementaciones;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import com.avanzada.aerolinea.connection.DataBase;
import com.usal.aerolinea.negocio.dao.interfaces.ClienteInterface;
import com.usal.aerolinea.negocio.dto.Cliente;
import com.usal.aerolinea.negocio.dto.IOManager;

public class ClienteImplJDBC implements ClienteInterface{

	private DataBase db = new DataBase();
	public ArrayList<Cliente> leerClientes() throws SQLException {
       
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			
			con = db.getConn();
			String query ="SELECT * FROM clientes";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString(2));
				cliente.setApellido(rs.getString(3));
				cliente.setDni(rs.getString(4));
				cliente.setEmail(rs.getString(8));
				DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date date = (Date) format.parse(rs.getString(7));
				cliente.setFechaNac(date);
				clientes.add(cliente);
			}

		} catch (Exception e) {
			IOManager.print(e.getMessage());

		} finally {
			rs.close();
			st.close();
			con.close();
		}
		return clientes;
	}

	public boolean escribirClientes(ArrayList<Cliente> clientes) throws SQLException {
		boolean ok = false;
		Connection con = null;
		Statement st = null;
		try {
			con = db.getConn();
			con.setAutoCommit(false);
			for (Cliente cliente : clientes) {
				String query = "INSERT INTO clientes (nombre,apellido,dni,cuit)" + " VALUES ('" + cliente.getNombre() + "','"
						+ cliente.getApellido() + "','" + cliente.getDni() + "','"+cliente.getCuit()+"')";
				st = con.createStatement();
				st.execute(query);
				System.out.print(query);
			}
			con.commit();
			ok = true;
		} catch (Exception e) {
			System.out.print(e);
		} finally {		
			st.close();
			con.close();
		}

		return ok;

	}

}

