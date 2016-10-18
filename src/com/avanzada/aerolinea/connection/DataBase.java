package com.avanzada.aerolinea.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	
	private Connection conn;
    private String str;

	public Connection getConn() {
//		this.str = "jdbc:mysql://127.0.0.1/aerolinea?" +
//                                   "user=root&password=root";
		this.str = "jdbc:mysql://127.0.0.1/aerolinea?" +
                "user=root&password=";
		try {
			this.conn = DriverManager.getConnection(this.str);
		} catch (SQLException e) {
		    System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + e.getSQLState());
		    System.out.println("VendorError: " + e.getErrorCode());
		}
		return this.conn;
	}
	
	

}
