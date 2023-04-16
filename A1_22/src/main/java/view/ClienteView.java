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
	public JButton btnAdd;
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnClean;
	public JTextField textDate;
	public JLabel lblDate;
	public JTextField textId;

	public ClienteView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(38, 39, 70, 21);
		contentPane.add(lblNombre);

		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setBounds(38, 81, 70, 21);
		contentPane.add(lblApellido);

		lblDireccin = new JLabel("Dirección");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccin.setBounds(38, 124, 70, 21);
		contentPane.add(lblDireccin);

		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(38, 163, 70, 21);
		contentPane.add(lblDni);

		textNombre = new JTextField();
		textNombre.setBounds(154, 40, 192, 21);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(154, 82, 192, 21);
		contentPane.add(textApellido);

		textAdress = new JTextField();
		textAdress.setColumns(10);
		textAdress.setBounds(154, 125, 192, 21);
		contentPane.add(textAdress);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(154, 164, 192, 21);
		contentPane.add(textDni);

		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(24, 251, 89, 23);
		contentPane.add(btnAdd);

		btnUpdate = new JButton("Modificar");
		btnUpdate.setBounds(144, 251, 89, 23);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(263, 251, 89, 23);
		contentPane.add(btnDelete);

		btnClean = new JButton("Limpiar");
		btnClean.setBounds(390, 251, 89, 23);
		contentPane.add(btnClean);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(390, 39, 89, 23);
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
		textId.setBounds(393, 96, 86, 20);
		contentPane.add(textId);
	}

}