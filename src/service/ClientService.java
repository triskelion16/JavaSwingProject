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
	
}
