package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entity.Client;
import entity.Invoice;
import entity.Product;
import service.ClientService;
import service.InvoiceService;
import service.ProductService;

public class InvoiceNewGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private InvoiceService invoiceService;
	private ClientService clientService;
	private ProductService productService;
	private MainGUI mainGUI;
	
	Invoice invoice = new Invoice();
	//Product product;
	
	private double nettoSum = 0;
	private double bruttoSum = 0;
	
	public InvoiceNewGUI(InvoiceService invoiceService, ProductService productService, ClientService clientService, MainGUI mainGUI) {
		this.invoiceService = invoiceService;
		this.productService = productService;
		this.clientService = clientService;
		this.mainGUI = mainGUI;
		
		setBounds(200, 50, 1000, 800);
		setLayout(null);
		setVisible(true);

		setInvoiceNumberAddDate();
		setClient();
		setCompanyData();
		productTable();
		resume();
		isInvoiceEditable();
		save();
	}

	// ******* Button - zapisz i zamknij ******************************
	private void save() {
		JButton saveButton = new JButton("Zapisz i zamknij");
		saveButton.setBounds(355, 730, 250, 40);
		getContentPane().add(saveButton);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!invoice.isEditable()) {
					invoice.setDate();
					invoice.setInvoiceNumber();
				}

				if (invoice.getClient() == null) {
					JOptionPane.showMessageDialog(null, "Należy wybrać klienta z listy!");
				} else {
					invoiceService.addInvoice(invoice);
					
					//mainGUI. // NIe wiem jak odświeżyć listę w MainGUI
					
					new MainGUI(invoiceService, productService, clientService);
					
					dispose();
				}
			}
		});
	}

	// ******* CheckBox - wystaw fakturę ******************************
	private void isInvoiceEditable() {
		JCheckBox checkBox = new JCheckBox("*** Wystaw fakturę! ***");
		checkBox.setBounds(380, 680, 250, 50);
		getContentPane().add(checkBox);

		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (checkBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "Po wystawieniu faktury - brak możliwości edycji!");
					invoice.setEditable(false);
				} else {
					invoice.setEditable(true);
				}
			}
		});
	}

	// ********** Podsumowanie*****************************
	private void resume() {
//		double nettoSum = 0;
//		double bruttoSum = 0;

//		for (Product p : products) {
//			nettoSum += p.getNettoValue();
//			bruttoSum += p.getBruttoValue();
//		}
		
		//Product[] productsArray = productService.getProducts();
		
//		for(int i = 0; i < productService.getProducts().length; i++) {
//			nettoSum += productService.getProducts()[i].getNettoValue();
//			bruttoSum =+ productService.getProducts()[i].getBruttoValue();
//		}

		JLabel totalNettoLabel = new JLabel("Suma NETTO:    " + nettoSum + " zł.");
		totalNettoLabel.setBounds(770, 460, 200, 30);
		getContentPane().add(totalNettoLabel);

		JLabel totalBruttoLabel = new JLabel("Suma BRUTTO:  " + bruttoSum + " zł.");
		totalBruttoLabel.setBounds(770, 480, 200, 30);
		getContentPane().add(totalBruttoLabel);

//		invoice.setTotalPrice(bruttoSum);
	}

	// ******* Produkty - tabela w panelu i button ***************
	public void productTable() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 200, 1000, 250);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		//products = ProductService.getProducts();
		JList<Product> products = new JList<>(productService.getProducts());
		products.setListData(productService.getProducts());
		
		JScrollPane listScroller = new JScrollPane(products); // Scroll w przypadku większej ilości faktur
		listScroller.setPreferredSize(new Dimension(980, 400));
		panel.add(listScroller);
		
//		if (isNew) {
//			products.clear();
//		}

