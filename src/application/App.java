package application;

import java.awt.EventQueue;

import service.ClientService;
import service.InvoiceService;
import service.ProductService;
import view.MainGUI;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				InvoiceService invoiceService = new InvoiceService();
				ProductService productService = new ProductService();
				ClientService clientService = new ClientService();
				new MainGUI(invoiceService, productService, clientService);
			}
		});
	}
	
}

