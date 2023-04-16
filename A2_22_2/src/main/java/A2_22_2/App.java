package A2_22_2;

import java.awt.EventQueue;

import controllers.MainController;
import views.MainWindow;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					MainController controller = new MainController(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}