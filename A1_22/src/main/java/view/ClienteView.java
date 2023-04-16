package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCliente;
import model.ClienteConsultas;

import javax.swing.BoxLayout;
import javax.swing.JTable;

public class ClienteView extends JFrame {
	private JPanel contentPane;
	public JTextField textNombre;
	public JTextField textApellido;
	public JTextField textAdress;
	public JTextField textDni;
	public JLabel lblDni;
	public JLabel lblDireccin;
	public JLabel lblApellido;
	public JLabel lblNombre;
	public JButton btnBuscar;
	public JButton botonAñadir;
	public JButton botonModificar;
	public JButton botonEliminar;
	public JButton botonVaciar;
	public JTextField textDate;
	public JLabel lblDate;
	public JTextField textId;
	private JLabel lblId;

	public ClienteView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(38, 99, 70, 21);
		contentPane.add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setBounds(38, 132, 70, 21);
		contentPane.add(lblApellido);

		lblDireccin = new JLabel("Dirección");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccin.setBounds(38, 165, 70, 21);
		contentPane.add(lblDireccin);

		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(38, 66, 70, 21);
		contentPane.add(lblDni);

		textNombre = new JTextField();
		textNombre.setBounds(154, 98, 192, 21);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(154, 131, 192, 21);
		contentPane.add(textApellido);

		textAdress = new JTextField();
		textAdress.setColumns(10);
		textAdress.setBounds(154, 164, 192, 21);
		contentPane.add(textAdress);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(154, 65, 192, 21);
		contentPane.add(textDni);

		botonAñadir = new JButton("Añadir");
		botonAñadir.setBounds(24, 251, 89, 23);
		contentPane.add(botonAñadir);

		botonModificar = new JButton("Modificar");
		botonModificar.setBounds(144, 251, 89, 23);
		contentPane.add(botonModificar);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(263, 251, 89, 23);
		contentPane.add(botonEliminar);

		botonVaciar = new JButton("Limpiar");
		botonVaciar.setBounds(390, 251, 89, 23);
		contentPane.add(botonVaciar);

		btnBuscar = new JButton("Buscar por DNI");
		btnBuscar.setBounds(176, 25, 155, 23);
		contentPane.add(btnBuscar);

		lblDate = new JLabel("Fecha");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(38, 207, 70, 21);
		contentPane.add(lblDate);

		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(154, 208, 192, 21);
		contentPane.add(textDate);

		textId = new JTextField();
		textId.setBounds(400, 66, 86, 20);
		contentPane.add(textId);
		
		lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(347, 66, 51, 21);
		contentPane.add(lblId);
	}
}