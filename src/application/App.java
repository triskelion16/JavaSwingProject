package application;

import java.awt.EventQueue;
import view.MainGUI;

public class App {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainGUI();
			}
		});

	}
	
//	public App() {
//		
//		Product p1 = new Product("Produkt 1", 50, "sztuki", 5.99, 23);
//		Product p2 = new Product("Produkt 1", 50, "sztuki", 20.99, 23);
//		
//		Client c1 = new Client("Klient 1", "123456789", "01-990 Warszawa, Kwiatowa 2/4");
//		Client c2 = new Client("Klient 2", "123456789", "61-100 Poznań, Piękna 5");
//		
//		ArrayList<Product> products = new ArrayList<>();
//		products.add(p1);
//		products.add(p2);
//		
//		double totalPrice = totalPrice(products);
//		
//		Invoice i1 = new Invoice(c1, products, totalPrice, "gotówka");
//		Invoice i2 = new Invoice(c2, products, totalPrice, "gotówka");
//		Invoice i3 = new Invoice(c1, products, totalPrice, "gotówka");
//	}
//
//	private double totalPrice(ArrayList<Product> products) {
//		double result = 0;
//		
//		for(Product p : products) {
//			result += p.getPriceBrutto();
//		}
//		
//		return result;
//	}
	
}

