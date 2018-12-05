package entity;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	private static int id;
	private String invoiceNumber;
	private Date date;
	private Client client;
	private ArrayList<Product> products; //list
	private double priceBrutto;
	private int paymentDate;
	private enum PayMethod {CASH, TRANSFER, CREDIT_CARD};
	
	public Invoice() {}
	
	public Invoice(Client client) {
		//invoiceNumber = id++;
		//date.getTime();
		this.client = client;
		//this.product = product;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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

	public double getPriceBrutto() {
		return priceBrutto;
	}
	public void setPriceBrutto(double priceBrutto) {
		this.priceBrutto = priceBrutto;
	}

	public int getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(int paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", date=" + date + ", client=" + client + ", products="
				+ products + ", priceBrutto=" + priceBrutto + ", paymentDate=" + paymentDate + "]";
	}

}
