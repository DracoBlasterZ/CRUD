package model;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DbConection {
	private final String DataBase = "Clientes";
	private Connection con;

	public DbConection() {

	}

	public Connection getConexion() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "Camila1234_");
			Statement st = con.createStatement();
			System.out.print("Server Connected");
			String queryCrear =  "CREATE DATABASE IF NOT EXISTS " + DataBase;
			System.out.println("se ha creado bien");
			String queryDB = "USE " + DataBase + ";";
			String query = "CREATE TABLE IF NOT EXISTS cliente ("
	                + "id INT NOT NULL AUTO_INCREMENT,"
	                + "nombre VARCHAR(100),"
	                + "apellido VARCHAR(100),"
	                + "direccion VARCHAR(300),"
	                + "dni CHAR(8),"
	                + "fecha DATE,"
	                + "PRIMARY KEY (id)"
	                + ");";
			System.out.println("Se ha creado la tabla");
			st.executeUpdate(queryCrear);
			st.executeUpdate(queryDB);
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(e);
		}
		return con;
	}

	public void desconectar() {
		try {
			if (con != null) {
				con.close();
			}
			System.out.println("Conexión cerrada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}