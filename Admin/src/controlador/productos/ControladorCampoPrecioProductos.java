package controlador.productos;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vista.productos.ConsolaProductos;

public class ControladorCampoPrecioProductos implements FocusListener {

	private ConsolaProductos consolaProductos;
	private JTextField campoPrecioCosto_s_IVA;
	private JRadioButton rdbtnSi;

	public ControladorCampoPrecioProductos(JTextField campoPrecioCosto_s_IVA, JRadioButton rdbtnSi, ConsolaProductos consolaProductos) {
		this.campoPrecioCosto_s_IVA = campoPrecioCosto_s_IVA;
		this.rdbtnSi = rdbtnSi;
		this.consolaProductos = consolaProductos;
	}

	@Override
	public void focusGained(FocusEvent e) {
		switch (e.getComponent().getName()) {
		case "campoPreciosIVA":
			if (campoPrecioCosto_s_IVA.getText().equals("0.00")) {

				campoPrecioCosto_s_IVA.setText("");

			}else{
				
				campoPrecioCosto_s_IVA.selectAll();
				
			}
			break;
		case "campoPreciocIVA":
			if (consolaProductos.getCampoPreciocIVA().getText().equals("0.00")) {

				consolaProductos.getCampoPreciocIVA().setText("");

			}else{
				
				consolaProductos.getCampoPreciocIVA().selectAll();
				
			}
			break;
		default:
			System.out.println(e.getComponent().getName());
			break;
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		switch (e.getComponent().getName()) {
		case "campoPreciosIVA":

			if (campoPrecioCosto_s_IVA.getText().equals("")) {

				campoPrecioCosto_s_IVA.setText("0.00");

			} else {

				try {
					double precio = Double.parseDouble(campoPrecioCosto_s_IVA.getText());
					double precio2 = precio;

					DecimalFormat d = new DecimalFormat("0.00");

					if (!campoPrecioCosto_s_IVA.getText().contains(".")) {

						campoPrecioCosto_s_IVA.setText(campoPrecioCosto_s_IVA.getText().concat(".00"));

					}

					if (rdbtnSi.isSelected()) {

						precio *= .16;


					} else {

						precio = 0;

					}

					precio2 = precio2 + precio;

					consolaProductos.getCampoPreciocIVA().setText(d.format(precio2));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					consolaProductos.getCampoPreciosIVA().setText("0.00");
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		case "campoPreciocIVA":

			if (consolaProductos.getCampoPreciocIVA().getText().equals("")) {

				consolaProductos.getCampoPreciocIVA().setText("0.00");

			} else {

				try {
					double precio = Double.parseDouble(consolaProductos.getCampoPreciocIVA().getText());
					

					DecimalFormat d = new DecimalFormat("0.00");

					if (!consolaProductos.getCampoPreciocIVA().getText().contains(".")) {

						consolaProductos.getCampoPreciocIVA()
								.setText(consolaProductos.getCampoPreciocIVA().getText().concat(".00"));

					}

					if (consolaProductos.getRdbtnSi().isSelected()) {

						precio /= 1.16;

						consolaProductos.getCampoPreciosIVA().setText(d.format(precio));

					} else {

						consolaProductos.getCampoPreciosIVA().setText(d.format(precio));

					}

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					consolaProductos.getCampoPreciocIVA().setText("0.00");
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			break;
		default:
			System.out.println(e.getComponent().getName());
			break;
		}
	}
}
