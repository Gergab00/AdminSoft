/**
 * 
 */
package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Gerardo
 *
 */
public class ControladorCampoID implements FocusListener {

	private JTextField campoID;

	/**
	 * @param campoID
	 * 
	 */
	public ControladorCampoID(JTextField campoID) {
		this.campoID = campoID;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusGained(FocusEvent e) {
		campoID.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	@Override
	public void focusLost(FocusEvent e) {
		if (campoID.getText().contains("\'") || campoID.getText().contains("\"") || campoID.getText().contains(" ")) {
			JOptionPane.showMessageDialog(null, "El ID contiene caracteres no válidos.", "Error",
					JOptionPane.WARNING_MESSAGE);
			campoID.setText("");
		}

	}
}
