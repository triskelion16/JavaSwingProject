package service;

import java.util.ArrayList;

import entity.Invoice;
import view.MainGUI;

public class InvoiceService {
	static ArrayList<Invoice> invoices = new ArrayList<>();
	
	public static ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	
	public static void setInvoices(Invoice invoice) {
		invoices.add(invoice);
		new MainGUI();
	}
	
	public static double getRoundPrice(double price) {
		return Math.round(price * 100.0) / 100.0;
	}

}
