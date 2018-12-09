package service;

import java.text.DecimalFormat;
import java.util.ArrayList;

import entity.Client;
import entity.Invoice;
import entity.Product;

public class InvoiceService {
	
	public static ArrayList<String> getInvoices() {
		ArrayList<String> invoices = new ArrayList<>();
		
		Product p1 = new Product("Produkt 1", 50, "sztuki", 5.99, 23);
		Product p2 = new Product("Produkt 1", 50, "sztuki", 20.99, 23);
		
		Client c1 = new Client("Klient 1", "123456789", "01-990 Warszawa, Kwiatowa 2/4");
		Client c2 = new Client("Klient 2", "123456789", "61-100 Poznań, Piękna 5");
		
		ArrayList<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		
		double totalPrice = totalPrice(products);
		
		Invoice i1 = new Invoice(c1, products, totalPrice);
		i1.setInvoiceNumber(i1.getInvoiceNumber());
		i1.setDate(i1.getDate());
		Invoice i2 = new Invoice(c2, products, totalPrice);
		i2.setInvoiceNumber(i2.getInvoiceNumber());
		i2.setDate(i2.getDate());
		Invoice i3 = new Invoice(c1, products, totalPrice);
		
		for(int i = 0; i < 2; i++) {
			invoices.add(i1.toString());
			invoices.add(i2.toString());
			invoices.add(i3.toString());
		}
		
		return invoices;
	}
	
	
	private static double totalPrice(ArrayList<Product> products) {
		double result = 0;
		
		for(Product p : products) {
			result += p.getPriceBrutto();
		}
		
		return result;
	}
	
	
	public static String getRoundPrice(double price) {
		DecimalFormat format = new DecimalFormat("##.00");
		return format.format(price);
	}

}
