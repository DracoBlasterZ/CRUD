package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ClienteConsultas extends DbConection {

	// CONSULTAS

	private Connection con;
	private String table = "cliente";

	public boolean añadir(Cliente cliente) {
		con = getConexion();
		PreparedStatement ps = null;
		// Realizamos la validación de los datos
		validaciones(cliente);

		String sql = "INSERT INTO Cliente (nombre, apellido, direccion, dni, fecha) VALUES(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.execute();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			desconexion();
		}
	}

	// Primero se busca, y despues se pueden modificar datos.
	public boolean modificar(Cliente cliente) {
		con = getConexion();
		PreparedStatement ps = null;
		validaciones(cliente);
		String sql = "UPDATE " + table + " SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getDni());
			ps.setString(5, cliente.getFecha());
			ps.setInt(6, cliente.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} finally {
			desconexion();
		}

	}

	public boolean eliminar(Cliente cliente) {
		con = getConexion();
		PreparedStatement ps = null;
		String sql = "DELETE FROM " + table + " WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			desconexion();
		}
	}

	public boolean buscar(Cliente cliente) {
		con = getConexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + table + " WHERE dni=?";

		// Para buscar hay que buscar por nombre.

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getDni());
			rs = ps.executeQuery();

			if (rs.next()) {
				cliente.setId(Integer.parseInt(rs.getString("id")));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDni(Integer.parseInt(rs.getString("dni")));
				cliente.setFecha(rs.getString("fecha"));
			} else {
				JOptionPane.showMessageDialog(null, "El añadir no existe");
			}
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			desconexion();
		}

	}

	private void validaciones(Cliente cliente) {
		// TODO Auto-generated method stub
		if (cliente.getNombre().isEmpty()) {
			throw new RuntimeException("Hay que añadir nombre");
		} else if (cliente.getApellido().isEmpty()) {
			throw new RuntimeException("Hay que añadir apellido");
		} else if (cliente.getDireccion().isEmpty()) {
			throw new RuntimeException("Hay que añadir una direccion");
		} else if (cliente.getDni() != 8) {
			throw new RuntimeException("El dni debe tener 8 numeros. ");
		} else if (cliente.getFecha().isEmpty()) {
			throw new RuntimeException("Hay que añadir fecha y debe ser en el formato 'YYYY-MM-DD'");
		}

	}

}
