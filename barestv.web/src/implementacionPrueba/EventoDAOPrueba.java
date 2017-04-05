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
	public Evento get(String establecimiento, int idevento) throws Exception {
		// TODO Auto-generated method stub
		if(eventos != null){
			return eventos.get(idevento);
		}else{
			return null;
		}
	
	}

	@Override
	public void add(String establecimiento, Evento e) throws Exception {
		// TODO Auto-generated method stub
		if (eventos != null){
			eventos.add(e);
		}else{
			eventos = new ArrayList<Evento>();
		}
		
	}


	

}
