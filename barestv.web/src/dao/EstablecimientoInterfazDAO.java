package dao;



import beans.*;

public interface EstablecimientoInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener uno
	public Establecimiento get(String usuario) throws Exception;

	//Edicion y eliminacion
	public Boolean edit(Establecimiento  e) throws Exception;
	//public Boolean remove(Usuario usuario) throws Exception;
	public Boolean add(Establecimiento  e)throws Exception;

	
}
