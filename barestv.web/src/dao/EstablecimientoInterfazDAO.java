package dao;



import java.util.ArrayList;

import beans.*;

public interface EstablecimientoInterfazDAO {
	//Obtener varios
	public ArrayList<Establecimiento> getAll()throws Exception;
	
	//Obtener uno
	public Establecimiento get(String usuario) throws Exception;

	//Edicion y eliminacion
	public Boolean edit(Establecimiento  e) throws Exception;
	public Boolean remove(String nickbar)throws Exception;
	public Boolean add(Establecimiento  e)throws Exception;
	

	
}
