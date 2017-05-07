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
/**
 * @author Gerardo
 *
 */
/**
 * @author Gerardo
 *
 */
public class Productos implements Serializable, Conexion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RUTAJDBC, USER, PASSWORD;
	private Connection miConexion;
	private ResultSet miResulset;
	private Statement miStatement;
	private static String st_id;
	private static String st_nomproducto;
	private static String st_nomgrupo;
	private static String st_precio_s_iva;
	private static String st_precio_c_iva;
	private static boolean tiene_iva;
	private static String iva_porc;
	private static String iva_val;
	private static String precio_c_iva;
	public static final int CAMBIO_ID = 0;
	public static final int CAMBIO_NOMBRE = 1;
	public static final int CAMBIO_GPO = 2;
	public static final int CAMBIO_PRECIO_S_IVA = 3;
	public static final int CAMBIO_TIENE_IVA = 4;
	public static final int CAMBIO_IVA_PORC = 5;
	public static final int CAMBIO_IVA_VAL = 6;
	public static final int CAMBIO_PRECIO_C_IVA = 7;
	public static final int DAME_ID = 0;
	public static final int DAME_NOMPRODUCTO = 1;
	public static final int DAME_GPO = 2;
	public static final int DAME_PRECIO_S_IVA = 3;
	public static final int DAME_TIENE_IVA = 4;
	public static final int DAME_IVA_PORC = 5;
	public static final int DAME_IVA_VAL = 6;
	public static final int DAME_PRECIO_C_IVA = 7;

	/**
	 * 
	 */
	public Productos() {
		this.RUTAJDBC = "adminsoft";
		this.USER = "root";
		this.PASSWORD = "";
	}

	public Productos(String rutaJDBC, String user, String password, String bbdd) {
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

	public void autoCommitFalse() throws SQLException {
		miConexion.setAutoCommit(false);
	}

	public void rollback() throws SQLException {
		miConexion.rollback();
	}

	public void commit() throws SQLException {
		miConexion.commit();
	}

	public String crearProducto(String st_id, String st_nomproducto, String st_nomgrupo, String st_precio_s_iva,
			boolean tiene_iva, String iva_porc, String iva_val, String precio_c_iva) {
		String ret = "";
		Productos.st_id = st_id;
		Productos.st_nomproducto = st_nomproducto;
		Productos.st_nomgrupo = st_nomgrupo;
		Productos.st_precio_s_iva = st_precio_s_iva;
		Productos.tiene_iva = tiene_iva;
		Productos.iva_porc = iva_porc;
		Productos.iva_val = iva_val;
		Productos.precio_c_iva = precio_c_iva;

		try {

			miStatement.execute(
					"INSERT INTO `productos` (`IDPRODUCTO`, `NOMPRODUCTO`, `NOMGRUPO`, `PRECIOSIVA`, `TIENEIVA`, `IVAPORC`, `IVAVAL`, `PRECIOCIVA`) "
							+ "VALUES ('" + st_id + "', '" + st_nomproducto + "', '" + st_nomgrupo + "', '"
							+ st_precio_s_iva + "', '" + tiene_iva + "', '" + iva_porc + "', '" + iva_val + "', '"
							+ precio_c_iva + "')");

			ret = "Producto creado exitosamente";

		} catch (SQLException e) {
			ret = e.getMessage();
		}

		return ret;

	}

	public Vector<String> dameVectorProductos() {

		Vector<String> miVector = new Vector<String>();
		ArrayList<String> miArrayList = new ArrayList<String>();

		try {
			
			conexion();
			
			miResulset = miStatement.executeQuery("SELECT * FROM `productos` ORDER BY `productos`.`IDPRODUCTO` ASC");
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			// Revisa si hay datos en el arraylist
			if (!miArrayList.isEmpty()) {

				for (int i = 0; i < miArrayList.size(); i += 8) {

					miVector.addElement(miArrayList.get(i) + " " + miArrayList.get(i + 1) + " " + miArrayList.get(i + 2)
							+ " " + miArrayList.get(i + 3) + " " + miArrayList.get(i + 4) + " " + miArrayList.get(i + 5)
							+ " " + miArrayList.get(i + 6) + " " + miArrayList.get(i + 7));

				}
			} else {
				miVector.addElement("No hay datos en la tabla!");
			}
			
			cerrarConexion();

			return miVector;
		} catch (SQLException e) {
			// Si se genera un error se agrega al array list como unico elemento
			// para mostrarse
			miVector.addElement(e.getMessage());
			return miVector;
		}

	}

	public boolean modificarProducto(int mod, String id, String st) throws SQLException {
		boolean ret = false;

		switch (mod) {
		case CAMBIO_ID:
			ret = miStatement.execute(
					"UPDATE `productos` SET `IDPRODUCTO` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_NOMBRE:
			ret = miStatement.execute("UPDATE `productos` SET `NOMPRODUCTO` = '" + st
					+ "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_GPO:
			ret = miStatement.execute(
					"UPDATE `productos` SET `NOMGRUPO` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_PRECIO_S_IVA:
			ret = miStatement.execute(
					"UPDATE `productos` SET `PRECIOSIVA` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_TIENE_IVA:
			ret = miStatement.execute(
					"UPDATE `productos` SET `TIENEIVA` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_IVA_PORC:
			ret = miStatement.execute(
					"UPDATE `productos` SET `IVAPORC` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		case CAMBIO_IVA_VAL:
			ret = miStatement.execute(
					"UPDATE `productos` SET `IVAVAL` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
		case CAMBIO_PRECIO_C_IVA:
			ret = miStatement.execute(
					"UPDATE `productos` SET `PRECIOCIVA` = '" + st + "' WHERE `productos`.`IDPRODUCTO` = '" + id + "'");
			break;
		default:
			break;
		}

		return ret;
	}
	
	
	/**
	 * 
	 * @return Devuelve el String con la información solicitada por medio del int a.
	 */
	public String dameProducto(String st_id, String st_nom, int a) {

		ArrayList<String> miArrayList = new ArrayList<String>();
		String ret = "";

		try {
			
			if (st_nom == null) {

				miResulset = miStatement.executeQuery("SELECT * FROM `productos` WHERE `IDPRODUCTO`='" + st_id + "'");

			} else if (st_id == null) {

				miResulset = miStatement.executeQuery("SELECT * FROM `productos` WHERE `NOMPRODUCTO` = '" + st_nom + "'");

			}
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
			
		} catch (Exception e) {
			
			miArrayList.add(e.getMessage());
			
		}
		ret = miArrayList.get(a);
		
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
		Productos.st_id = st_id;
	}

	/**
	 * @return the st_nomproducto
	 */
	public static String getSt_nomproducto() {
		return st_nomproducto;
	}

	/**
	 * @param st_nomproducto
	 *            the st_nomproducto to set
	 */
	public static void setSt_nomproducto(String st_nomproducto) {
		Productos.st_nomproducto = st_nomproducto;
	}

	/**
	 * @return the st_nomgrupo
	 */
	public static String getSt_nomgrupo() {
		return st_nomgrupo;
	}

	/**
	 * @param st_nomgrupo
	 *            the st_nomgrupo to set
	 */
	public static void setSt_nomgrupo(String st_nomgrupo) {
		Productos.st_nomgrupo = st_nomgrupo;
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
		Productos.st_precio_s_iva = st_precio_s_iva;
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
		Productos.tiene_iva = tiene_iva;
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
		Productos.iva_porc = iva_porc;
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
		Productos.iva_val = iva_val;
	}

	/**
	 * @return the precio_c_iva
	 */
	public static String getPrecio_c_iva() {
		return precio_c_iva;
	}

	/**
	 * @param precio_c_iva
	 *            the precio_c_iva to set
	 */
	public static void setPrecio_c_iva(String precio_c_iva) {
		Productos.precio_c_iva = precio_c_iva;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Productos.st_precio_c_iva = st_precio_c_iva;
	}

}
