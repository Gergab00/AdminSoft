/**
 * 
 */
package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.productos.ConsolaVerInsumos;
import vista.productos.TablaModelo;

/**
 * @author Gerardo
 *
 */
public class ControladorRetornoDeSeleccion implements ActionListener {

	private ConsolaVerInsumos consolaVerInsumos;
	private TablaModelo tablaModelo;
	private int row;

	/**
	 * @param tablaModelo
	 * @param consolaVerInsumos
	 * @param row 
	 * 
	 */
	public ControladorRetornoDeSeleccion(ConsolaVerInsumos consolaVerInsumos, TablaModelo tablaModelo, int row) {
		this.consolaVerInsumos = consolaVerInsumos;
		this.tablaModelo = tablaModelo;
		this.row = row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String st = "";
		for (int i = 0; i < consolaVerInsumos.getList().getSelectedValue().toString().length(); i++) {

			char sqc = consolaVerInsumos.getList().getSelectedValue().toString().charAt(i);

			if (sqc != ' ') {
				st = st + consolaVerInsumos.getList().getSelectedValue().toString().charAt(i);
			}

			else {
				break;
			}

		}
		
		tablaModelo.setValueAt(st, row, 0);
		
		consolaVerInsumos.getFrmInsumos().dispose();
	}
}
