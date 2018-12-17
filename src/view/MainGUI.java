package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.Invoice;
import service.ClientService;
import service.InvoiceService;
import service.ProductService;

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private InvoiceService invoiceService;
	private ProductService productService;
	private ClientService clientService;
	
	public MainGUI(InvoiceService invoiceService, ProductService productService, ClientService clientService) {
		this.invoiceService = invoiceService;
		this.productService = productService;
		this.clientService = clientService;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 800);
		setLayout(null);
		setVisible(true);
		
		JLabel title = new JLabel("Program do wystawiania i przeglądania faktur");
		title.setBounds(200, 20, 1000, 90);
		title.setFont(new Font("Sefif", Font.BOLD, 22));
		getContentPane().add(title);
		
		JLabel label = new JLabel("Lista faktur:");
		label.setBounds(10, 130, 100, 50);
		getContentPane().add(label);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 180, 1000, 405);
		getContentPane().add(panel1);
		panel1.setLayout(new FlowLayout());
		
		
		
		JList<Invoice> list = new JList<>(invoiceService.getInvoices());
		list.setListData(invoiceService.getInvoices());
		System.out.println(invoiceService.getInvoices().length);
		
		JScrollPane listScroller = new JScrollPane(list); // Scroll w przypadku większej ilości faktur
		listScroller.setPreferredSize(new Dimension(980, 400));
		panel1.add(listScroller);
		
		JButton button = new JButton("Dodaj nową fakturę");
		button.setBounds(10, 650, 200, 30);
		getContentPane().add(button);
		
		
		//***** Invoice list listener ************************
		list.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		            JList<?> source = (JList<?>)event.getSource();
		            
		            String selected = source.getSelectedValue().toString();
		            System.out.println(selected);
		            
		            Integer invoiceIndex = source.getSelectedIndex();
		            System.out.println(invoiceIndex);
		            
		        }
		    }
		});
		
		//***** Button Listener *****************************
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new InvoiceNewGUI(invoiceService, productService, clientService, MainGUI.this);
				//list.setListData(invoiceService.getInvoices());
				//System.out.println(invoiceService.getInvoices().length);
				
				dispose();
			}
		});
	}
}
