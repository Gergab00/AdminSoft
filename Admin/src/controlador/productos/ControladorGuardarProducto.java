/**
 * 
 */
package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Productos;
import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class ControladorGuardarProducto extends Productos implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaProductos consolaProductos;

	/**
	 * @param consolaProductos
	 * 
	 */
	public ControladorGuardarProducto(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		boolean end = true;

		conexion();

		setSt_id(consolaProductos.getCampoID().getText());
		setSt_nomproducto(consolaProductos.getCampoNombre().getText());
		setSt_nomgrupo(consolaProductos.getComboBoxGrupo().getSelectedItem().toString());
		setSt_precio_s_iva(consolaProductos.getCampoPreciosIVA().getText());
		setPrecio_c_iva(consolaProductos.getCampoPreciocIVA().getText());
		setTiene_iva(consolaProductos.getRdbtnSi().isSelected());
		setIva_porc(consolaProductos.getCampoIVAPorc().getText());
		setIva_val(consolaProductos.getCampoIVA().getText());

		// Revisa si el boton editar fue pulsado antes o se trata de un nuevo
		// producto
		if (!consolaProductos.getBtnNuevo().isEnabled()) {

		if (getSt_nomproducto().contains("\'") || getSt_nomproducto().contains("\"")
					|| getSt_nomproducto().contains("\\")) {
				JOptionPane.showMessageDialog(null, "El Nombre contiene caracteres no válidos", "Error",
						JOptionPane.WARNING_MESSAGE);
				end = false;
			} else {
				crearProducto(getSt_id(), getSt_nomproducto(), getSt_nomgrupo(), getSt_precio_s_iva(), isTiene_iva(),
						getIva_porc(), getIva_val(), getPrecio_c_iva());
			}
		} else {

			try {

				autoCommitFalse();

				if (!getSt_id().equals(consolaProductos.getCampoID().getText())) {
						modificarProducto(CAMBIO_ID, getSt_id(), consolaProductos.getCampoID().getText());
				}

				if (!getSt_nomproducto().equals(consolaProductos.getCampoNombre().getText())) {
					if (!consolaProductos.getCampoNombre().getText().contains("\'")
							&& !consolaProductos.getCampoNombre().getText().contains("\"")) {
						// end = modificarProducto(CAMBIO_NOMBRE, getSt_id(),
						// consolaProductos.getCampoNombre().getText());
					} else {
						JOptionPane.showMessageDialog(null, "El ID contiene caracteres no validos", "Error",
								JOptionPane.WARNING_MESSAGE);
						end = false;
					}
				}

				if (!getSt_nomgrupo().equals(consolaProductos.getComboBoxGrupo().getSelectedItem().toString())) {
					if (!consolaProductos.getComboBoxGrupo().getSelectedItem().toString().contains("\'")
							&& !consolaProductos.getComboBoxGrupo().getSelectedItem().toString().contains("\"")) {
						// end = modificarProducto(CAMBIO_GPO,
						// getSt_id(),consolaProductos.getComboBoxGrupo().getSelectedItem().toString());
					} else {
						JOptionPane.showMessageDialog(null, "El ID contiene caracteres no validos", "Error",
								JOptionPane.WARNING_MESSAGE);
						end = false;
					}
				}

				if (!getSt_precio_s_iva().equals(consolaProductos.getCampoPreciosIVA().getText())) {
					if (!consolaProductos.getCampoPreciosIVA().getText().contains("\'")
							&& !consolaProductos.getCampoPreciosIVA().getText().contains("\"")) {
						// end = modificarProducto(CAMBIO_PRECIO_S_IVA,
						// getSt_id(),consolaProductos.getCampoPreciosIVA().getText());
					} else {
						JOptionPane.showMessageDialog(null, "El ID contiene caracteres no validos", "Error",
								JOptionPane.WARNING_MESSAGE);
						end = false;
					}
				}

				if (!getSt_precio_c_iva().equals(consolaProductos.getCampoPreciocIVA().getText())) {
					if (!consolaProductos.getCampoPreciocIVA().getText().contains("\'")
							&& !consolaProductos.getCampoPreciocIVA().getText().contains("\"")) {
						// end = modificarProducto(CAMBIO_PRECIO_C_IVA,
						// getSt_id(),
						// consolaProductos.getCampoPreciocIVA().getText());
					} else {
						JOptionPane.showMessageDialog(null, "El ID contiene caracteres no validos", "Error",
								JOptionPane.WARNING_MESSAGE);
						end = false;
					}
				}

				if (isTiene_iva() != consolaProductos.getRdbtnSi().isSelected()) {

					String iva = "false";
					if (consolaProductos.getRdbtnSi().isSelected()) {
						iva = "true";
					}

					// end = modificarProducto(CAMBIO_TIENE_IVA, getSt_id(),
					// iva);
				}

				if (!getIva_porc().equals(consolaProductos.getCampoIVAPorc().getText())) {

					// end = modificarProducto(CAMBIO_IVA_PORC, getSt_id(),
					// consolaProductos.getCampoIVAPorc().getText());

				}

				if (!getIva_val().equals(consolaProductos.getCampoIVA().getText())) {

					// end = modificarProducto(CAMBIO_IVA_VAL, getSt_id(),
					// consolaProductos.getCampoIVA().getText());

				}

				commit();

			} catch (Exception e1) {

				try {

					rollback();

				} catch (Exception e2) {

				}

			}
			/*
			 * (non-Javadoc)
			 * 
			 * @see Revisa si hubo cambio en el ID al modificar el IGU, detecta
			 * si hay caracteres invalidos en el ID
			 */

			if (end) {
				consolaProductos.getCampoID().setEditable(false);
				consolaProductos.getCampoNombre().setEditable(false);
				consolaProductos.getComboBoxGrupo().setEditable(false);
				consolaProductos.getCampoPreciosIVA().setEditable(false);
				consolaProductos.getCampoPreciocIVA().setEditable(false);
				consolaProductos.getRdbtnNo().setEnabled(false);
				consolaProductos.getRdbtnSi().setEnabled(false);
				consolaProductos.getBtnGuardar().setEnabled(false);
				consolaProductos.getBtnNuevo().setEnabled(true);
				consolaProductos.getBtnEditar().setEnabled(true);
				consolaProductos.getBtnEliminar().setEnabled(true);
				consolaProductos.getList().setListData(dameVectorProductos());
			} else {
				JOptionPane.showMessageDialog(null, "Hubo un problema al cambiar ciertos datos", "Error",
						JOptionPane.WARNING_MESSAGE);
			}

			cerrarConexion();
		}

	}
}
