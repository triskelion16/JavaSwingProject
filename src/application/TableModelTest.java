package application;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

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

       final JTable table = new JTable(new AbstractTableModel() {
         private String[] columnNames = {"Imie","Nazwisko","Rok", "Studia" };
         private Object[][] data = {
              {"Jan", "Kowalski",new Integer(1984), new Boolean(true)},
              {"Adam", "Nowak",new Integer(1980), new Boolean(false)},
              {"Zosia", "Samosia",new Integer(1970), new Boolean(true)}
               };
      @Override
      public int getRowCount() {
        return data.length;
      }
      @Override
      public int getColumnCount() {
        return columnNames.length;
      }
      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         return data[rowIndex][columnIndex];
      }
      // gdy chcemy aby tablica pokazywała edytowała dane a nie stringi
      /*public Class<?> getColumnClass(int c) {
                return getValueAt(0, c).getClass();
        }  
          // tylko dla tablic edytowanych
          public boolean isCellEditable(int row, int col) {
            return col == 1;  // edytowalne tylko nazwisko
          }      
            // tylko dla tablic edytowanych
          public void setValueAt(Object value, int row, int col) {
              data[row][col] = value;
              fireTableCellUpdated(row, col);
          }
          // gdy nie chcemy nazw A B C
          public String getColumnName(int col) {
              return columnNames[col];
          }*/
       });
       table.setPreferredScrollableViewportSize(new Dimension(500, 70));
       table.setFillsViewportHeight(true);

       table.getModel().addTableModelListener(new TableModelListener(){
      @Override
      public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
            int column = e.getColumn();
            AbstractTableModel model = (AbstractTableModel)e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);
      }         
       });
       
       //Create the scroll pane and add the table to it.
       JScrollPane scrollPane = new JScrollPane(table);

       //Add the scroll pane to this panel.
       frame.getContentPane().add(scrollPane);
       frame.pack();
  }
}
