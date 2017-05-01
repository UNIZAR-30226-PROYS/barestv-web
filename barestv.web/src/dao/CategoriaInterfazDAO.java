package dao;


import beans.*;

public interface CategoriaInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener uno
	public Categoria get(String nombreCat) throws Exception;

	//Edicion y eliminacion
	public Boolean edit(Categoria cat) throws Exception;
	//public Boolean remove(Usuario usuario) throws Exception;
	public Boolean add(Categoria cat)throws Exception;

	boolean exist(String nombreCat) throws Exception;
	
	
}
