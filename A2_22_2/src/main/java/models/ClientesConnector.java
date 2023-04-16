package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import DBConnector.DBConnectorClass;

public class ClientesConnector extends AbstractTableModel {

	// Table attributes
	private List<Clientes> clientes;
	private String[] columnNames = { "ID", "Nombre", "Apellido", "Direccion", "DNI", "Fecha" };
	private String DB = "ud22_1";
	private Connection connection;
	private String table = "cliente";
	
	
	public ClientesConnector() {
		updateTable();
	}


	@Override
	public int getRowCount() {
		return clientes.size();
	}


	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// Make the first row non-editable
		return row > 0;
	}

	public List<Clientes> getClientes() {
		return clientes;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setClientes(List<Clientes> clientes) {
		this.clientes = clientes;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Clientes cliente = clientes.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNombre();
		case 2:
			return cliente.getApellido();
		case 3:
			return cliente.getDireccion();
		case 4:
			return cliente.getDNI();
		case 5:
			return cliente.getDate();
		default:
			return null;
		}
	}
	public void updateTable() {
		this.clientes = new ArrayList<Clientes>();
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM " + table + ";");
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String direccion = rs.getString("direccion");
				int dni = rs.getInt("dni");
				String fecha = rs.getString("fecha");
				Clientes cliente = new Clientes(id, nombre, apellido, direccion, dni, fecha);
				clientes.add(cliente);
			}
			statement.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addClienteToDB(Clientes cliente) {
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		String query = "INSERT INTO " + table + " (nombre, apellido, direccion, dni, fecha) " + "VALUES (?,?,?,?,?);";

		try {
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, cliente.getNombre());
			pStatement.setString(2, cliente.getApellido());
			pStatement.setString(3, cliente.getDireccion());
			pStatement.setInt(4, cliente.getDNI());
			pStatement.setString(5, cliente.getDate());

			// Execute statement and close if success
			pStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuario añadido", "Completado", JOptionPane.INFORMATION_MESSAGE);
			pStatement.close();
			connection.close();
			updateTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteCliente(int index) {
		// Get clientes from index
		Clientes cliente = clientes.get(index);
		int clienteID = cliente.getId();
		connection = DBConnectorClass.connect("192.168.1.128:3306","remote","por.java12DABA");
		DBConnectorClass.selectDB("Youtube");
		String query = "DELETE FROM " + table + " WHERE id = " + clienteID + ";";

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Usuario eliminado", "Completado!",
					JOptionPane.INFORMATION_MESSAGE);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Remove from table
		clientes.remove(index);
	}
}
