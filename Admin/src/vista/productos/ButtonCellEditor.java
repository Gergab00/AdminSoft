package vista.productos;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Componente que estamos editando.
	private Component currentValue;

	@SuppressWarnings("serial")
	@Override
	public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row,
			int column) {

		JButton button = null;

		if (value instanceof JButton) {
			button = (JButton) value;
			// Action que permite "limpiar" los valores de una fila
			button.setAction(new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println("Worked");
					//((TablaModelo) table.getModel())
					ConsolaVerInsumos cvi = new ConsolaVerInsumos(null, null);
					cvi.initialize(null, null);
					cvi.pasarDatosCelda(((TablaModelo) table.getModel()),row);
									
				}
			});
			
			button.setIcon(new ImageIcon(ConsolaProductos.class.getResource("/imagenes/lens.png")));
			
		}

		currentValue = button;

		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return currentValue;
	}

}