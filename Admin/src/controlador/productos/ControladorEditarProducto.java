package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Productos;
import vista.productos.ConsolaProductos;

public class ControladorEditarProducto implements ActionListener {

	private ConsolaProductos consolaProductos;

	public ControladorEditarProducto(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Productos.setSt_id(consolaProductos.getCampoID().getText());
		Productos.setSt_nomproducto(consolaProductos.getCampoNombre().getText());
		Productos.setSt_nomgrupo(consolaProductos.getComboBoxGrupo().getSelectedItem().toString());
		Productos.setSt_precio_s_iva(consolaProductos.getCampoPreciosIVA().getText());
		Productos.setSt_precio_c_iva(consolaProductos.getCampoPreciocIVA().getText());
		Productos.setTiene_iva(consolaProductos.getRdbtnSi().isSelected());
		Productos.setIva_porc(consolaProductos.getCampoIVAPorc().getText());
		Productos.setIva_val(consolaProductos.getCampoCostoVal().getText());
		consolaProductos.getCampoID().setEditable(true);
		consolaProductos.getComboBoxGrupo().setEnabled(true);
		consolaProductos.getCampoNombre().setEditable(true);
		consolaProductos.getCampoPreciosIVA().setEditable(true);
		consolaProductos.getCampoPreciocIVA().setEditable(true);
		consolaProductos.getRdbtnNo().setEnabled(true);
		consolaProductos.getRdbtnSi().setEnabled(true);
		consolaProductos.getBtnGuardar().setEnabled(true);
		consolaProductos.getBtnEliminar().setEnabled(false);
		consolaProductos.getBtnEditar().setEnabled(false);
	}

}
