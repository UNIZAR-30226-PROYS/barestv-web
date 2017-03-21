package dao;


import java.util.ArrayList;

import beans.*;

public interface HistorialInterfazDAO {
	//Obtener varios
	//public ArrayList<Usuario> getAll()throws Exception;
	
	//Obtener uno
	public ArrayList<Historial> get(int idUsuario) throws Exception;
	
	//Edicion y eliminacion
	public Boolean add(Historial h)throws Exception;	
}
