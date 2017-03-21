package dao;


import java.util.ArrayList;


import beans.*;

public interface ComentarioInterfazDAO {
	//Obtener varios
	//public ArrayList<Comentario> getAll()throws Exception;
	public ArrayList<Comentario> get(Producto producto) throws Exception;
	public ArrayList<Comentario> get(Usuario usuario) throws Exception;

	//Guardado y eliminacion de uno en concreto
	public Boolean edit(Comentario comentario) throws Exception;
	public Boolean remove(Comentario comentario) throws Exception;
	public Boolean add(Comentario comentario)throws Exception;
	
}
