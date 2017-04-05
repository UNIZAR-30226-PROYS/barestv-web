package implementacionMysql;


import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import beans.*;
import dao.*;
import db.DBFacade;
import factoria.FactoriaDAO;


public class EventoDAOMysql implements EventoInterfazDAO {

	private DBFacade db = null;
	public EventoDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Evento> getAll(String establecimiento)
			throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Evento> eventos = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from programa where bar in (select nickbar from bar where nombre = "+establecimiento+");"; // bar es un acronimo sacarlo de la tabla bar
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			eventos = new ArrayList<Evento>();
			
			while (rs.next()){
				//SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Timestamp fechainicio = rs.getTimestamp("inicio");
				Timestamp fechafin = rs.getTimestamp("fin");
				int fini = Integer.valueOf(fechainicio.getDay()+""+fechainicio.getMonth()+""+fechainicio.getYear());
				int ffin = Integer.valueOf(fechafin.getDay()+""+fechafin.getMonth()+""+fechafin.getYear());
				int hini = Integer.valueOf(fechainicio.getHours()+""+fechainicio.getMinutes());
				int hfin = Integer.valueOf(fechafin.getHours()+""+fechafin.getMinutes());
				
				Evento e= new Evento(
						//nombre,desc, fechaini,fechafin,categoria
						rs.getString("titulo"),rs.getString("descr"),new Fecha(fini,hini),new Fecha(ffin,hfin),rs.getString("cat")
						);
			
				
				eventos.add(e);
		
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener eventos: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return eventos;	
	}

	@Override
	public Evento get(String establecimiento, int idevento) throws Exception {
		// TODO Auto-generated method stub
		
			return null;
		
	
	}

	@Override
	public void add(String establecimiento, Evento e) throws Exception {
		// TODO Auto-generated method stub
		
	}


	

}
