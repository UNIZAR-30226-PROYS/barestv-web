package implementacionMysql;


import implementacionPrueba.*;
import java.util.ArrayList;
import java.util.HashMap;

import beans.*;
import dao.*;
import factoria.FactoriaDAO;


public class ProgramacionDAOMysql implements ProgramacionInterfazDAO {

	@Override
	public Programacion getAll(String establecimiento) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Evento> eventos = FactoriaDAO.getEventoDAO("mysql").getAll(establecimiento);
		HashMap<Fecha, ArrayList<Evento>> pr = new HashMap<Fecha, ArrayList<Evento>>();
		for (Evento evento : eventos) {
/*			Fecha ini = evento.getInicio();
			if (!pr.containsKey(ini)){
				pr.put(ini, new ArrayList<Evento>());
				pr.get(ini).add(evento);
			}else{
				pr.get(ini).add(evento);
			}*/
		}
		Programacion p = new Programacion(pr,establecimiento);
		return p;
	}

	

	

}
