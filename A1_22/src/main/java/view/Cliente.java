package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTable;

public class Cliente extends JFrame {
	
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JComboBox<Object> txtDniCientifico, txtProyecto;
	private JLabel dniCientifico, proyecto;
	private JButton btnGuardar, btnCancelar;

	public Cliente() {
	

	btnGuardar = new JButton();
	btnGuardar.setBounds(110, 220, 120, 25);
	btnGuardar.setText("Registrar");
	
	btnCancelar = new JButton();
	btnCancelar.setBounds(250, 220, 120, 25);
	btnCancelar.setText("Cancelar");

	lblTitulo = new JLabel();
	lblTitulo.setText("ASIGNAR CIENTIFICO A PROYECTO");
	lblTitulo.setBounds(47, 22, 380, 30);
	lblTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
	
	dniCientifico = new JLabel();
	dniCientifico.setText("DNI Cientifico");
	dniCientifico.setBounds(110, 79, 103, 25);
	getContentPane().add(dniCientifico);
	
	proyecto = new JLabel();
	proyecto.setText("Codigo Proyecto");
	proyecto.setBounds(110, 135, 103, 25);
	getContentPane().add(proyecto);
	
	txtDniCientifico = new JComboBox<Object>();
	txtDniCientifico.setBounds(218, 79, 140, 25);
	
	getContentPane().add(txtDniCientifico);
	
	txtProyecto = new JComboBox<Object>();
	txtProyecto.setBounds(218, 135, 140, 25);
	
	getContentPane().add(txtProyecto);
	
	btnGuardar.addActionListener((ActionListener) this);
	btnCancelar.addActionListener((ActionListener) this);
	getContentPane().add(btnCancelar);
	getContentPane().add(btnGuardar);
	getContentPane().add(lblTitulo);
	

	
	setSize(480, 300);
	setTitle("Patron de Diseño/MVC");
	setLocationRelativeTo(null);
	setResizable(false);
	getContentPane().setLayout(null);

}
}