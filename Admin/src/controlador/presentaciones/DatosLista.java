/**
 * 
 */
package controlador.presentaciones;

import java.util.Vector;

import javax.swing.JComboBox;

import modelo.Presentaciones;
import vista.ConsolaPresentaciones;
import vista.ConsolaVerPresentaciones;

/**
 * @author Gerardo
 *
 */
public class DatosLista extends Presentaciones {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;

	/**
	 * @param consolaPresentaciones
	 * 
	 */
	@SuppressWarnings("unchecked")
	public DatosLista(ConsolaPresentaciones consolaPresentaciones) {
		super();
		comboBox = consolaPresentaciones.getComboBoxInsumo();

	}

	@SuppressWarnings("unchecked")
	public DatosLista(ConsolaVerPresentaciones consolaVerPresentaciones) {
		super();
		comboBox = consolaVerPresentaciones.getComboBoxInsumo();
	}

	@SuppressWarnings("rawtypes")
	public Vector dameDatos() {
		Vector miVector = new Vector();
		conexion();
		miVector = dameVector(comboBox.getSelectedItem().toString());
		cerrarConexion();
		return miVector;
	}

}
