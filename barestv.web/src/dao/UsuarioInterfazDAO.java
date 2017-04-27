package dao;



import beans.*;

public interface UsuarioInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener uno
	public Usuario get(String usuario, String password) throws Exception;

	//Edicion y eliminacion
	public Boolean edit(Usuario usuario) throws Exception;
	
	public Boolean newPassword(Usuario usuario,String password) throws Exception;
	
	//public Boolean remove(Usuario usuario) throws Exception;
	public Boolean add(Usuario usuario)throws Exception;

	boolean exist(String usuario) throws Exception;
	
	
}
