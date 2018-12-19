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

	public Invoice getInvoice(Integer invoiceIndex) {
		return invoices.get(invoiceIndex);
	}
}
