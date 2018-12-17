package service;

import java.util.ArrayList;

import entity.Client;

public class ClientService {
	private ArrayList<Client> clients = new ArrayList<>();
	
	public Client[] getClients() {
		return clients.toArray(new Client[clients.size()]);
	}
	
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
	
//	public ClientService() {
//		if(clients.isEmpty()) {
//			Client c1 = new Client("Saturn sp.j.", "8376103872", "01-990 Warszawa, Kwiatowa 2/4");
//			Client c2 = new Client("Jowisz sp. z o.o.", "1234567890", "61-100 Poznań, Piękna 5");
//			Client c3 = new Client("Mars S.A.", "2874091178", "64-600 Oborniki, Mokra 12/1");
//			Client c4 = new Client("Pluton sp.c.", "8826155209", "00-950 Warszawa, Pechowa 13");
//			Client c5 = new Client("Wenus sp.j.", "0488132997", "01-991 Warszawa, Sokratesa 8/21");
//			Client c6 = new Client("Uran sp.k.", "0935188365", "00-900 Warszawa, Moliera 2");
//			
//			clients.add(c1);
//			clients.add(c2);
//			clients.add(c3);
//			clients.add(c4);
//			clients.add(c5);
//			clients.add(c6);
//		}
//		
//	}
//
//	public static ArrayList<Client> getClients() {
//		return clients;
//	}
}
