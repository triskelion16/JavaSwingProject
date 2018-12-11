package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import entity.Client;
import entity.Invoice;
import entity.Product;
import service.ClientService;

public class InvoiceGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	Invoice invoice = new Invoice();
	ArrayList<Client> clients = new ArrayList<>();
	ClientService clientService = new ClientService();

	public InvoiceGUI() {
		JFrame frame = new JFrame("Dodawanie faktury");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(200, 50, 1000, 800);
		frame.setLayout(null);
		frame.setVisible(true);

		setInvoiceNumberAddDate(frame);
		setClient(frame);
		setCompanyData(frame);
		productTable(frame);
	}
	
	//******* Produkty tabela w panelu, button i podsumowanie*****************************
	private void productTable(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 250, 1000, 250);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		Product p1 = new Product("Produkt 1", 2.00, 5, "szt.", 23);
		Product p2 = new Product("Produkt 2", 3.99, 10, "litry", 10);
		
		String[] columnNames = { "Nazwa towaru", "Cena netto", "Ilość", "Jednostka", "Wartość netto", "Stawka VAT", "Wartość brutto" };
Object[][] data = {
		{ p1.getName(), p1.getPriceNetto(), p1.getQuantity(), p1.getUnit(), p1.getNettoValue(), p1.getTax(), p1.getBruttoValue() },
		{ p2.getName(), p2.getPriceNetto(), p2.getQuantity(), p2.getUnit(), p2.getNettoValue(), p2.getTax(), p2.getBruttoValue() } };

		final JTable table = new JTable(data, columnNames);

		 TableColumn column = null;
		 for (int i = 0; i < columnNames.length; i++) {
		 column = table.getColumnModel().getColumn(i);
		 if (i == 0)
		 column.setPreferredWidth(200);
		 else
		 column.setPreferredWidth(50);
		 }

		table.setPreferredScrollableViewportSize(new Dimension(980, 2500));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		
		JButton addProductButton = new JButton("Dodaj nowy produkt");
		addProductButton.setBounds(355, 520, 250, 25);
		frame.getContentPane().add(addProductButton);

		addProductButton.addActionListener(new ActionListener() { // Dodanie produktu listener
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK");
			}
		});
		
		double nettoSum = 0;
		double bruttoSum = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
			}
			nettoSum = (double) data[i][4] + nettoSum;
			bruttoSum = (double) data[i][6] + bruttoSum;
		}
		
		JLabel totalNettoLabel = new JLabel("Suma NETTO:    " + nettoSum + " zł.");
		totalNettoLabel.setBounds(700, 560, 200, 30);
		frame.getContentPane().add(totalNettoLabel);
		
		JLabel totalBruttoLabel = new JLabel("Suma BRUTTO:  " + bruttoSum + " zł.");
		totalBruttoLabel.setBounds(700, 580, 200, 30);
		frame.getContentPane().add(totalBruttoLabel);
	}

	// ****** Dane firmy ***************************
	private void setCompanyData(JFrame frame) {
		JLabel companyDataLabel = new JLabel("Dane wystawcy faktury:");
		companyDataLabel.setBounds(600, 70, 200, 50);
		frame.getContentPane().add(companyDataLabel);

		JLabel setCompanyName = new JLabel("Nazwa: " + invoice.getCompanyName());
		setCompanyName.setBounds(630, 105, 200, 20);
		frame.getContentPane().add(setCompanyName);

		JLabel setCompanyNip = new JLabel("NIP: " + invoice.getCompanyNip());
		setCompanyNip.setBounds(630, 120, 200, 20);
		frame.getContentPane().add(setCompanyNip);

		JLabel setCompanyAddress = new JLabel("Adres: " + invoice.getCompanyAddress());
		setCompanyAddress.setBounds(630, 135, 400, 20);
		frame.getContentPane().add(setCompanyAddress);
	}

	// ****** Wybór klienta ***************************
	private void setClient(JFrame frame) {
		JLabel selectClientLabel = new JLabel("Wybierz klienta:");
		selectClientLabel.setBounds(10, 20, 150, 50);
		frame.getContentPane().add(selectClientLabel);

		clients = ClientService.getClients(); // lista obiektów Client
		ArrayList<String> clientsName = new ArrayList<>();
		for (int i = 0; i < clients.size(); i++) {
			clientsName.add(clients.get(i).getName());
		}
		String[] clientsArray = clientsName.toArray(new String[clientsName.size()]);

		JComboBox<String> comboBox = new JComboBox<>(clientsArray);
		comboBox.setBounds(130, 35, 200, 20);
		frame.getContentPane().add(comboBox);

		JLabel clientLabel = new JLabel("Dane klienta:");
		clientLabel.setBounds(10, 70, 150, 50);
		frame.getContentPane().add(clientLabel);

		JLabel selectedClientNameLabel = new JLabel(); // Client name label
		selectedClientNameLabel.setBounds(30, 105, 200, 20);
		frame.getContentPane().add(selectedClientNameLabel);

		JLabel selectedClientNipLabel = new JLabel(); // Client NIP label
		selectedClientNipLabel.setBounds(30, 120, 200, 20);
		frame.getContentPane().add(selectedClientNipLabel);

		JLabel selectedClientAddressLabel = new JLabel(); // Client address label
		selectedClientAddressLabel.setBounds(30, 135, 300, 20);
		frame.getContentPane().add(selectedClientAddressLabel);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedClient = comboBox.getSelectedIndex();

				selectedClientNameLabel.setText("Nazwa: " + clients.get(selectedClient).getName());
				selectedClientNipLabel.setText("NIP: " + clients.get(selectedClient).getNip());
				selectedClientAddressLabel.setText("Adres: " + clients.get(selectedClient).getAddress());
			}
		});
	}

	// ***** Numer faktury i data *******************
	private void setInvoiceNumberAddDate(JFrame frame) {
		JLabel invoiceNumberLabel = new JLabel("Numer faktury:");
		invoiceNumberLabel.setBounds(700, 0, 150, 50);
		frame.getContentPane().add(invoiceNumberLabel);

		JLabel getInvoiceNumberLabel = new JLabel(invoice.getInvoiceNumber());
		getInvoiceNumberLabel.setBounds(850, 0, 100, 50);
		frame.getContentPane().add(getInvoiceNumberLabel);

		JLabel dateLabel = new JLabel("Data wystawienia:");
		dateLabel.setBounds(700, 20, 150, 50);
		frame.getContentPane().add(dateLabel);

		JLabel getDateLabel = new JLabel(invoice.getDate());
		getDateLabel.setBounds(850, 20, 100, 50);
		frame.getContentPane().add(getDateLabel);
	}
}
