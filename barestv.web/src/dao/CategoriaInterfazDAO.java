package dao;


import beans.*;
import java.util.ArrayList;

public interface CategoriaInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener una
	public Categoria get(String nombreCat) throws Exception;
        
        //Obtener todas
	public ArrayList<Categoria> getAll() throws Exception;

	//Edicion y eliminacion
	public boolean edit(Categoria cat, String nombreCatNuevo) throws Exception;
	public boolean remove(Categoria cat) throws Exception;
	public boolean add(Categoria cat)throws Exception;

	public boolean exist(String nombreCat) throws Exception;
	
	
}
