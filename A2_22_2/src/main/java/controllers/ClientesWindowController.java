package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

import models.Clientes;
import models.ClientesConnector;
import views.ClientesWindow;

public class ClientesWindowController {

	// Atributos
	private ClientesWindow view; // Ventana
	private ClientesConnector tableModel; //Conector de Cliente
	TableRowSorter<ClientesConnector> sorter; // Organizador

	public ClientesWindowController(ClientesWindow view) {
		this.view = view;
		this.tableModel = new ClientesConnector(); // Create Model
		view.table.setModel(tableModel); // Set model to view table
		view.table.addMouseListener(tblListener); // Add Mouse listener to table
		// Action listener to buttons
		view.btnAdd.addActionListener(btns);
		view.btnDel.addActionListener(btns);
		view.btnModify.addActionListener(btns);
		view.btnReset.addActionListener(btns);
		sorter = new TableRowSorter<>(tableModel); // Create sorter based on model
		view.table.setRowSorter(sorter); // Add sorter to table
		view.textFieldSearch.addKeyListener(searchBar); // Add key listener to searchbar
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set Default close operation
		view.addWindowListener(window); // Window Listener to reset instances on close
	}

	// Buttons action listener
	ActionListener btns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// If button is reset, resets text fields
			if (e.getSource() == view.btnReset) {
				resetTextFields();
			}
			// If button is add, adds client info to DB and table
			if (e.getSource() == view.btnAdd) {
				Clientes cliente = new Clientes();
				cliente.setNombre(view.textFieldNombre.getText());
				cliente.setApellido(view.textFieldApellido.getText());
				cliente.setDireccion(view.textFieldDireccion.getText());
				cliente.setDNI(Integer.parseInt(view.textFieldDNI.getText()));
				cliente.setDate(view.textFieldFecha.getText());

				// Adds cliente to DB and table model
				tableModel.addClienteToDB(cliente);
				// Resets text fields
				resetTextFields();
				// Updates table data
				tableModel.fireTableDataChanged();
			}
			// If button is del, delete selected client
			if (e.getSource() == view.btnDel) {
				// Delete selected client
				tableModel.deleteCliente(view.table.getSelectedRow());
				// Resets text fields
				resetTextFields();
				// Update table data
				tableModel.fireTableDataChanged();
			}
			// If button is modify, modify selected client
			if (e.getSource() == view.btnModify) {
				// Check if the row is selected
				if (view.table.getSelectedRow() == 0 || view.table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "No user Selected", "Error!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				Clientes cliente = new Clientes();
				// Sets info from selected Cliente
				cliente.setId(Integer.parseInt(view.textFieldID.getText()));
				cliente.setNombre(view.textFieldNombre.getText());
				cliente.setApellido(view.textFieldApellido.getText());
				cliente.setDireccion(view.textFieldDireccion.getText());
				cliente.setDNI(Integer.parseInt(view.textFieldDNI.getText()));
				cliente.setDate(view.textFieldFecha.getText());

				// Modifies cliente in DB and table model
				tableModel.updateCliente(cliente);
				// Resets text fields
				resetTextFields();
				// Updates table data
				tableModel.fireTableDataChanged();
			}
		}
	};

	// Table mouse listener
	MouseListener tblListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			// Gets clicked selected row and puts values in text fields
			int row = view.table.getSelectedRow();
			// Convert row to model row to select the correct row when Filtering
			int modelRow = view.table.convertRowIndexToModel(row);
			view.textFieldID.setText((String) tableModel.getValueAt(modelRow, 0).toString());
			view.textFieldNombre.setText((String) tableModel.getValueAt(modelRow, 1));
			view.textFieldApellido.setText((String) tableModel.getValueAt(modelRow, 2));
			view.textFieldDireccion.setText((String) tableModel.getValueAt(modelRow, 3));
			view.textFieldDNI.setText((String) tableModel.getValueAt(modelRow, 4).toString());
			view.textFieldFecha.setText((String) tableModel.getValueAt(modelRow, 5));
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	};

	// Search bar Key adapter
	KeyAdapter searchBar = new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			// Gets input written in search bar, and displays rows that contain the written
			// text
			String query = view.textFieldSearch.getText();
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
		}
	};

	// Window Listener
	WindowListener window = new WindowListener() {

		public void windowOpened(WindowEvent e) {
		}

		// Once closing the view, set instances to 0
		public void windowClosing(WindowEvent e) {
			MainController.clienteWindowsOpen = 0;
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {
		}

		public void windowDeiconified(WindowEvent e) {
		}

		public void windowActivated(WindowEvent e) {
		}

		public void windowDeactivated(WindowEvent e) {
		}

	};

	// Function to reset textFields and table selection
	public void resetTextFields() {
		view.table.clearSelection();
		view.textFieldApellido.setText("");
		view.textFieldDireccion.setText("");
		view.textFieldDNI.setText("");
		view.textFieldFecha.setText("");
		view.textFieldNombre.setText("");
		view.textFieldID.setText("");
	}

}