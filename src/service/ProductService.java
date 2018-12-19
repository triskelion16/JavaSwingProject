package service;

import java.util.ArrayList;

import entity.Product;

public class ProductService {
	private ArrayList<Product> products = new ArrayList<>();
	
	public Product[] getProducts() {
		return products.toArray(new Product[products.size()]);
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void deleteProduct(Product product) {
		products.remove(product);
	}
	
	public Product getProduct(Integer invoiceIndex) {
		return products.get(invoiceIndex);
	}
}
