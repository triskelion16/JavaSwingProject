package entity;

public class Product {
	private String name;
	private  int quantity;
	private enum Unit {SZTUKI, LITRY, KILOGRAMY, METRY};
	private double price;
	private int tax;
	
	public Product() {}
	
	public Product(String name, int quantity, double price, int tax) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
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

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + ", tax=" + tax
				+ "]";
	}
}
