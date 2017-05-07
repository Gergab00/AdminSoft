package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Gerardo
 *
 */
public class Departamentos implements Serializable, Conexion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private ConexionMySQL miConexion;
	private static String ID;

	public Departamentos() {
		// TODO Auto-generated constructor stub
		miConexion = Conexion.cm;
		
	}

	/**
	 * @param cm
	 * 
	 */
	public Departamentos(ConexionMySQL cm) {
		// TODO Auto-generated constructor stub
		this.miConexion = cm;

	}

	public boolean crearDepartamento(String id, String nomdepto) {
		miConexion.conexion();
		boolean rt = miConexion.setInstruccionSQL(
				"INSERT INTO `departamentos` (`ID`, `NOMDEPTO`) VALUES ('" + id + "', '" + nomdepto + "')");
		miConexion.cerrarConexion();
		return  rt;

	}

	public String verDepartamentos() {
		String st = "ID\tDEPTO\n";

		miConexion.setInstruccionSQL("SELECT * FROM `departamentos` ORDER BY `departamentos`.`ID` ASC");

		ArrayList<String> miArray = miConexion.recorrerResultSet();

		if (!miArray.isEmpty()) {
			for (int i = 0; i < miArray.size(); i += 2) {

				st = st + miArray.get(i) + "\t" + miArray.get(i + 1) + "\n";

			}
		} else {
			st = "No hay datos en la tabla!";
		}
		return st;

	}

	public ArrayList<String> getArrayDeptos() {

		miConexion.setInstruccionSQL("SELECT * FROM `departamentos` ORDER BY `departamentos`.`ID` ASC");

		ArrayList<String> miArray = miConexion.recorrerResultSet();

		return miArray;

	}

	public Vector<String> dameVector() {
		
		miConexion.conexion();

		miConexion.setInstruccionSQL("SELECT * FROM `departamentos` ORDER BY `departamentos`.`ID` ASC");

		Vector<String> miVector = new Vector<>();
		
		ArrayList<String> miArray = miConexion.recorrerResultSet();

		if (!miArray.isEmpty()) {
			
			for (int i = 0; i < miArray.size(); i += 2) {

				miVector.addElement(miArray.get(i) + " " + miArray.get(i + 1));

			}
			
		} else {
			
			miVector.addElement("No hay datos en la tabla!");
			
		}
		
		miConexion.cerrarConexion();
		
		return miVector;

	}

	public boolean eliminarDepartamento(String st) {
		
		boolean rt;
		
		miConexion.conexion();
		
		rt = miConexion.setInstruccionSQL("DELETE FROM `departamentos` WHERE `departamentos`.`ID` = \'" + st + "\'");
		
		miConexion.cerrarConexion();

		return rt;
	}

	public boolean modificarDepartamento(String stID, String stNewID, String stNom) {
		
		miConexion.conexion();
		
		boolean rt = miConexion.setInstruccionSQL("UPDATE `departamentos` SET `ID` = '" + stNewID + "',`NOMDEPTO` = '" + stNom
				+ "' WHERE `departamentos`.`ID` = '" + stID + "'");
		
		miConexion.cerrarConexion();

		return rt;
	}

	public String dameDepartamento(String st) {
		miConexion.setInstruccionSQL("SELECT * FROM `departamentos` WHERE `ID`='" + st + "'");
		ArrayList<String> miArray = miConexion.recorrerResultSet();
		return miArray.get(1);
	}

	/**
	 * @return the iD
	 */
	public static String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public static void setID(String iD) {
		ID = iD;
	}
}
