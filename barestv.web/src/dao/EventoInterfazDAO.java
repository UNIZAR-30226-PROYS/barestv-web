package dao;



import java.util.ArrayList;

import beans.*;

public interface EventoInterfazDAO {
	//Obtener varios
	public ArrayList<Evento> getAll(String establecimiento,int idEvento) throws Exception;
	
	//Obtener uno
	public Evento get(String establecimiento,int idevento) throws Exception;
	


	
}
