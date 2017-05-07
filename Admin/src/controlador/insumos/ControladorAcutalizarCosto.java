/**
 * 
 */
package controlador.insumos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import modelo.Insumos;
import modelo.Presentaciones;
import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorAcutalizarCosto implements ActionListener {

	private ConsolaInsumo consolaInsumo;
	private Presentaciones p;
	private Insumos i;

	/**
	 * @param consolaInsumo
	 * 
	 */
	public ControladorAcutalizarCosto(ConsolaInsumo consolaInsumo) {
		this.consolaInsumo = consolaInsumo;
		p = new Presentaciones();
		i = new Insumos();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent a) {
		Vector<String> miVectorPrecios = new Vector<String>();
		Vector<String> miVectorVolumenes = new Vector<String>();
		double doublePrecios = 0.00;
		double doubleVolumenes = 0.00;
		double total = 0.00;

		// Se inicia la conexion a base de datos
		p.conexion();

		// Se obtienen los vectores con la inforamción del precio y volumen
		miVectorPrecios = p.dameVectorPreciosSIVA(consolaInsumo.getCampoNombre().getText());
		miVectorVolumenes = p.dameVectorVolumenes(consolaInsumo.getCampoNombre().getText());

		// Se cierra la conexion
		

		if (!miVectorPrecios.firstElement().equals("No hay datos en la tabla!")) {
			// Se recorre el Vector convirtiendo los valores String en double
			for (Iterator<String> iteratorPrecios = miVectorPrecios.iterator(); iteratorPrecios.hasNext();) {
				doublePrecios += Double.parseDouble(iteratorPrecios.next());

			}

			for (Iterator<String> iteratorVolumenes = miVectorVolumenes.iterator(); iteratorVolumenes.hasNext();) {
				doubleVolumenes += Double.parseDouble(iteratorVolumenes.next());

			}
			
			// System.out.println("Precio total: " + doublePrecios);
			// System.out.println("Volumen total: " + doubleVolumenes);
			//Se obtiene el precio por unidad
			total = doublePrecios / doubleVolumenes;
			// System.out.println("Precio por unidad: " + total);
			//Se establece en la GUI los valores
			consolaInsumo.getCampoCostosIVA().setText(String.valueOf(total+"0"));
			i.modificarInsumo(Insumos.CAMBIO_PRECIO_S_IVA, consolaInsumo.getCampoID().getText(),consolaInsumo.getCampoCostosIVA().getText());
			if (consolaInsumo.getRdbtnSi().isSelected()) {
				consolaInsumo.getCampoIVA().setText(String.valueOf(total*.16));
				i.modificarInsumo(Insumos.CAMBIO_IVA_VAL,consolaInsumo.getCampoID().getText(), consolaInsumo.getCampoIVA().getText());
				consolaInsumo.getCampoIVAPorc().setText("16.00");
				i.modificarInsumo(Insumos.CAMBIO_IVA_PORC,consolaInsumo.getCampoID().getText(),consolaInsumo.getCampoIVAPorc().getText());
				consolaInsumo.getCampoCostocIVA().setText(String.valueOf(total*1.16));
				i.modificarInsumo(Insumos.CAMBIO_PRECIO_C_IVA,consolaInsumo.getCampoID().getText(),consolaInsumo.getCampoCostocIVA().getText());
			}else{
				consolaInsumo.getCampoCostocIVA().setText(String.valueOf(total));
				i.modificarInsumo(Insumos.CAMBIO_PRECIO_C_IVA,consolaInsumo.getCampoID().getText(),consolaInsumo.getCampoCostocIVA().getText());
			}
			
			consolaInsumo.getList().setListData(new DatosLista().dameDatos());
			
			JOptionPane.showMessageDialog(null, "Costo actualizado correctamente ", "Procesando...",
					JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(null, "No hay presentaciones agregadas a este Insumo", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
		
		p.cerrarConexion();

	}

}
