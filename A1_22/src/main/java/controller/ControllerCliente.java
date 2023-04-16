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
	private ClienteView view;

	public ControllerCliente(Cliente cliente, ClienteConsultas consultas, ClienteView view) {
		this.cliente = cliente;
		this.consultas = consultas;
		this.view = view;
		this.view.btnAdd.addActionListener(this);
		this.view.btnBuscar.addActionListener(this);
		this.view.btnClean.addActionListener(this);
		this.view.btnDelete.addActionListener(this);
		this.view.btnUpdate.addActionListener(this);
	}

	public void iniciar() {
		view.setTitle("Gestión Clientes");
		view.textId.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.btnAdd) {
			cliente.setNombre(view.textNombre.getText());
			cliente.setApellido(view.textApellido.getText());
			cliente.setDireccion(view.textAdress.getText());
			cliente.setDni(Integer.parseInt(view.textDni.getText()));
			cliente.setFecha(view.textDate.getText());
			if (consultas.registro(cliente)) {
				JOptionPane.showMessageDialog(null, "Registro Añadido");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");
				limpiar();
			}

		}
		if (e.getSource() == view.btnUpdate) {

			cliente.setId(Integer.parseInt(view.textId.getText()));
			cliente.setNombre(view.textNombre.getText());
			cliente.setApellido(view.textApellido.getText());
			cliente.setDireccion(view.textAdress.getText());
			cliente.setDni(Integer.parseInt(view.textDni.getText()));
			cliente.setFecha(view.textDate.getText());

			if (consultas.modificar(cliente)) {
				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "Error al Modificar");
				limpiar();
			}

		}
		if (e.getSource() == view.btnDelete) {
			cliente.setId(Integer.parseInt(view.textId.getText()));

			if (consultas.eliminar(cliente)) {
				JOptionPane.showMessageDialog(null, "El registro se ha eliminado ");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar. ");
				limpiar();
			}
		}
		if (e.getSource() == view.btnBuscar) {
			cliente.setNombre(view.textNombre.getText());
			if (consultas.buscar(cliente)) {
				view.textId.setText(String.valueOf(cliente.getId()));
				view.textNombre.setText(cliente.getNombre());
				view.textApellido.setText(cliente.getApellido());
				view.textAdress.setText(cliente.getDireccion());
				view.textDni.setText(String.valueOf(cliente.getDni()));
				view.textDate.setText(cliente.getFecha());
				view.textId.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "No hay ningun registro");
				limpiar();
			}
		}
		if (e.getSource() == view.btnClean) {
			limpiar();
		}
	}

	public void limpiar() {
		view.textId.setText(null);
		view.textNombre.setText(null);
		view.textApellido.setText(null);
		view.textAdress.setText(null);
		view.textDni.setText(null);
		view.textDate.setText(null);
	}

}