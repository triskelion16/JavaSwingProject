package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import entity.Client;
import entity.Invoice;
import entity.Product;

public class MainGUI extends JFrame{
	Client c1 = new Client("Klient 1", "123456789", "01-990 Warszawa, Kwiatowa 2/4");
	Client c2 = new Client("Klient 2", "123456789", "61-100 Poznań, Piękna 5");
	

	public MainGUI() {
		JFrame frame = new JFrame("ZDA - Homework");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 50, 800, 800);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JLabel title = new JLabel("Program do wystawiania i przeglądania faktur");
		title.setBounds(100, 20, 800, 90);
		title.setFont(new Font("Sefif", Font.BOLD, 22));
		frame.getContentPane().add(title);
		
		JLabel label = new JLabel("Lista faktur:");
		label.setBounds(10, 130, 100, 50);
		frame.getContentPane().add(label);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 180, 800, 400);
		frame.getContentPane().add(panel1);
		panel1.setLayout(new FlowLayout());
		
		JList<String> list = new JList<>(new String[] {});
		
		ArrayList<String> products = new ArrayList<>();
		for(int i = 0; i < 12; i++) {
			products.add(c1.toString());
			products.add(c2.toString());
		}
		
		String[] array = products.toArray(new String[products.size()]);
		list.setListData(array);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(780, 400));
		panel1.add(listScroller);
		
		JButton button = new JButton("Dodaj nową fakturę");
		button.setBounds(10, 650, 200, 30);
		frame.getContentPane().add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hura");
			}
		});
		
	}
}
