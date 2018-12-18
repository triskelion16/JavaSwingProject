package application;

import java.awt.EventQueue;

import entity.Client;
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
				
				createClients(clientService);
				
				new MainGUI(invoiceService, productService, clientService);
			}
		});
	}
	
	public static void createClients(ClientService clientService) {
		Client c1 = new Client("Saturn sp.j.", "8376103872", "01-990 Warszawa, Kwiatowa 2/4");
		Client c2 = new Client("Jowisz sp. z o.o.", "1234567890", "61-100 Poznań, Piękna 5");
		Client c3 = new Client("Mars S.A.", "2874091178", "64-600 Oborniki, Mokra 12/1");
		Client c4 = new Client("Pluton sp.c.", "8826155209", "00-950 Warszawa, Pechowa 13");
		Client c5 = new Client("Wenus sp.j.", "0488132997", "01-991 Warszawa, Sokratesa 8/21");
		Client c6 = new Client("Uran sp.k.", "0935188365", "00-900 Warszawa, Moliera 2");
		
		clientService.addClient(c1);
		clientService.addClient(c2);
		clientService.addClient(c3);
		clientService.addClient(c4);
		clientService.addClient(c5);
		clientService.addClient(c6);
	}
}

