package entity;

import service.InvoiceService;

public class Product {
	private String name;
	private int quantity;
	private String unit;
	private double priceNetto;
	private double tax;
	
	public Product() {
		unit = "sztuki";
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

	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
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

	public double getNettoValue() {
		return InvoiceService.getRoundPrice(quantity * priceNetto); // Wartość netto zaokrąglona
	}

	public double getBruttoValue() {
		return InvoiceService.getRoundPrice(((tax / 100) * getNettoValue()) + getNettoValue()); // Wartość brutto zaokraglona
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", priceNetto=" + priceNetto
				+ ", tax=" + tax + "]";
	}

}
