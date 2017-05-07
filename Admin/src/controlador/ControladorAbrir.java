/**
 * 
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import vista.ConsolaDepartamento;
import vista.ConsolaGrupos;
import vista.ConsolaInsumo;
import vista.ConsolaPresentaciones;
import vista.ConsolaVerPresentaciones;
import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class ControladorAbrir implements ActionListener {
	
	private JDialog dialog;
	private JFrame frame;
	private ConsolaInsumo consolaInsumo;
	/**
	 * @param consolaInsumo 
	 * 
	 */
	public ControladorAbrir(JFrame frame, JDialog dialog) {
		this.frame = frame;
		this.dialog = dialog;
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "Departamentos":
		case "Abrir Departamentos":
			ConsolaDepartamento cd = new ConsolaDepartamento(frame, dialog);
			break;
		case "Ver Presentaciones":
			ConsolaVerPresentaciones cvp = new ConsolaVerPresentaciones(frame, dialog);
			cvp.pasarVentana(consolaInsumo);
			break;
		case "Agregar Presentación":
			ConsolaPresentaciones cp = new ConsolaPresentaciones(frame, dialog);
			cp.pasarVentana(consolaInsumo);
			break;
		case "Abrir Insumos":
			ConsolaInsumo ci = new ConsolaInsumo(frame,dialog);
			break;
		case "Abrir Grupos":
			ConsolaGrupos cg = new ConsolaGrupos(frame,dialog);
			break;
		case "Abrir Productos":
			ConsolaProductos cpro = new ConsolaProductos(frame, null);
			break;
		default:
			System.out.println(e.getActionCommand());
			break;
		}
		
		
	}

	public void pasarVentanaInsumo(ConsolaInsumo consolaInsumo) {
		this.consolaInsumo = consolaInsumo;
	
	}

}
