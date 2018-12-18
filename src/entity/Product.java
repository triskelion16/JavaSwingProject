package entity;

public class Product {
	private String name;
	private int quantity;
	private String unit;
	private double priceNetto;
	private double tax;
	
	public Product() {
		unit = "sztuki";
	}
	

	public Product(String name, int quantity, double priceNetto, double tax) {
		this.name = name;
		this.quantity = quantity;
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
		return getRoundPrice(quantity * priceNetto); // Wartość netto zaokrąglona
	}

	public double getBruttoValue() {
		return getRoundPrice(((tax / 100) * getNettoValue()) + getNettoValue()); // Wartość brutto zaokraglona
	}
	
	public static double getRoundPrice(double price) {
		return Math.round(price * 100.0) / 100.0;
	}

//	@Override
//	public String toString() {
//		return "Nazwa: " + name + " | Cena netto: " + quantity + " | Jednostka: " + unit + " | Wartość netto: " + getNettoValue()
//				+ " | Vat: " + tax + " | Wartość brutto: " + getBruttoValue();
//	}
	
	@Override
	public String toString() {
		return "Nazwa: " + name + " | Cena netto: " + priceNetto + " | Ilość: " + quantity + " | Wartość netto: " + getNettoValue()
				+ " | Vat: " + tax + " | Wartość brutto: " + getBruttoValue();
	}

}
