package dao;


import java.util.ArrayList;

import beans.*;

public interface UsuarioInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener uno
	public Usuario get(String correo) throws Exception;
	public Usuario get(Producto p) throws Exception;
	public Usuario get(int idUsuario) throws Exception;
	
	//Edicion y eliminacion
	public Boolean edit(Usuario usuario) throws Exception;
	public Boolean remove(Usuario usuario) throws Exception;
	public Boolean add(Usuario usuario)throws Exception;

	
}
