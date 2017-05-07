/**
 * 
 */
package controlador.presentaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Presentaciones;
import vista.ConsolaPresentaciones;
import vista.ConsolaVerPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorEliminarPresentacion extends Presentaciones implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaPresentaciones consola;
	private ConsolaVerPresentaciones consola2;

	/**
	 * @param consolaPresentaciones
	 * 
	 */
	public ControladorEliminarPresentacion(ConsolaPresentaciones consolaPresentaciones) {
		super();
		this.consola = consolaPresentaciones;
	}

	public ControladorEliminarPresentacion(ConsolaVerPresentaciones consolaVerPresentaciones) {
		super();
		this.consola2 = consolaVerPresentaciones;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		conexion();
		if (consola != null) {

			JOptionPane.showMessageDialog(null, eliminarPresentacion(consola.getCampoID().getText()), "Procesando...",
					JOptionPane.INFORMATION_MESSAGE);

			ControladorNuevoPresentaciones cnp = new ControladorNuevoPresentaciones(consola);
			cnp.actionPerformed(null);
			consola.getList().setListData(new DatosLista(consola).dameDatos());
		}

		if (consola2 != null) {
			for (int i = 0; i < consola2.getList().getSelectedValuesList().size(); i++) {
				String st = "";
				for (int j = 0; j < consola2.getList().getSelectedValuesList().get(i).toString().length(); j++) {

					char sqc = consola2.getList().getSelectedValuesList().get(i).toString().charAt(j);

					if (sqc != ' ') {
						st = st + consola2.getList().getSelectedValuesList().get(i).toString().charAt(j);
					}

					else {
						break;
					}
				}

				JOptionPane.showMessageDialog(null, eliminarPresentacion(st), "Procesando...",
						JOptionPane.INFORMATION_MESSAGE);

				consola2.getList().setListData(new DatosLista(consola2).dameDatos());
			}
		}
		
		cerrarConexion();

	}

}
