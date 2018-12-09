package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Invoice {
	private static int id;
	private String invoiceNumber;
	//private Date date;
	private Client client;
	private ArrayList<Product> products; //list
	private double priceBrutto;
	private int paymentDate;
	private String[] payMethod = {"Gotówka", "Przelew", "Karta kredytowa"};
	
	public Invoice() {}
	
	
	public String getInvoiceNumber() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		invoiceNumber = format.format(new Date()) + id++;
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

/*	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}*/

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

	public String[] getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String[] payMethod) {
		this.payMethod = payMethod;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", client=" + client + ", products="
				+ products + ", priceBrutto=" + priceBrutto + ", paymentDate=" + paymentDate + ", payMethod="
				+ Arrays.toString(payMethod) + "]";
	}

}
