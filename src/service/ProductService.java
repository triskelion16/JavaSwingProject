package service;

import java.util.ArrayList;

import entity.Product;
import view.InvoiceNewGUI;

public class ProductService {
	static ArrayList<Product> products = new ArrayList<>();

	public static ArrayList<Product> getProducts() {
		return products;
	}

	public static void setProducts(Product product) {
		products.add(product);
		
		new InvoiceNewGUI(false);
	}
}
