package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.InvoiceService;

public class Invoice {
	private SimpleDateFormat format;
	
	private static int id = 0;
	private String invoiceNumber;
	private String date;
	private Client client;
	private ArrayList<Product> products; 
	private double totalPrice;
	private boolean isEditable;
	
	private final String companyName = "PW-JavaEE";
	private final String companyNip = "0987654321";
	private final String companyAddress = "00-665 Warszawa, Nowowiejska 15";
	
	public Invoice() {
		invoiceNumber = "* BRAK *";
		date = "* BRAK *";
		isEditable = true;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber() {
		format = new SimpleDateFormat("yyMMdd");
		this.invoiceNumber = format.format(new Date()) + "/" + ++id;
	}

	public String getDate() {
		return date;
	}
	public void setDate() {
		format = new SimpleDateFormat("yyyy-MM-dd");
		this.date = format.format(new Date());
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

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isEditable() {
		return isEditable;
	}
	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public String getCompanyNip() {
		return companyNip;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	
	public static double getRoundPrice(double price) {
		return Math.round(price * 100.0) / 100.0;
	}

	@Override
	public String toString() {
		return "Faktura numer: " + invoiceNumber + "  |  Data wystawienia: " + date + "  |  Nazwa klienta: " + client.getName() + "  |  Nip klienta: " + client.getNip() 
		+ "  |  Kwota faktury brutto: " + getRoundPrice(totalPrice) + " zł.";
	}

}
