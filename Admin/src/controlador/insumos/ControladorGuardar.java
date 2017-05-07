/**
 * 
 */
package controlador.insumos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Insumos;
import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorGuardar extends Insumos implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaInsumo consola;

	/**
	 * @param consolaInsumo
	 * 
	 */
	public ControladorGuardar(ConsolaInsumo consolaInsumo) {
		// TODO Auto-generated constructor stub
		consola = consolaInsumo;
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
		// TODO Auto-generated method stub
		
		String st_id = consola.getCampoID().getText();
		String st_nominsumo = consola.getCampoNombre().getText();
		String st_nomdepto = consola.getComboBoxDepartamento().getSelectedItem().toString();
		String st_unidad = consola.getComboBoxUnidad().getSelectedItem().toString();
		String st_precio_s_iva = consola.getCampoCostosIVA().getText();
		boolean tiene_iva = consola.getRdbtnSi().isSelected();
		String iva_porc = consola.getCampoIVAPorc().getText();
		String iva_val = consola.getCampoIVA().getText();
		String precio_c_iva = consola.getCampoCostocIVA().getText();
		
		if (!consola.getBtnNuevo().isEnabled()) {

			if (st_id.contains("\'") || st_id.contains("\"") || st_id.contains(" ")) {
				JOptionPane.showMessageDialog(null, "El ID contiene caracteres no válidos", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else if (st_nominsumo.contains("\'") || st_nominsumo.contains("\"") || st_nominsumo.contains("\\")) {
				JOptionPane.showMessageDialog(null, "El Nombre contiene caracteres no válidos", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {

				crearInsumo(st_id, st_nominsumo, st_nomdepto, st_unidad, st_precio_s_iva, tiene_iva, iva_porc, iva_val,
						precio_c_iva);

				consola.getCampoID().setText("");
				consola.getCampoID().setEnabled(false);
				consola.getCampoNombre().setText("");
				consola.getCampoNombre().setEnabled(false);
				consola.getComboBoxDepartamento().setEnabled(false);
				consola.getComboBoxUnidad().setEnabled(false);
				consola.getCampoCostosIVA().setText("0.00");
				consola.getCampoCostosIVA().setEnabled(false);
				consola.getRdbtnSi().setEnabled(false);
				consola.getRdbtnNo().setEnabled(false);
				consola.getRdbtnNo().setSelected(true);
				consola.getCampoCostocIVA().setText("0.00");
				consola.getCampoCostocIVA().setEnabled(false);
				consola.getCampoIVA().setText("0.00");
				consola.getCampoIVAPorc().setText("0.00");
				consola.getBtnGuardar().setEnabled(false);
				consola.getBtnNuevo().setEnabled(true);
				consola.getBtnEditar().setEnabled(false);
				consola.getBtnEliminar().setEnabled(false);
				consola.getMntmActualizarCosto().setEnabled(false);
			}
			consola.getList().setListData(new DatosLista().dameDatos());
			consola.getMntmActualizarCosto().setEnabled(false);

		} else {
			
			//System.out.println(Insumos.getSt_id()+"\n"+Insumos.getSt_nominsumo()+"\n"+Insumos.getSt_nomdepto()+"\n"+Insumos.isTiene_iva());

			boolean end = true;

			if (!getSt_id().equals(consola.getCampoID().getText())) {
				if (!consola.getCampoID().getText().contains("\'") && !consola.getCampoID().getText().contains("\"")
						&& !consola.getCampoID().getText().contains(" ")) {
					modificarInsumo(CAMBIO_ID, getSt_id(), consola.getCampoID().getText());
				} else {
					JOptionPane.showMessageDialog(null, "El ID contiene caracteres no validos", "Error",
							JOptionPane.WARNING_MESSAGE);
					end = false;

				}
			}

			if (!getSt_nominsumo().equals(consola.getCampoNombre().getText())) {
				if (!consola.getCampoNombre().getText().contains("\'")
						&& !consola.getCampoNombre().getText().contains("\"")
						&& !consola.getCampoNombre().getText().contains("\\")) {
					modificarInsumo(CAMBIO_NOMBRE, getSt_id(), consola.getCampoNombre().getText());
					updatePresentaciones(getSt_nominsumo(), consola.getCampoNombre().getText(),ACTUALIZA_INSUMO);
				} else {
					JOptionPane.showMessageDialog(null, "El Nombre contiene caracteres no validos", "Error",
							JOptionPane.WARNING_MESSAGE);
					end = false;
				}

			}

			if (!getSt_precio_s_iva().equals(consola.getCampoCostosIVA().getText())) {
				
					modificarInsumo(CAMBIO_PRECIO_S_IVA, getSt_id(), consola.getCampoCostosIVA().getText());

			}

			if (!getSt_nomdepto().equals(consola.getComboBoxDepartamento().getSelectedItem().toString())) {
				modificarInsumo(CAMBIO_DEPTO, getSt_id(),
						consola.getComboBoxDepartamento().getSelectedItem().toString());
			}

			if (!getSt_unidad().equals(consola.getComboBoxUnidad().getSelectedItem().toString())) {
				modificarInsumo(CAMBIO_UNIDAD, getSt_id(), consola.getComboBoxUnidad().getSelectedItem().toString());
				updatePresentaciones(getSt_nominsumo(), consola.getComboBoxUnidad().getSelectedItem().toString(), ACTUALIZA_UNIDAD);
			}

			if (isTiene_iva() != consola.getRdbtnSi().isSelected()) {
				 
				modificarInsumo(CAMBIO_TIENE_IVA, getSt_id(), String.valueOf(tiene_iva));
			}
			
			if(!getIva_porc().equals(consola.getCampoIVAPorc().getText())){
				
				modificarInsumo(CAMBIO_IVA_PORC, getSt_id(), consola.getCampoIVAPorc().getText());
				
			}
			
			if(!getIva_val().equals(consola.getCampoIVA().getText())){
				
				modificarInsumo(CAMBIO_IVA_VAL, getSt_id(), consola.getCampoIVA().getText());
				
			}
			
			if(!getSt_precio_c_iva().equals(consola.getCampoCostocIVA().getText())){
				
				modificarInsumo(CAMBIO_PRECIO_C_IVA, getSt_id(), consola.getCampoCostocIVA().getText());
				
			}

			if (end) {
				consola.getCampoID().setEnabled(false);
				consola.getCampoNombre().setEnabled(false);
				consola.getComboBoxDepartamento().setEnabled(false);
				consola.getComboBoxUnidad().setEnabled(false);
				consola.getCampoCostosIVA().setEnabled(false);
				consola.getRdbtnSi().setEnabled(false);
				consola.getRdbtnNo().setEnabled(false);
				consola.getCampoCostocIVA().setEnabled(false);
				consola.getBtnGuardar().setEnabled(false);
				consola.getBtnNuevo().setEnabled(true);
				consola.getBtnEditar().setEnabled(true);
				consola.getBtnEliminar().setEnabled(true);
				consola.getList().setListData(new DatosLista().dameDatos());
				consola.getMntmActualizarCosto().setEnabled(true);
			}

		}
	}

}
