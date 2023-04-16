package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ClienteConsultas extends DbConection {

		// CONSULTAS

		private Connection con;
		private String table = "Cliente";

		public boolean registro(Cliente cliente) {
			con = getConexion();
			PreparedStatement ps = null;
			// Realizamos la validación de los datos
			validarCliente(cliente);

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
				desconectar();
			}
		}

		private void validarCliente(Cliente cliente) {
			// TODO Auto-generated method stub
			if (cliente.getApellido().isEmpty()) {
				throw new RuntimeException("El apellido es obligatorio");
			} else if (cliente.getNombre().isEmpty()) {
				throw new RuntimeException("El nombre es obligatorio");
			} else if (cliente.getDireccion().isEmpty()) {
				throw new RuntimeException("La dirección es obligatorio");
			} else if (cliente.getDni() > 8 && cliente.getDni() <= 11) {
				throw new RuntimeException("El número debe tener entre 8 y 11 caracteres");
			} else if (cliente.getFecha().isEmpty()) {
				throw new RuntimeException("La fecha es obligatoria");
			}

		}

		public boolean modificar(Cliente cliente) {
			con = getConexion();
			PreparedStatement ps = null;
			validarCliente(cliente);
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
				desconectar();
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
				desconectar();
			}
		}

		public boolean buscar(Cliente cliente) {
			con = getConexion();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM " + table + " WHERE nombre=?";

			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, cliente.getNombre());
				rs = ps.executeQuery();

				if (rs.next()) {
					cliente.setId(Integer.parseInt(rs.getString("id")));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setApellido(rs.getString("apellido"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.setDni(Integer.parseInt(rs.getString("dni")));
					cliente.setFecha(rs.getString("fecha"));
				} else {
					JOptionPane.showMessageDialog(null, "El registro no existe");
				}
				return true;
			} catch (SQLException e) {

				e.printStackTrace();
				return false;
			} finally {
				desconectar();
			}

		}

	}
