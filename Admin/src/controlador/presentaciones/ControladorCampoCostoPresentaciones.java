/**
 * 
 */
package controlador.presentaciones;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vista.ConsolaPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorCampoCostoPresentaciones implements FocusListener {

	private ConsolaPresentaciones consola;

	/**
	 * @param consolaPresentaciones
	 * 
	 */
	public ControladorCampoCostoPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		this.consola = consolaPresentaciones;

		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField campo = (JTextField) e.getSource();
		if (campo.getText().equals("0.00")) {

			campo.setText("");

		}
		/*
		 * switch (e.getComponent().getName()) { case "campoCostosIVA": if
		 * (consola.getCampoCostosIVA().getText().equals("0.00")) {
		 * 
		 * consola.getCampoCostosIVA().setText("");
		 * 
		 * } break; case "campoCostocIVA": if
		 * (consola.getCampoCostocIVA().getText().equals("0.00")) {
		 * 
		 * consola.getCampoCostocIVA().setText("");
		 * 
		 * } break;
		 * 
		 * default: break; }
		 */

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		switch (e.getComponent().getName()) {
		case "campoCostosIVA":

			if (consola.getCampoCostosIVA().getText().equals("")) {

				consola.getCampoCostosIVA().setText("0.00");

			} else {

				try {
					double precio = Double.parseDouble(consola.getCampoCostosIVA().getText());
					double precio2 = precio;

					DecimalFormat d = new DecimalFormat("0.00");

					if (!consola.getCampoCostosIVA().getText().contains(".")) {

						consola.getCampoCostosIVA().setText(consola.getCampoCostosIVA().getText().concat(".00"));

					}

					if (consola.getRdbtnSi().isSelected()) {

						precio *= .16;

						consola.getCampoIVA().setText(d.format(precio));

					} else {

						precio = 0;

					}

					precio2 = precio2 + precio;

					consola.getCampoCostocIVA().setText(d.format(precio2));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					consola.getCampoCostosIVA().setText("0.00");
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			break;

		case "campoCostocIVA":
			if (consola.getCampoCostocIVA().getText().equals("")) {

				consola.getCampoCostocIVA().setText("0.00");

			} else {

				try {
					double precio = Double.parseDouble(consola.getCampoCostocIVA().getText());
					double precio2 = precio;
					DecimalFormat d = new DecimalFormat("0.00");

					if (!consola.getCampoCostocIVA().getText().contains(".")) {

						consola.getCampoCostocIVA().setText(consola.getCampoCostocIVA().getText().concat(".00"));

					}

					if (consola.getRdbtnSi().isSelected()) {

						precio /= 1.16;

						precio = precio2 - precio;

						consola.getCampoIVA().setText(d.format(precio));

					} else {

						precio = 0;

					}

					precio2 = precio2 - precio;

					consola.getCampoCostosIVA().setText(d.format(precio2));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					consola.getCampoCostocIVA().setText("0.00");
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error",JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		case "campoVolumen":
			if (consola.getCampoVolumen().getText().equals("")) {

				consola.getCampoVolumen().setText("0.00");

			} else {

				try {
					double volumen = Double.parseDouble(consola.getCampoVolumen().getText());
					DecimalFormat d = new DecimalFormat("0.00");

					if (!consola.getCampoVolumen().getText().contains(".")) {
						consola.getCampoVolumen().setText(consola.getCampoVolumen().getText().concat(".00"));
					}

					consola.getCampoVolumen().setText(d.format(volumen));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					consola.getCampoVolumen().setText("0.00");
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error",JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		}

	}

}
