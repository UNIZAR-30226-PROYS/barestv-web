package implementacionPrueba;


import java.util.ArrayList;

import beans.*;
import dao.*;


public class EventoDAOPrueba implements EventoInterfazDAO {

	@Override
	public ArrayList<Evento> getAll(String establecimiento, int idEvento)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Evento> lista = new ArrayList<Evento>();
		lista.add(new Evento("NombreEvento","DescripcionEvento",1,1,2017,21,50,"Deporte"));
		lista.add(new Evento("NombreEvento1","DescripcionEvento1",1,1,2017,21,50,"Deporte1"));
		lista.add(new Evento("NombreEvento2","DescripcionEvento2",1,1,2017,21,50,"Deporte2"));
		return lista;
	}

	@Override
	public Evento get(String establecimiento, int idevento) throws Exception {
		// TODO Auto-generated method stub
		return new Evento("NombreEvento","DescripcionEvento",1,1,2017,21,50,"Deporte");
	}


	

}
