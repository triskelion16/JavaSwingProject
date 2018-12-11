package application;

import java.awt.EventQueue;
import view.MainGUI;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainGUI();
			}
		});
	}
	
}

