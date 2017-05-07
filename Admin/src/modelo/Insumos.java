/**
 * 
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Gerardo
 *
 */
public class Insumos implements Serializable, Conexion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private ConexionMySQL miConexion;
	private static String st_id;
	private static String st_nominsumo;
	private static String st_nomdepto;
	private static String st_unidad;
	private static String st_precio_s_iva;
	private static boolean tiene_iva;
	private static String iva_porc;
	private static String iva_val;
	private static String precio_c_iva;

	public static final String CAMBIO_ID = "5";
	public static final String CAMBIO_NOMBRE = "1";
	public static final String CAMBIO_DEPTO = "2";
	public static final String CAMBIO_UNIDAD = "3";
	public static final String CAMBIO_PRECIO_S_IVA = "4";
	public static final String CAMBIO_PRECIO_C_IVA = "6";
	public static final String CAMBIO_TIENE_IVA = "7";
	public static final String CAMBIO_IVA_PORC = "8";
	public static final String CAMBIO_IVA_VAL = "9";
	public static final int DAME_ID = 0;
	public static final int DAME_INSUMO = 1;
	public static final int DAME_DEPTO = 2;
	public static final int DAME_UNIDAD = 3;
	public static final int DAME_PRECIO_S_IVA = 4;
	public static final int DAME_TIENE_IVA = 5;
	public static final int DAME_IVA_PORC = 6;
	public static final int DAME_IVA_VAL = 7;
	public static final int DAME_PRECIO_C_IVA = 8;
	public static final int ACTUALIZA_INSUMO = 1;
	public static final int ACTUALIZA_UNIDAD = 2;

	/**
	 * 
	 */
	public Insumos() {
		// TODO Auto-generated constructor stub
		this.miConexion = cm;
	}

	public Insumos(ConexionMySQL cm) {
		// TODO Auto-generated constructor stub
		this.miConexion = cm;
	}

	public boolean crearInsumo(String st_id, String st_nominsumo, String st_nomdepto, String st_unidad,
			String st_precio_s_iva, boolean tiene_iva, String iva_porc, String iva_val, String precio_c_iva) {

		int iva_s_n = 0;

		if (tiene_iva) {
			iva_s_n = 1;
		}

		miConexion.conexion();

		boolean ret = miConexion.setInstruccionSQL(
				"INSERT INTO `insumos` (`ID`, `NOMINSUMO`, `NOMDEPTO`, `UNIDAD`, `PRECIO_S_IVA`, `TIENE_IVA`, `IVA_PORC`, "
						+ "`IVA_VAL`, `PRECIO_C_IVA`) VALUES ('" + st_id + "', '" + st_nominsumo + "', '" + st_nomdepto
						+ "', '" + st_unidad + "', '" + st_precio_s_iva + "', '" + iva_s_n + "'" + ", '"
						+ Double.parseDouble(iva_porc) + "', '" + Double.parseDouble(iva_val) + "', '"
						+ Double.parseDouble(precio_c_iva) + "')");

		miConexion.cerrarConexion();

		return ret;
	}

	public ArrayList<String> dameArray() {

		miConexion.conexion();

		miConexion.setInstruccionSQL("SELECT * FROM `insumos` ORDER BY `insumos`.`ID` ASC");

		ArrayList<String> miArray = miConexion.recorrerResultSet();

		miConexion.cerrarConexion();

		return miArray;
		// SELECT * FROM `insumos` WHERE `NOMINSUMO` = 'ATUN'
	}

	public Vector<String> dameVector() {
		miConexion.conexion();

		miConexion.setInstruccionSQL("SELECT * FROM `insumos` ORDER BY `insumos`.`ID` ASC");

		Vector<String> miVector = new Vector<>();
		ArrayList<String> miArray = miConexion.recorrerResultSet();

		if (!miArray.isEmpty()) {

			for (int i = 0; i < miArray.size(); i += 9) {

				miVector.addElement(miArray.get(i) + " " + miArray.get(i + 1) + " " + miArray.get(i + 2) + " "
						+ miArray.get(i + 3) + " " + miArray.get(i + 4) + " " + miArray.get(i + 5) + " " + miArray.get(i + 6) + " "
						+ miArray.get(i + 7) + " " + miArray.get(i + 8));

			}
		} else {
			miVector.addElement("No hay datos en la tabla!");
		}

		miConexion.cerrarConexion();

		return miVector;

	}

	public Vector<String> dameVectorInsumos() {
		miConexion.conexion();

		miConexion.setInstruccionSQL("SELECT * FROM `insumos` ORDER BY `insumos`.`ID` ASC");

		Vector<String> miVector = new Vector<>();
		ArrayList<String> miArray = miConexion.recorrerResultSet();

		if (!miArray.isEmpty()) {

			for (int i = 0; i < miArray.size(); i += 9) {

				miVector.addElement(miArray.get(i + 1));
			}

		} else {

			miVector.addElement("No hay datos en la tabla!");

		}

		miConexion.cerrarConexion();

		return miVector;
	}

	public boolean eliminarInsumo(String st) {

		boolean ret = false;

		miConexion.conexion();

		ret = miConexion.setInstruccionSQL("DELETE FROM `insumos` WHERE `insumos`.`ID` = \'" + st + "\'");

		miConexion.cerrarConexion();

		return ret;
	}

	public boolean eliminarPresentacionesDeInsumo(String nominsumo) {

		boolean ret = false;

		miConexion.conexion();

		ret = miConexion.setInstruccionSQL("DELETE FROM `presentaciones` WHERE `NOMINSUMO`= \'" + nominsumo + "\'");

		miConexion.cerrarConexion();

		return ret;
	}

	public boolean modificarInsumo(String mod, String id, String st) {
		boolean ret = false;
		miConexion.conexion();
		switch (mod) {
		case CAMBIO_NOMBRE:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `NOMINSUMO` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_DEPTO:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `NOMDEPTO` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_UNIDAD:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `UNIDAD` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_PRECIO_S_IVA:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `PRECIO_S_IVA` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_ID:
			ret = miConexion
					.setInstruccionSQL("UPDATE `insumos` SET `ID` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_PRECIO_C_IVA:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `PRECIO_C_IVA` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_TIENE_IVA:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `TIENE_IVA` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_IVA_PORC:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `IVA_PORC` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		case CAMBIO_IVA_VAL:
			ret = miConexion.setInstruccionSQL(
					"UPDATE `insumos` SET `IVA_VAL` = '" + st + "' WHERE `insumos`.`ID` = '" + id + "'");
			break;
		}
		miConexion.cerrarConexion();
		return ret;
	}

	public String dameInsumos(String st_id, String st_nom, int a) {

		String ret = "";

		miConexion.conexion();

		if (st_nom == null) {

			miConexion.setInstruccionSQL("SELECT * FROM `insumos` WHERE `ID`='" + st_id + "'");

			ArrayList<String> miArray = miConexion.recorrerResultSet();

			ret = miArray.get(a);

		} else if (st_id == null) {

			miConexion.setInstruccionSQL("SELECT * FROM `insumos` WHERE `NOMINSUMO` = '" + st_nom + "'");

			ArrayList<String> miArray = miConexion.recorrerResultSet();

			ret = miArray.get(a);

		}

		miConexion.cerrarConexion();

		return ret;
	}

	public boolean updatePresentaciones(String nom_insumo, String nom_cambio, int mod) {
		boolean ret = false;
		miConexion.conexion();
		switch (mod) {
		case ACTUALIZA_INSUMO:
			ret = miConexion.setInstruccionSQL("UPDATE `presentaciones` SET `NOMINSUMO`='" + nom_cambio + "' WHERE `NOMINSUMO`='" + nom_insumo + "'");
			break;
		case ACTUALIZA_UNIDAD:
			ret = miConexion.setInstruccionSQL("UPDATE `presentaciones` SET `UNIDAD`='" + nom_cambio + "' WHERE `NOMINSUMO`='" + nom_insumo + "'");
		default:
			break;
		}
		

		miConexion.cerrarConexion();

		return ret;
	}

	/**
	 * @return the st_id
	 */
	public static String getSt_id() {
		return st_id;
	}

	/**
	 * @param st_id
	 *            the st_id to set
	 */
	public static void setSt_id(String st_id) {
		Insumos.st_id = st_id;
	}

	/**
	 * @return the st_nominsumo
	 */
	public static String getSt_nominsumo() {
		return st_nominsumo;
	}

	/**
	 * @param st_nominsumo
	 *            the st_nominsumo to set
	 */
	public static void setSt_nominsumo(String st_nominsumo) {
		Insumos.st_nominsumo = st_nominsumo;
	}

	/**
	 * @return the st_nomdepto
	 */
	public static String getSt_nomdepto() {
		return st_nomdepto;
	}

	/**
	 * @param st_nomdepto
	 *            the st_nomdepto to set
	 */
	public static void setSt_nomdepto(String st_nomdepto) {
		Insumos.st_nomdepto = st_nomdepto;
	}

	/**
	 * @return the st_unidad
	 */
	public static String getSt_unidad() {
		return st_unidad;
	}

	/**
	 * @param st_unidad
	 *            the st_unidad to set
	 */
	public static void setSt_unidad(String st_unidad) {
		Insumos.st_unidad = st_unidad;
	}

	/**
	 * @return the st_precio_s_iva
	 */
	public static String getSt_precio_s_iva() {
		return st_precio_s_iva;
	}

	/**
	 * @param st_precio_s_iva
	 *            the st_precio_s_iva to set
	 */
	public static void setSt_precio_s_iva(String st_precio_s_iva) {
		Insumos.st_precio_s_iva = st_precio_s_iva;
	}

	/**
	 * @return the tiene_iva
	 */
	public static boolean isTiene_iva() {
		return tiene_iva;
	}

	/**
	 * @param tiene_iva
	 *            the tiene_iva to set
	 */
	public static void setTiene_iva(boolean tiene_iva) {
		Insumos.tiene_iva = tiene_iva;
	}

	/**
	 * @return the iva_porc
	 */
	public static String getIva_porc() {
		return iva_porc;
	}

	/**
	 * @param iva_porc
	 *            the iva_porc to set
	 */
	public static void setIva_porc(String iva_porc) {
		Insumos.iva_porc = iva_porc;
	}

	/**
	 * @return the iva_val
	 */
	public static String getIva_val() {
		return iva_val;
	}

	/**
	 * @param iva_val
	 *            the iva_val to set
	 */
	public static void setIva_val(String iva_val) {
		Insumos.iva_val = iva_val;
	}

	/**
	 * @return the precio_c_iva
	 */
	public static String getSt_precio_c_iva() {
		return precio_c_iva;
	}

	/**
	 * @param precio_c_iva
	 *            the precio_c_iva to set
	 */
	public static void setSt_precio_c_iva(String precio_c_iva) {
		Insumos.precio_c_iva = precio_c_iva;
	}
}
