/**
 * 
 */
package controlador.presentaciones;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Presentaciones;
import vista.ConsolaPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorGuardarPresentaciones extends Presentaciones implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaPresentaciones consola;

	/**
	 * @param consola
	 * 
	 */
	public ControladorGuardarPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		super();
		this.consola = consolaPresentaciones;
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
		String st_id = consola.getCampoID().getText();
		String st_nompres = consola.getCampoNombre().getText();
		String st_insumo_padre = consola.getComboBoxInsumo().getSelectedItem().toString();
		String st_volumen = consola.getCampoVolumen().getText();
		String st_unidad = consola.getCampoUnidad().getText();
		String st_precio_s_iva = consola.getCampoCostosIVA().getText();
		boolean tiene_iva = consola.getRdbtnSi().isSelected();
		String iva_porc = consola.getCampoIVAPorc().getText();
		String iva_val = consola.getCampoIVA().getText();
		String st_precio_c_iva = consola.getCampoCostocIVA().getText();
		conexion();
		if (!isEsEditar()) {
			String st = crearPresentacion(st_id, st_nompres, st_insumo_padre, st_volumen, st_unidad, st_precio_s_iva,
					tiene_iva, iva_porc, iva_val, st_precio_c_iva);
			if (st.equals("Presentación creada exitosamente.")) {
				JOptionPane.showMessageDialog(null, st, "Procesando...", JOptionPane.INFORMATION_MESSAGE);
				consola.getList().setListData(new DatosLista(consola).dameDatos());
				consola.getCampoID().setEditable(false);
				consola.getCampoNombre().setEditable(false);
				consola.getCampoVolumen().setEditable(false);
				consola.getCampoCostosIVA().setEditable(false);
				consola.getCampoCostocIVA().setEditable(false);
				consola.getRdbtnSi().setEnabled(false);
				consola.getRdbtnNo().setEnabled(false);
				consola.getBtnNuevo().setEnabled(true);
				consola.getBtnEditar().setEnabled(true);
				consola.getBtnEliminar().setEnabled(true);
				consola.getBtnGuardar().setEnabled(false);
			}else JOptionPane.showMessageDialog(null, st, "Error...", JOptionPane.WARNING_MESSAGE);
		} else if (isEsEditar()) {
			
			boolean end = false;
			
			try {

				autoCommitFalse();

				if (!getSt_id().equals(st_id)) {
					modificarPresentaciones(getSt_id(), st_id, CAMBIO_ID);
				}

				if (!getSt_nompres().equals(st_nompres)) {

					modificarPresentaciones(getSt_id(), st_nompres, CAMBIO_NOMPRES);
				}

				if (!getSt_volumen().equals(st_volumen)) {
					modificarPresentaciones(getSt_id(), st_volumen, CAMBIO_VOLUMEN);
				}

				if (!getSt_precio_s_iva().equals(st_precio_s_iva)) {
					modificarPresentaciones(getSt_id(), st_precio_s_iva, CAMBIO_PRECIO_S_IVA);
				}

				if (isTiene_iva() != tiene_iva || !getIva_val().equals(iva_val) || !getIva_porc().equals(iva_porc)){
					modificarPresentaciones(getSt_id(), String.valueOf(tiene_iva), CAMBIO_TIENE_IVA);
					modificarPresentaciones(getSt_id(), iva_val, CAMBIO_IVA_VAL);
					modificarPresentaciones(getSt_id(), iva_porc, CAMBIO_IVA_PORC);
				}

				if (!getSt_precio_c_iva().equals(st_precio_c_iva)) {
					modificarPresentaciones(getSt_id(), st_precio_c_iva, CAMBIO_PRECIO_C_IVA);
				}
				
				end = true;
				
				commit();
				
				JOptionPane.showMessageDialog(null, "Modificación extiosa.", "Procesando...", JOptionPane.INFORMATION_MESSAGE);
			} catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Procesando...", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				try {
					rollback();
					System.out.println("Rollback");
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Procesando...",
							JOptionPane.INFORMATION_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Procesando...", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(end){

			consola.getList().setListData(new DatosLista(consola).dameDatos());
			consola.getCampoID().setEditable(false);
			consola.getCampoNombre().setEditable(false);
			consola.getCampoVolumen().setEditable(false);
			consola.getCampoCostosIVA().setEditable(false);
			consola.getCampoCostocIVA().setEditable(false);
			consola.getRdbtnSi().setEnabled(false);
			consola.getRdbtnNo().setEnabled(false);
			consola.getBtnNuevo().setEnabled(true);
			consola.getBtnEditar().setEnabled(true);
			consola.getBtnEliminar().setEnabled(true);
			consola.getBtnGuardar().setEnabled(false);
			
			}

		}

		cerrarConexion();

	}

}
