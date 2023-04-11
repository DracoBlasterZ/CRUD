package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCliente;
import model.ClienteClass;

import javax.swing.BoxLayout;
import javax.swing.JTable;

public class Cliente extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JLabel Titulo;
	private JTextField txtApellido, txtNombre;
	private JLabel nombre, dni;
	private JButton btnAñadir, btnCancelar;
	private JTextField txtDireccion;
	private JTextField txtDni;
	private JTextField txtFecha;

	private ControllerCliente controllerCliente;

	public Cliente() {

		btnAñadir = new JButton();
		btnAñadir.setBounds(78, 373, 120, 25);
		btnAñadir.setText("Añadir Datos");
		
		btnCancelar = new JButton();
		btnCancelar.setBounds(262, 373, 120, 25);
		btnCancelar.setText("Cancelar");

		Titulo = new JLabel();
		Titulo.setText("REGISTRO CLIENTES");
		Titulo.setBounds(120, 20, 380, 30);
		Titulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		dni = new JLabel();
		dni.setText("Nombre");
		dni.setBounds(120, 84, 52, 25);
		getContentPane().add(dni);
		
		nombre = new JLabel();
		nombre.setText("Apellido");
		nombre.setBounds(120, 121, 80, 25);
		getContentPane().add(nombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(182, 84, 160, 25);
		getContentPane().add(txtNombre);
		
		txtApellido=new JTextField();
		txtApellido.setBounds(182, 121, 160, 25);
		getContentPane().add(txtApellido);
		
		btnAñadir.addActionListener((ActionListener) this);
		btnCancelar.addActionListener((ActionListener) this);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnAñadir);
		getContentPane().add(Titulo);
		
		limpiar();
		
		setSize(498, 464);
		setTitle("Patron de Diseño MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel direccion = new JLabel();
		direccion.setText("Direccion");
		direccion.setBounds(120, 171, 63, 25);
		getContentPane().add(direccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("");
		txtDireccion.setBounds(182, 170, 160, 25);
		getContentPane().add(txtDireccion);
		
		JLabel Dni = new JLabel();
		Dni.setText("Dni");
		Dni.setBounds(120, 219, 63, 25);
		getContentPane().add(Dni);
		
		txtDni = new JTextField();
		txtDni.setText("");
		txtDni.setBounds(182, 218, 160, 25);
		getContentPane().add(txtDni);
		
		JLabel Fecha = new JLabel();
		Fecha.setText("Fecha");
		Fecha.setBounds(120, 267, 63, 25);
		getContentPane().add(Fecha);
		
		txtFecha = new JTextField();
		txtFecha.setToolTipText("");
		txtFecha.setText("2023-04-11");
		txtFecha.setBounds(182, 266, 160, 25);
		getContentPane().add(txtFecha);
	}

	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
	}
	
	public void setCoordinador(ControllerCliente controllerCliente) {
		this.controllerCliente=controllerCliente;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAñadir) {
			try {				
				ClienteClass cliente=new ClienteClass();
				cliente.setNombre(txtNombre.getText());
				cliente.setDni(txtNombre.getText());
				cliente.setDireccion(txtNombre.getText());
				cliente.setFecha(txtNombre.getText());
				cliente.setApellido(txtApellido.getText());	
				//cliente.registrarCientificos(cliente);	
			} 
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error al ingresar datos", "Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}
}