package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.InvoiceService;

public class Invoice {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private final String company = "PW-JavaEE\nul. Nowowiejska 15\n00-665 Warszawa";
	private static int id;
	private String invoiceNumber;
	private String date;
	private Client client;
	private ArrayList<Product> products; //list
	private double totalPrice;
	
	public Invoice() {}
	
	public Invoice(Client client, ArrayList<Product> products, double totalPrice) {
		invoiceNumber = "* BRAK *";
		date = "* BRAK *";
		this.client = client;
		this.products = products;
		this.totalPrice = totalPrice;
	}

	public String getCompany() {
		return company;
	}

	public String getInvoiceNumber() {
		format = new SimpleDateFormat("yyMMdd");
		invoiceNumber = format.format(new Date()) + "/" + id++;
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getDate() {
		return format.format(new Date());
	}
	public void setDate(String date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getTotal() {
		return totalPrice;
	}
	public void setTotal(double total) {
		this.totalPrice = total;
	}
	
	

	@Override
	public String toString() {
		return "Faktura numer: " + invoiceNumber + " | Data wystawienia: " + date + " | Nazwa klienta: " + client.getName() + " | Nip klienta: " + client.getNip() 
		+ " | Kwota faktury: " + InvoiceService.getRoundPrice(totalPrice) + " zł.";
	}

	
}
