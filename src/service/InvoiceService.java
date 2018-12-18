package service;

import java.util.ArrayList;

import entity.Invoice;

public class InvoiceService {
	private ArrayList<Invoice> invoices = new ArrayList<>();

	public Invoice[] getInvoices() {
		return invoices.toArray(new Invoice[invoices.size()]);
	}
	
	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	
	
	
	
	
	
	
	
//	static ArrayList<Invoice> invoices = new ArrayList<>();
//	
//	public static ArrayList<Invoice> getInvoices() {
//		return invoices;
//	}
//	
//	public static void setInvoices(Invoice invoice) {
//		invoices.add(invoice);
//		new MainGUI();
//	}
//	
//	public static double getRoundPrice(double price) {
//		return Math.round(price * 100.0) / 100.0;
//	}

}
