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
	

	
	
	

//	public static ArrayList<Product> getProducts() {
//		return products;
//	}
//
//	public static void setProducts(Product product) {
//		products.add(product);
//		
//		new InvoiceNewGUI(false);
//	}
}
