package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Gerardo
 *
 */
public class Grupos implements Serializable, Conexion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private ConexionMySQL miConexion;
	private static String ID;

	public Grupos() {
		// TODO Auto-generated constructor stub
		miConexion = Conexion.cm;
		
	}

	/**
	 * @param cm
	 * 
	 */
	public Grupos(ConexionMySQL cm) {
		// TODO Auto-generated constructor stub
		this.miConexion = cm;

	}

	public boolean crearGrupos(String id, String nomgpo) {
		miConexion.conexion();
		boolean rt = miConexion.setInstruccionSQL(
				"INSERT INTO `grupos` (`ID`, `NOMGPO`) VALUES ('" + id + "', '" + nomgpo + "')");
		miConexion.cerrarConexion();
		return  rt;

	}

	public ArrayList<String> getArrayDeptos() {
		
		miConexion.setInstruccionSQL("SELECT * FROM `grupos` ORDER BY `grupos`.`ID` ASC");

		ArrayList<String> miArray = miConexion.recorrerResultSet();

		return miArray;

	}

	public Vector<String> dameVector() {
		
		miConexion.conexion();

		miConexion.setInstruccionSQL("SELECT * FROM `grupos` ORDER BY `grupos`.`ID` ASC");

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

	public boolean eliminarGrupo(String st) {
		
		boolean rt;
		
		miConexion.conexion();
		
		rt = miConexion.setInstruccionSQL("DELETE FROM `grupos` WHERE `grupos`.`ID` = \'" + st + "\'");
		
		miConexion.cerrarConexion();

		return rt;
	}

	public boolean modificarGrupo(String stID, String stNewID, String stNom) {
		
		miConexion.conexion();
		
		boolean rt = miConexion.setInstruccionSQL("UPDATE `grupos` SET `ID` = '" + stNewID + "',`NOMGPO` = '" + stNom
				+ "' WHERE `grupos`.`ID` = '" + stID + "'");
		
		miConexion.cerrarConexion();

		return rt;
	}

	public String dameGrupo(String st) {
		miConexion.setInstruccionSQL("SELECT * FROM `grupos` WHERE `ID`='" + st + "'");
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
