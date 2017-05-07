/**
 * 
 */
package modelo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Gerardo
 *
 */
public class Presentaciones implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String RUTAJDBC, USER, PASSWORD;
	private Connection miConexion;
	private ResultSet miResulset;
	private Statement miStatement;
	private static String st_id;
	private static String st_nompres;
	private static String st_insumo_padre;
	private static String st_volumen;
	private static String st_unidad;
	private static String st_precio_s_iva;
	private static boolean tiene_iva;
	private static String iva_porc;
	private static String iva_val;
	private static String st_precio_c_iva;
	private static boolean esEditar;

	public static final int DAME_ID = 0;
	public static final int DAME_PRESENTACION = 1;
	public static final int DAME_INSUMO = 2;
	public static final int DAME_VOLUMEN = 3;
	public static final int DAME_UNIDAD = 4;
	public static final int DAME_PRECIO_S_IVA = 5;
	public static final int DAME_TIENE_IVA = 6;
	public static final int DAME_IVA_VAL = 7;
	public static final int DAME_IVA_PORC = 8;
	public static final int DAME_PRECIO_C_IVA = 9;

	protected static final int CAMBIO_ID = 1;
	protected static final int CAMBIO_NOMPRES = 2;
	protected static final int CAMBIO_VOLUMEN = 3;
	protected static final int CAMBIO_PRECIO_S_IVA = 4;
	protected static final int CAMBIO_TIENE_IVA = 5;
	protected static final int CAMBIO_IVA_VAL = 6;
	protected static final int CAMBIO_IVA_PORC = 7;
	protected static final int CAMBIO_PRECIO_C_IVA = 8;

	/**
	 * 
	 */
	public Presentaciones() {
		this.RUTAJDBC = "adminsoft";
		this.USER = "root";
		this.PASSWORD = "";
	}

	public Presentaciones(String rutaJDBC, String user, String password, String bbdd) {
		this.RUTAJDBC = rutaJDBC;
		this.USER = user;
		this.PASSWORD = password;
	}

	/**
	 * Método para crear la conexión a la base de datos.
	 * 
	 * @return Devuelve un String sobre el resultado de la conexión para
	 *         agregarlo a la IGU.
	 */
	/**
	 * @return
	 */
	public String conexion() {
		try {
			// 1.Crear conexion
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + RUTAJDBC + "?autoReconnect=true&useSSL=false", USER, PASSWORD);
			// 2.Crear Objeto Statement
			miStatement = miConexion.createStatement();
			return "Conexión exitosa!";

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	/**
	 * Método para deconectar la base de datos.
	 * 
	 * @return Devuelve un String sobre el resultado de la desconexión para
	 *         agregarlo a la IGU.
	 */
	public String cerrarConexion() {
		try {
			miConexion.close();
			return "Conexión terminada";
		} catch (SQLException e) {
			return e.getCause().toString();
		}

	}

	/**
	 * Método creado para insertar los datos de una presentación en la base de
	 * datos
	 * 
	 * @return Devuelve un string sobre el resultado de la creácion de la
	 *         presentación en la base de datos
	 */
	public String crearPresentacion(String st_id, String st_nompres, String st_insumo_padre, String st_volumen,
			String st_unidad, String st_precio_s_iva, boolean tiene_iva, String iva_porc, String iva_val,
			String st_precio_c_iva) {
		try {
			miStatement.execute(
					"INSERT INTO `presentaciones` (`ID`, `NOMPRES`, `NOMINSUMO`, `VOLUMEN`, `UNIDAD`, `PRECIOS/IVA`, `TIENEIVA`, `IVA_VAL`, `IVA_PORC`"
							+ ", `PRECIOC/IVA`) VALUES ('" + st_id + "', '" + st_nompres + "', '" + st_insumo_padre
							+ "', '" + st_volumen + "', '" + st_unidad + "', '" + st_precio_s_iva + "', " + "'"
							+ tiene_iva + "', '" + iva_val + "', '" + iva_porc + "', '" + st_precio_c_iva + "')");
			return "Presentación creada exitosamente.";
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	/**
	 * Método creado para devolver un Vector de Strings los precios de las presentaciones de un insumo en especifico.
	 * @return Vector<String>
	 */
	public Vector<String> dameVectorPreciosSIVA(String st_insumo_padre) {
		Vector<String> miVector = new Vector<String>();
		ArrayList<String> miArrayList = new ArrayList<String>();
		try {
			miResulset = miStatement.executeQuery("SELECT * FROM `presentaciones` WHERE `NOMINSUMO`= '"
					+ st_insumo_padre + "' ORDER BY `presentaciones`.`ID` ASC");
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			//Revisa si hay datos en el arraylist
			if (!miArrayList.isEmpty()) {
				//Si hay datos recorre el arraylist y los ordena.
				for (int i = 0; i < miArrayList.size(); i += 10) {
					miVector.addElement(miArrayList.get(i + 5));
				}
			} else {
				//Si no hay elementos agrega un unico elemento con la leyenda No hay datos en la tabla!
				miVector.addElement("No hay datos en la tabla!");
			}

			return miVector;
		} catch (SQLException e) {
			//Si se genera un error se agrega al array list como unico elemento para mostrarse
			miVector.addElement(e.getMessage());
			return miVector;
		}

	}
	
	/**
	 * Método creado para devolver un Vector de Strings los volumenes de las presentaciones de un insumo en especifico.
	 * @return Vector<String>
	 */
	public Vector<String> dameVectorVolumenes(String st_insumo_padre) {
		Vector<String> miVector = new Vector<String>();
		ArrayList<String> miArrayList = new ArrayList<String>();
		try {
			miResulset = miStatement.executeQuery("SELECT * FROM `presentaciones` WHERE `NOMINSUMO`= '"
					+ st_insumo_padre + "' ORDER BY `presentaciones`.`ID` ASC");
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			//Revisa si hay datos en el arraylist
			if (!miArrayList.isEmpty()) {
				//Si hay datos recorre el arraylist y los ordena.
				for (int i = 0; i < miArrayList.size(); i += 10) {
					miVector.addElement(miArrayList.get(i + 3));
				}
			} else {
				//Si no hay elementos agrega un unico elemento con la leyenda No hay datos en la tabla!
				miVector.addElement("No hay datos en la tabla!");
			}

			return miVector;
		} catch (SQLException e) {
			//Si se genera un error se agrega al array list como unico elemento para mostrarse
			miVector.addElement(e.getMessage());
			return miVector;
		}

	}
	
	/**
	 * Método creado para devolver un Vector de Strings con la base de datos ordenada para acomodar en una tabla.
	 * @return Vector<String>
	 */
	public Vector<String> dameVector(String st_insumo_padre) {
		Vector<String> miVector = new Vector<String>();
		ArrayList<String> miArrayList = new ArrayList<String>();
		try {
			miResulset = miStatement.executeQuery("SELECT * FROM `presentaciones` WHERE `NOMINSUMO`= '"
					+ st_insumo_padre + "' ORDER BY `presentaciones`.`ID` ASC");
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			//Revisa si hay datos en el arraylist
			if (!miArrayList.isEmpty()) {
				//Si hay datos recorre el arraylist y los ordena.
				for (int i = 0; i < miArrayList.size(); i += 10) {
					miVector.addElement(miArrayList.get(i) + " " + miArrayList.get(i + 1) + " " + miArrayList.get(i + 2)
							+ " " + miArrayList.get(i + 3) + " " + miArrayList.get(i + 4) + " " + miArrayList.get(i + 5)
							+ " " + miArrayList.get(i + 6) + " " + miArrayList.get(i + 7) + " " + miArrayList.get(i + 8) + " "
							+ miArrayList.get(i + 9));
				}
			} else {
				//Si no hay elementos agrega un unico elemento con la leyenda No hay datos en la tabla!
				miVector.addElement("No hay datos en la tabla!");
			}

			return miVector;
		} catch (SQLException e) {
			//Si se genera un error se agrega al array list como unico elemento para mostrarse
			miVector.addElement(e.getMessage());
			return miVector;
		}

	}

	/**
	 * Método creado para devolver un elemento en especifico de la presentación
	 * Se puede asignar la busqueda por medio del ID o del nombre, dejando un con valor null
	 * @return String
	 */
	public String dameElementoPresentacion(String st_id, String st_nom, int a) {
		String ret = "";
		ArrayList<String> miArrayList = new ArrayList<String>();
		try {
			//Revisa cual valor es null
			if (st_nom == null) {
				miResulset = miStatement.executeQuery("SELECT * FROM `presentaciones` WHERE `ID`='" + st_id + "'");
				} else if (st_id == null) {
					miResulset = miStatement.executeQuery("SELECT * FROM `presentaciones` WHERE `NOMPRES` = '" + st_nom + "'");
				}
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			//Regresa el elemento seleccionado
			ret = miArrayList.get(a);
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		
	}

	public String eliminarPresentacion(String st) {
		try{
			miStatement.execute("DELETE FROM `presentaciones` WHERE `presentaciones`.`ID` = \'" + st + "\'");
			return "Elemento eliminado con exito";
		}catch(SQLException e){
			return e.getMessage();
		}
		
	}

	/**
	 * @param st_id
	 * @param nueva_st
	 * @param mod
	 * @return Devuelve un boolean para permitir el flujo del 
	 * 
	 */
	public boolean modificarPresentaciones(String st_id, String nueva_st, int mod) throws SQLException {
		boolean ret = false;
		
		switch (mod) {
		case CAMBIO_ID:
			ret = miStatement.execute("UPDATE `presentaciones` SET `ID` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_NOMPRES:
			ret = miStatement.execute("UPDATE `presentaciones` SET `NOMPRES` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_VOLUMEN:
			ret = miStatement.execute("UPDATE `presentaciones` SET `VOLUMEN` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_PRECIO_S_IVA:
			ret = miStatement.execute("UPDATE `presentaciones` SET `PRECIOS/IVA` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_TIENE_IVA:
			ret = miStatement.execute("UPDATE `presentaciones` SET `TIENEIVA` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_IVA_VAL:
			ret = miStatement.execute("UPDATE `presentaciones` SET `IVA_VAL` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_IVA_PORC:
			ret = miStatement.execute("UPDATE `presentaciones` SET `IVA_PORC` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		case CAMBIO_PRECIO_C_IVA:
			ret = miStatement.execute("UPDATE `presentaciones` SET `PRECIOC/IVA` = '" + nueva_st
					+ "' WHERE `presentaciones`.`ID` = '" + st_id + "'");
			break;
		}
		return ret;
	}
	
	public void autoCommitFalse() throws SQLException{
		miConexion.setAutoCommit(false);
	}
	
	public void rollback() throws SQLException {
		miConexion.rollback();
	}
	
	public void commit() throws SQLException{
		miConexion.commit();
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
		Presentaciones.st_id = st_id;
	}

	/**
	 * @return the st_nompres
	 */
	public static String getSt_nompres() {
		return st_nompres;
	}

	/**
	 * @param st_nompres
	 *            the st_nompres to set
	 */
	public static void setSt_nompres(String st_nompres) {
		Presentaciones.st_nompres = st_nompres;
	}

	/**
	 * @return the st_insumo_padre
	 */
	public static String getSt_insumo_padre() {
		return st_insumo_padre;
	}

	/**
	 * @param st_insumo_padre
	 *            the st_insumo_padre to set
	 */
	public static void setSt_insumo_padre(String st_insumo_padre) {
		Presentaciones.st_insumo_padre = st_insumo_padre;
	}

	/**
	 * @return the st_volumen
	 */
	public static String getSt_volumen() {
		return st_volumen;
	}

	/**
	 * @param st_volumen
	 *            the st_volumen to set
	 */
	public static void setSt_volumen(String st_volumen) {
		Presentaciones.st_volumen = st_volumen;
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
		Presentaciones.st_unidad = st_unidad;
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
		Presentaciones.st_precio_s_iva = st_precio_s_iva;
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
		Presentaciones.tiene_iva = tiene_iva;
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
		Presentaciones.iva_porc = iva_porc;
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
		Presentaciones.iva_val = iva_val;
	}

	/**
	 * @return the st_precio_c_iva
	 */
	public static String getSt_precio_c_iva() {
		return st_precio_c_iva;
	}

	/**
	 * @param st_precio_c_iva
	 *            the st_precio_c_iva to set
	 */
	public static void setSt_precio_c_iva(String st_precio_c_iva) {
		Presentaciones.st_precio_c_iva = st_precio_c_iva;
	}

	/**
	 * @return the esEditar
	 */
	public static boolean isEsEditar() {
		return esEditar;
	}

	/**
	 * @param esEditar
	 *            the esEditar to set
	 */
	public static void setEsEditar(boolean esEditar) {
		Presentaciones.esEditar = esEditar;
	}

}