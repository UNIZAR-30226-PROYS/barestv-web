package dao;



import java.util.ArrayList;

import beans.*;

public interface EventoInterfazDAO {
	//Obtener varios
	public ArrayList<Evento> getAll(String establecimiento) throws Exception;
	
	//Obtener uno
	public Evento get(String establecimiento,String tituloEvento) throws Exception;
	
	//Añadir un evento
	public boolean add(String establecimiento, Evento e) throws Exception;
}
