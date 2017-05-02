package implementacionPrueba;


import java.util.ArrayList;

import beans.*;
import dao.*;


public class EventoDAOPrueba implements EventoInterfazDAO {

	static ArrayList<Evento> eventos;
	
	@Override
	public ArrayList<Evento> getAll(String establecimiento)
			throws Exception {
		// TODO Auto-generated method stub
		return eventos;
	}

	@Override
	public Evento get(String establecimiento, String tituloEvento)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String establecimiento, Evento e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String titulo, String user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(String usuario, Evento e) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(String nickbar) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Evento> getAllAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destacar(String titulo, String bar) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nodestacar(String titulo, String bar) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	


	

}
