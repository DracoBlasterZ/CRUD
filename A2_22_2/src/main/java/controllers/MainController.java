package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.ClientesWindow;
import views.MainWindow;
import views.VideosWindow;

public class MainController {

	// View
	private MainWindow view;
	public static int clienteWindowsOpen = 0;
	public static int videosWindowsOpen = 0;

	// Controller with view
	public MainController(MainWindow view) {
		this.view = view;
		view.btnClientes.addActionListener(btns);
		view.btnVideos.addActionListener(btns);
	}

	ActionListener btns = new ActionListener() {

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.btnClientes) {
				if (clienteWindowsOpen == 0) {
					ClientesWindow cview = new ClientesWindow();
					ClientesWindowController cvController = new ClientesWindowController(cview);
					clienteWindowsOpen++;
				}
			}
			if (e.getSource() == view.btnVideos) {

				if (videosWindowsOpen == 0) {
					VideosWindow vview = new VideosWindow();
					VideosWindowController vvController = new VideosWindowController(vview);
					videosWindowsOpen++;
				}

			}

		}

	};

}