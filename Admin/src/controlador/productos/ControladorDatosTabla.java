/**
 * 
 */
package controlador.productos;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import modelo.Insumos;
import vista.productos.ConsolaProductos;
import vista.productos.TablaModelo;

/**
 * @author Gerardo
 *
 */
public class ControladorDatosTabla implements TableModelListener {

	private TablaModelo miModelo;
	private ConsolaProductos consolaProductos;

	/**
	 * @param miModelo
	 * @param consolaProductos
	 * 
	 */
	public ControladorDatosTabla(TablaModelo miModelo, ConsolaProductos consolaProductos) {
		this.miModelo = miModelo;
		this.consolaProductos = consolaProductos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.event.TableModelListener#tableChanged(javax.swing.event.
	 * TableModelEvent)
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
		Insumos i = new Insumos();
		if (e.getColumn() == 0) {
			String st = (String) miModelo.getValueAt(e.getFirstRow(), 0);

			if (!miModelo.getValueAt(e.getFirstRow(), 0).equals("")) {

				try {
					miModelo.setValueAt(i.dameInsumos(st, null, Insumos.DAME_INSUMO), e.getLastRow(), 2);
					miModelo.setValueAt(i.dameInsumos(st, null, Insumos.DAME_UNIDAD), e.getLastRow(), 4);
					miModelo.setValueAt(i.dameInsumos(st, null, Insumos.DAME_PRECIO_S_IVA), e.getLastRow(), 5);
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "El ID que ingresaste no se encuentra en la base de datos.",
							"Error...", JOptionPane.ERROR_MESSAGE);

					miModelo.setValueAt("", e.getLastRow(), 0);

				}
			}

		} else if (e.getColumn() == 3) {

			try {
				double cantidad = Double.parseDouble(miModelo.getValueAt(e.getLastRow(), 3).toString());
				double precio = Double.parseDouble(miModelo.getValueAt(e.getLastRow(), 5).toString());
				double monto = 0;
				monto = cantidad * precio;
				miModelo.setValueAt(String.valueOf(monto), e.getLastRow(), 6);
			} catch (Exception e2) {

				miModelo.setValueAt("0", e.getLastRow(), 3);

				JOptionPane.showMessageDialog(null, "Tienes que ingresar un dato númerico.", "Error...",
						JOptionPane.ERROR_MESSAGE);

			}
		} else if (e.getColumn() == 6) {
			double suma_costo = 0;
			for (int j = 0; j < miModelo.getRowCount(); j++) {
				suma_costo += Double.parseDouble(miModelo.getValueAt(j, 6).toString());
				
				double precio_actual = Double.parseDouble(consolaProductos.getCampoPrecioActual().getText());
				
				double costo_por = (suma_costo/precio_actual)*100;
				
				double precio_sug = suma_costo*3.33;
				
				consolaProductos.getCampoCostoVal().setText(String.valueOf(suma_costo));
				
				consolaProductos.getCampoCostoPor().setText(String.valueOf(costo_por));
				
				consolaProductos.getCampoPrecioSugerido().setText(String.valueOf(precio_sug));

			}

			

		}

	}

}
