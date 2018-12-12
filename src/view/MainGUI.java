package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.InvoiceService;

public class MainGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public MainGUI() {
		JFrame frame = new JFrame("ZDA - Homework");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 50, 1000, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("Program do wystawiania i przeglądania faktur");
		title.setBounds(200, 20, 1000, 90);
		title.setFont(new Font("Sefif", Font.BOLD, 22));
		frame.getContentPane().add(title);
		
		JLabel label = new JLabel("Lista faktur:");
		label.setBounds(10, 130, 100, 50);
		frame.getContentPane().add(label);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 180, 1000, 405);
		frame.getContentPane().add(panel1);
		panel1.setLayout(new FlowLayout());
		
		JList<String> list = new JList<>(new String[] {});
		ArrayList<String> invoices = InvoiceService.getInvoices(); // Lista faktur toString
		
		String[] array = invoices.toArray(new String[invoices.size()]); // Konwersja listy do tablicy
		list.setListData(array);
		
		JScrollPane listScroller = new JScrollPane(list); // Scroll w przypadku większej ilości faktur
		listScroller.setPreferredSize(new Dimension(980, 400));
		panel1.add(listScroller);
		
		JButton button = new JButton("Dodaj nową fakturę");
		button.setBounds(10, 650, 200, 30);
		frame.getContentPane().add(button);
		
		//***** Invoice list listener ************************
		list.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent event) {
		        if (!event.getValueIsAdjusting()){
		            JList<?> source = (JList<?>)event.getSource();
		            //String selected = source.getSelectedValue().toString();
		            Integer selected = source.getSelectedValue().hashCode();
		            System.out.println(selected);
		        }
		    }
		});
		
		//***** Button Listener *****************************
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InvoiceNewGUI();
			}
		});
		
	}
}