//		for (int i = 0; i < products.size(); i++) { // ----------------------------------
//			System.out.println(products.get(i).toString());
//		}
//
//		String[] columnNames = { "Nazwa towaru", "Cena netto", "Ilość", "Jednostka", "Wartość netto", "Stawka VAT", "Wartość brutto" };
//		Object[][] data = new Object[products.size()][columnNames.length];
//
//		Product[] productsArray = products.toArray(new Product[products.size()]);
//
//		for (int i = 0; i < products.size(); i++) {
//			data[i][0] = productsArray[i].getName();
//			data[i][1] = productsArray[i].getPriceNetto();
//			data[i][2] = productsArray[i].getQuantity();
//			data[i][3] = productsArray[i].getUnit();
//			data[i][4] = productsArray[i].getNettoValue();
//			data[i][5] = productsArray[i].getTax();
//			data[i][6] = productsArray[i].getBruttoValue();
//		}
//
//		final JTable table = new JTable(data, columnNames); // blokada edycji bezpośrednio w tabeli
//		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
//
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//
//		table.setModel(tableModel);
//
//		TableColumn column = null;
//		for (int i = 0; i < columnNames.length; i++) {
//			column = table.getColumnModel().getColumn(i);
//			if (i == 0)
//				column.setPreferredWidth(200);
//			else
//				column.setPreferredWidth(50);
//		}
//
//		table.setPreferredScrollableViewportSize(new Dimension(980, 2500));
//		table.setFillsViewportHeight(true);
//		JScrollPane scrollPane = new JScrollPane(table);
//		panel.add(scrollPane);

		JLabel separator = new JLabel(
				"___________________________________________________________________________________________________________________________________________________________________");
		separator.setBounds(10, 500, 980, 15);
		getContentPane().add(separator);

		// ------ getName ---------------------------
		JLabel getNameLabel = new JLabel("Nazwa:");
		getNameLabel.setBounds(100, 525, 100, 25);
		getContentPane().add(getNameLabel);

		JTextField getNameField = new JTextField();
		getNameField.setBounds(160, 525, 215, 25);
		getContentPane().add(getNameField);

		// ------ getPriceNetto ---------------------------
		JLabel getPriceNettoLabel = new JLabel("Cena netto:");
		getPriceNettoLabel.setBounds(438, 525, 100, 25);
		getContentPane().add(getPriceNettoLabel);

		JTextField getPriceNettoField = new JTextField();
		getPriceNettoField.setBounds(530, 525, 120, 25);
		getContentPane().add(getPriceNettoField);

		// ------ getQuantity ---------------------------
		JLabel getQuantityLabel = new JLabel("Ilość:");
		getQuantityLabel.setBounds(703, 525, 100, 25);
		getContentPane().add(getQuantityLabel);

		JTextField getQuantityField = new JTextField();
		getQuantityField.setBounds(750, 525, 100, 25);
		getContentPane().add(getQuantityField);

		// ------ getUnit ---------------------------
