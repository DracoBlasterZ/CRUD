package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteConsultas;
import view.ClienteView;


public class ControllerCliente implements ActionListener {

	private Cliente cliente;
	private ClienteConsultas consultas;
	private ClienteView vista;

	public ControllerCliente(Cliente cliente, ClienteConsultas consultas, ClienteView vista) {
		this.cliente = cliente;
		this.consultas = consultas;
		this.vista = vista;
		this.vista.botonAñadir.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.botonVaciar.addActionListener(this);
		this.vista.botonEliminar.addActionListener(this);
		this.vista.botonModificar.addActionListener(this);
	}

	public void iniciar() {
		vista.setTitle("Gestión Clientes");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.botonAñadir) {
			cliente.setNombre(vista.textNombre.getText());
			cliente.setApellido(vista.textApellido.getText());
			cliente.setDireccion(vista.textAdress.getText());
			cliente.setDni(Integer.parseInt(vista.textDni.getText()));
			cliente.setFecha(vista.textDate.getText());
			if (consultas.añadir(cliente)) {
				JOptionPane.showMessageDialog(null, "Registro Añadido");
				vaciarCampos();
			} else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");
				vaciarCampos();
			}

		}
		if (e.getSource() == vista.botonModificar) {

			cliente.setId(Integer.parseInt(vista.textId.getText()));
			cliente.setNombre(vista.textNombre.getText());
			cliente.setApellido(vista.textApellido.getText());
			cliente.setDireccion(vista.textAdress.getText());
			cliente.setDni(Integer.parseInt(vista.textDni.getText()));
			cliente.setFecha(vista.textDate.getText());

			if (consultas.modificar(cliente)) {
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				vaciarCampos();
			} else {
				JOptionPane.showMessageDialog(null, "Error al Modificar");
				vaciarCampos();
			}

		}
		if (e.getSource() == vista.botonEliminar) {
			cliente.setId(Integer.parseInt(vista.textId.getText()));

			if (consultas.eliminar(cliente)) {
				JOptionPane.showMessageDialog(null, "El registro se ha eliminado ");
				vaciarCampos();
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar. ");
				vaciarCampos();
			}
		}
		if (e.getSource() == vista.btnBuscar) {
			cliente.setDni(Integer.parseInt(vista.textDni.getText()));
			if (consultas.buscar(cliente)) {
				vista.textId.setText(String.valueOf(cliente.getId()));
				vista.textNombre.setText(cliente.getNombre());
				vista.textApellido.setText(cliente.getApellido());
				vista.textAdress.setText(cliente.getDireccion());
				vista.textDni.setText(String.valueOf(cliente.getDni()));
				vista.textDate.setText(cliente.getFecha());
				vista.textId.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "No se han encontrado clientes con este dni.");
				vaciarCampos();
			}
		}
		if (e.getSource() == vista.botonVaciar) {
			vaciarCampos();
		}
	}

	
	public void vaciarCampos() {
		vista.textId.setText(null);
		vista.textNombre.setText(null);
		vista.textApellido.setText(null);
		vista.textAdress.setText(null);
		vista.textDni.setText(null);
		vista.textDate.setText(null);
	}

}