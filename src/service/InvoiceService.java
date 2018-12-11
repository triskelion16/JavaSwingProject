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
		
		Client c1 = new Client("Saturn sp.j.", "8376103872", "01-990 Warszawa, Kwiatowa 2/4");
		Client c2 = new Client("Jowisz sp. z o.o.", "1234567890", "61-100 Poznań, Piękna 5");
		Client c3 = new Client("Mars S.A.", "2874091178", "64-600 Oborniki, Mokra 12/1");
		Client c4 = new Client("Pluton sp.c.", "8826155209", "00-950 Warszawa, Pechowa 13");
		Client c5 = new Client("Wenus sp.j.", "0488132997", "01-991 Warszawa, Sokratesa 8/21");
		Client c6 = new Client("Uran sp.k.", "0935188365", "00-900 Warszawa, Moliera 2");
		
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
		Invoice i3 = new Invoice(c4, products, totalPrice);
		
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
