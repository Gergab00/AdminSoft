package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import vista.ConsolaDepartamento;
import vista.ConsolaInsumo;
import vista.ConsolaPresentaciones;
import vista.ConsolaVerPresentaciones;

public class ControladorSalir implements ActionListener {

	private JDialog dialog = null;

	public ControladorSalir(ConsolaDepartamento consolaDepartamento) {
		// TODO Auto-generated constructor stub
		dialog = consolaDepartamento.getFrmDepartamentos();
	}

	public ControladorSalir(ConsolaInsumo consolaInsumo) {
		// TODO Auto-generated constructor stub
		dialog = consolaInsumo.getFrmInsumos();
		
	}

	public ControladorSalir(ConsolaVerPresentaciones consolaVerPresentaciones) {
		// TODO Auto-generated constructor stub
		dialog = consolaVerPresentaciones.getFrameVerPresentaciones();
	}

	public ControladorSalir(ConsolaPresentaciones consolaPresentaciones) {
		// TODO Auto-generated constructor stub
		dialog = consolaPresentaciones.getFrmPresentaciones();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dialog.dispose();
	}

}
