/**
 * 
 */
package vista.productos;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * @author Gerardo
 *
 */
public class TablaModelo extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TablaModelo(Vector<Vector<Object>> data, Vector<Object> columnNames) {
		super.setDataVector(data, columnNames);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int columnIndex) {
		Class clazz = Object.class;

		Object aux = getValueAt(0, columnIndex);
		if (aux != null) {
			clazz = aux.getClass();
		}

		return clazz;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		boolean ret = false;
		if(column==0)ret = true;
		if(column==1)ret = true;
		if(column==3)ret = true;
		return ret;
	}
	
}
