package vista.productos;
 
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
 
public class ButtonCellRenderer implements TableCellRenderer {

@Override
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
   int row, int column) {
	table.setSelectionBackground(Color.BLACK);
	table.setSelectionForeground(Color.WHITE);
	
  // Devolvemos el bot�n tal cual
  if (value instanceof JButton) {
	  
	  return (JButton) value;
  }
  
  return null;
 
 }
 
}
