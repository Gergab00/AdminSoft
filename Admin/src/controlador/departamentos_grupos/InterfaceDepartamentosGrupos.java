/**
 * 
 */
package controlador.departamentos_grupos;

import java.awt.event.ActionListener;
import java.util.Vector;

import modelo.Departamentos;
import modelo.Grupos;

/**
 * @author Gerardo
 *
 */
public interface InterfaceDepartamentosGrupos extends ActionListener {
	
	public Departamentos deptos = new Departamentos();
	public Grupos gpos = new Grupos();
	public final String GPO = "gpo";
	public final String DEPTO = "depto";
	
	public default void crearDepartamento(String id, String nomdepto) {
		deptos.crearDepartamento(id, nomdepto);
	}
	
	public default void crearGrupos(String id, String nomgpo) {
		gpos.crearGrupos(id, nomgpo);
	}
	
	public default String getID(String clase){
		String ret = "";
		if(clase.equals(DEPTO)) ret = Departamentos.getID();
		if(clase.equals(GPO)) ret = Grupos.getID();
		return ret;
	}
	
	public default void modificarDepartamento(String stID, String stNewID, String stNom) {
		deptos.modificarDepartamento(stID, stNewID, stNom);
	}
	
	public default void modificarGrupo(String stID, String stNewID, String stNom) {
		gpos.modificarGrupo(stID, stNewID, stNom);
	}
	
	public default boolean eliminarDepartamento(String st){
		return deptos.eliminarDepartamento(st);
	}
	
	public default Vector<?> dameVector(String clase){
		Vector <?> miVector = null;
		if(clase.equals(DEPTO)) miVector = deptos.dameVector();
		if(clase.equals(GPO)) miVector = gpos.dameVector();
		return miVector;
	}
}
