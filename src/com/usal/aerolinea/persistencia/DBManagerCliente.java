package com.usal.aerolinea.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.usal.aerolinea.connection.DataBase;
import com.usal.aerolinea.negocio.dto.Cliente;
import com.usal.aerolinea.negocio.dto.IOManager;

public class DBManagerCliente extends DataBase {

	

	public ArrayList<Cliente> leer() throws SQLException {
       
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = this.getConn();
		Statement st = null;
		ResultSet rs = null;
		try {
			
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

	public boolean escribir(ArrayList<Cliente> clientes) throws SQLException {
		boolean ok = false;
		Connection con = null;
		Statement st = null;
		try {
			con = this.getConn();
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
