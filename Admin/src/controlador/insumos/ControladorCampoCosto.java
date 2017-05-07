/**
 * 
 */
package controlador.insumos;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorCampoCosto implements FocusListener{

	private ConsolaInsumo consola;

	/**
	 * @param consolaInsumo 
	 * 
	 */
	public ControladorCampoCosto(ConsolaInsumo consolaInsumo) {
		// TODO Auto-generated constructor stub
		consola = consolaInsumo;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getComponent().getName()) {
		case "campoCostosIVA":
			if (consola.getCampoCostosIVA().getText().equals("0.00")) {
				
				consola.getCampoCostosIVA().setText("");
				
			}		
			break;
		case "campoCostocIVA":
			if (consola.getCampoCostocIVA().getText().equals("0.00")) {
				
				consola.getCampoCostocIVA().setText("");
				
			}		
			break;

		default:
			break;
		} 
		
	}

	/* (non-Javadoc)
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
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "El Campo contiene caracteres no válidos", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		
		default:
			break;
			}
			
	}

}
