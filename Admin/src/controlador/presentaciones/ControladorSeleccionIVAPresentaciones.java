/**
 * 
 */
package controlador.presentaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import vista.ConsolaPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccionIVAPresentaciones implements ActionListener {

	private ConsolaPresentaciones consola;

	/**
	 * @param consolaPresentaciones
	 * 
	 */
	public ControladorSeleccionIVAPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		this.consola = consolaPresentaciones;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (consola.getRdbtnSi().isSelected()) {

			consola.getCampoIVAPorc().setText("16.00");

			double precio = Double.parseDouble(consola.getCampoCostosIVA().getText());

			double precio2 = precio;

			DecimalFormat d = new DecimalFormat("0.00");

			precio *= .160;

			consola.getCampoIVA().setText(d.format(precio));

			precio2 = precio2 + precio;

			consola.getCampoCostocIVA().setText(d.format(precio2));

		}
		if (consola.getRdbtnNo().isSelected()) {

			consola.getCampoIVAPorc().setText("0.00");

			consola.getCampoIVA().setText("0.00");

			consola.getCampoCostocIVA().setText(consola.getCampoCostosIVA().getText());

		}
	}

}
