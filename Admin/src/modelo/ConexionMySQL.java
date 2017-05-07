/**
 * 
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Gerardo
 *
 */
public class ConexionMySQL {
	private final String RUTAJDBC, USER, PASSWORD;
	private static ResultSet miResulset;
	private static Statement miStatement;
	private static Connection miConexion;

	/**
	 * @param rutaJDBC
	 * @param user
	 * @param password
	 * 
	 */
	public ConexionMySQL(String rutaJDBC, String user, String password, String bbdd) {
		// TODO Auto-generated constructor stub
		this.RUTAJDBC = rutaJDBC;
		this.USER = user;
		this.PASSWORD = password;

	}

	public Object conexion() {
		try {
			// 1.Crear conexion
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + RUTAJDBC + "?autoReconnect=true&useSSL=false", USER, PASSWORD);
			// 2.Crear Objeto Statement
			miStatement = miConexion.createStatement();
			return "Conexión exitosa!";

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public Connection dameConnection(){
		return miConexion;
	}

	public ArrayList<String> recorrerResultSet() {
		ArrayList<String> miArrayList = new ArrayList<String>();
		try {
			// 4.Recorrer Resulset
			while (miResulset.next()) {
				for (int i = 1; i <= miResulset.getMetaData().getColumnCount(); i++) {
					// System.out.print(miResulset.getString(i)+"\t");
					miArrayList.add(miResulset.getString(i));
				}
				// System.out.print("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return miArrayList;
	}

	/**
	 * @param instruccionSQL
	 *            the instruccionSQL to set
	 */
	public boolean setInstruccionSQL(String instruccionSQL) {
		// 3.Ejecutar SQL
		boolean b = true;
		try {
			if (instruccionSQL.startsWith("SELECT")) {
				miResulset = miStatement.executeQuery(instruccionSQL);
			} else {
				miStatement.executeUpdate(instruccionSQL);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	/**
	 * @return the miResulset
	 */

	public String cerrarConexion() {
		try {
			miConexion.close();
			return "Conexión terminada";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getCause().toString();
		}

	}

}
