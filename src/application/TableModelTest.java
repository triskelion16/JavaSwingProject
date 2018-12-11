package application;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableModelTest {
  protected JFrame frame;
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TableModelTest window = new TableModelTest();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  public TableModelTest() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String[] columnNames = {"Imie","Nazwisko","Rok", "Studia" };
    Object[][] data = {
        {"Jan", "Kowalski",new Integer(1984), new Boolean(true)},
        {"Adam", "Nowak",new Integer(1980), new Boolean(false)},
        {"Zosia", "Samosia",new Integer(1970), new Boolean(true)}
    };
    final JTable table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.getContentPane().add(scrollPane);
    frame.pack();
  }
}
