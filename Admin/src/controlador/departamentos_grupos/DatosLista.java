/**
 * 
 */
package controlador.departamentos_grupos;

import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * @author Gerardo
 *
 */
public class DatosLista implements InterfaceDepartamentosGrupos {

	/**
	 * 
	 */
	public DatosLista() {

	}

	@SuppressWarnings("rawtypes")
	public Vector getVector(String clase) {
		return dameVector(clase);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
