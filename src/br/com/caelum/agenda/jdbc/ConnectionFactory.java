package br.com.caelum.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	
	public Connection getConnection()   {
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3307/fj21", "root", "gustavosantospro");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		}
}
