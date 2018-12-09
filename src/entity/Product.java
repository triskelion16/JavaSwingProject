package entity;

import service.InvoiceService;

public class Product {
	private String name;
	private int quantity;
	private String unit;
	private double priceNetto;
	private int tax;
	//private double priceBrutto;
	
	public Product() {}
	
	public Product(String name, int quantity, String unit, double priceNetto, int tax) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.priceNetto = priceNetto;
		this.tax = tax;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPriceNetto() {
		return priceNetto;
	}
	public void setPriceNetto(double priceNetto) {
		this.priceNetto = priceNetto;
	}

	public double getPriceBrutto() {
		return priceNetto * tax / 100;
	}
//	public void setPriceBrutto(double priceBrutto) {
//		this.priceBrutto = priceBrutto;
//	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", priceNetto=" + priceNetto
				+ ", tax=" + tax + ", priceBrutto=" + InvoiceService.getRoundPrice(getPriceBrutto()) + "]";
	}


}
