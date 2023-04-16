package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DBConnectorClass {
	private static Connection conexion;

	public static Connection connect(String IP, String user, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://" + IP + " ", user, password);
			System.out.print("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.print(ex);
		}
		return conexion;

	}

	public static void closeConnection() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexion con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(DBConnectorClass.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void selectDB(String dbName) {
		try {
			String queryDb = "USE " + dbName + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnectorClass.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}