//		JLabel getUnitLabel = new JLabel("Jednostka:");
//		getUnitLabel.setBounds(215, 560, 100, 25);
//		getContentPane().add(getUnitLabel);
//
//		JComboBox<String> getUnitField = new JComboBox<>(new String[] { "sztuki", "litry", "metry", "kilogramy" });
//		getUnitField.setBounds(300, 560, 130, 25);
//		getContentPane().add(getUnitField);
//		
//		getUnitField.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String selected = (String) getUnitField.getSelectedItem();
//				product.setUnit(selected);
//			}
//		});

		// ------ getTax ---------------------------
		JLabel getTaxLabel = new JLabel("Stawka VAT:");
		getTaxLabel.setBounds(480, 560, 100, 25);
		getContentPane().add(getTaxLabel);

		JTextField getTaxField = new JTextField();
		getTaxField.setBounds(575, 560, 200, 25);
		getContentPane().add(getTaxField);
		

		JButton addProductButton = new JButton("Dodaj nowy produkt");
		addProductButton.setBounds(355, 600, 250, 25);
		getContentPane().add(addProductButton);

		addProductButton.addActionListener(new ActionListener() { // Dodanie produktu listener
			@Override
			public void actionPerformed(ActionEvent e) {
				String getName = getNameField.getText();
				String getPrice = getPriceNettoField.getText();
				String getQuantity = getQuantityField.getText();
				String getTax = getTaxField.getText();

				if (!isEmpty(getName, getPrice, getQuantity, getTax) && isInteger(getTax)
						&& isInteger(getQuantity) && isDouble(getPrice)) {
					
//					 product.setName(getName);
//					 product.setPriceNetto(Double.parseDouble(getPrice));
//					 product.setQuantity(Integer.parseInt(getQuantity));
//					 product.setTax(Integer.parseInt(getTax));
					
					Product product = new Product(getName, Integer.parseInt(getQuantity), Double.parseDouble(getPrice), Integer.parseInt(getTax));
					 
					 productService.addProduct(product);
					 
					 products.setListData(productService.getProducts());
					 
					 getNameField.setText("");
					 getPriceNettoField.setText("");
					 getQuantityField.setText("");
					 getTaxField.setText("");
					 
					 nettoSum = 0;
					 bruttoSum = 0;
					 
					for (int i = 0; i < productService.getProducts().length; i++) {
						System.out.println(productService.getProducts()[i].toString());
						nettoSum += productService.getProducts()[i].getNettoValue();
						bruttoSum += productService.getProducts()[i].getBruttoValue();
					}
					 
					 System.out.println(nettoSum);
					 System.out.println(bruttoSum);
					 
					 invoice.setTotalPrice(bruttoSum);
					 
				} else {
					JOptionPane.showMessageDialog(null, "Wszystkie pola muszą być prawidłowo wypełnione!");
				}
			}
		});
	}

	//--- walidacje pól ---
	protected boolean isDouble(String string) {
		Boolean result = false;
		try {
			Double.parseDouble(string);
			result = true;
		} catch (Exception e) {}

		return result;
	}

	protected boolean isInteger(String string) {
		Boolean result = false;
		try {
			Integer.parseInt(string);
			result = true;
		} catch (Exception e) {}

		return result;
	}

	protected boolean isEmpty(String getName, String getPrice, String getQuantity, String getTax) {
		return getName.isEmpty() && getPrice.isEmpty() && getQuantity.isEmpty() && getTax.isEmpty();
	} 

	// ****** Dane firmy ***************************
	private void setCompanyData() {
		JLabel companyDataLabel = new JLabel("Dane wystawcy faktury:");
		companyDataLabel.setBounds(600, 70, 200, 50);
		getContentPane().add(companyDataLabel);

		JLabel setCompanyName = new JLabel("Nazwa: " + invoice.getCompanyName());
		setCompanyName.setBounds(630, 105, 200, 20);
		getContentPane().add(setCompanyName);

		JLabel setCompanyNip = new JLabel("NIP: " + invoice.getCompanyNip());
		setCompanyNip.setBounds(630, 120, 200, 20);
		getContentPane().add(setCompanyNip);

		JLabel setCompanyAddress = new JLabel("Adres: " + invoice.getCompanyAddress());
		setCompanyAddress.setBounds(630, 135, 400, 20);
		getContentPane().add(setCompanyAddress);
	}

	// ****** Wybór klienta ***************************
	private void setClient() {
		JLabel selectClientLabel = new JLabel("Wybierz klienta:");
		selectClientLabel.setBounds(10, 20, 150, 50);
		getContentPane().add(selectClientLabel);

		JComboBox<Client> comboBox =  new JComboBox<>(clientService.getClients());
		comboBox.setBounds(130, 35, 200, 20);
		getContentPane().add(comboBox);

		JLabel clientLabel = new JLabel("Dane klienta:");
		clientLabel.setBounds(10, 70, 150, 50);
		getContentPane().add(clientLabel);

		JLabel selectedClientNameLabel = new JLabel(); // Client name label
		selectedClientNameLabel.setBounds(30, 105, 200, 20);
		getContentPane().add(selectedClientNameLabel);

		JLabel selectedClientNipLabel = new JLabel(); // Client NIP label
		selectedClientNipLabel.setBounds(30, 120, 200, 20);
		getContentPane().add(selectedClientNipLabel);

		JLabel selectedClientAddressLabel = new JLabel(); // Client address label
		selectedClientAddressLabel.setBounds(30, 135, 300, 20);
		getContentPane().add(selectedClientAddressLabel);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client selected = (Client) comboBox.getSelectedItem();
				
				selectedClientNameLabel.setText("Nazwa: " + selected.getName());
				selectedClientNipLabel.setText("NIP: " + selected.getNip());
				selectedClientAddressLabel.setText("Adres: " + selected.getAddress());

				invoice.setClient(selected);
			}
		});
		
		System.out.println(invoice.getClient());
	}

	// ***** Numer faktury i data *******************
	private void setInvoiceNumberAddDate() {
		JLabel invoiceNumberLabel = new JLabel("Numer faktury:");
		invoiceNumberLabel.setBounds(700, 0, 150, 50);
		getContentPane().add(invoiceNumberLabel);

		JLabel getInvoiceNumberLabel = new JLabel(invoice.getInvoiceNumber());
		getInvoiceNumberLabel.setBounds(850, 0, 100, 50);
		getContentPane().add(getInvoiceNumberLabel);

		JLabel dateLabel = new JLabel("Data wystawienia:");
		dateLabel.setBounds(700, 20, 150, 50);
		getContentPane().add(dateLabel);

		JLabel getDateLabel = new JLabel(invoice.getDate());
		getDateLabel.setBounds(850, 20, 100, 50);
		getContentPane().add(getDateLabel);
	}
}
