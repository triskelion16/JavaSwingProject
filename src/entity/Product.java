package entity;

public class Product {
	private String name;
	private Integer quantity;
	private String unit;
	private Double priceNetto;
	private Double tax;
	
//	public Product() {
//		unit = "sztuki";
//	}
	

	public Product(String name, Integer quantity, Double priceNetto, Double tax) {
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

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}

	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPriceNetto() {
		return priceNetto;
	}
	public void setPriceNetto(Double priceNetto) {
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
