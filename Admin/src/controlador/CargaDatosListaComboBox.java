/**
 * 
 */
package controlador;

import java.awt.event.ActionEvent;
import java.util.Vector;

import controlador.departamentos_grupos.InterfaceDepartamentosGrupos;
import vista.ConsolaInsumo;
import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class CargaDatosListaComboBox implements InterfaceDepartamentosGrupos {

	private ConsolaInsumo consolaInsumo = null;
	private ConsolaProductos consolaProductos = null;

	/**
	 * @param consolaInsumo 
	 * 
	 */
	public CargaDatosListaComboBox(ConsolaInsumo consolaInsumo) {
		this.consolaInsumo  = consolaInsumo;
	}

	public CargaDatosListaComboBox(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
	}

	@SuppressWarnings("rawtypes")
	public Vector getVector() {
		Vector miVector = new Vector();
		if(consolaInsumo != null) miVector = dameVector(DEPTO);
		if(consolaProductos != null) miVector = dameVector(GPO);
		return miVector;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
