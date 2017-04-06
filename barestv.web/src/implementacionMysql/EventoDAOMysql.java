package implementacionMysql;


import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import beans.*;
import dao.*;
import db.DBFacade;
import factoria.FactoriaDAO;

import java.util.Date;


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
			String sql =  "select * from programa where bar like \""+establecimiento+"\";"; // bar es un acronimo sacarlo de la tabla bar
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			eventos = new ArrayList<Evento>();
			
			while (rs.next()){
				//SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date fechainicio = rs.getTimestamp("inicio");
				Date fechafin = rs.getTimestamp("fin");
                                
				Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
				calendar.setTime(fechainicio);   // assigns calendar to given date 
				
				String mes =  ((calendar.get(Calendar.MONTH)+1) < 10 ) ? ("0"+(calendar.get(Calendar.MONTH)+1)) : ""+(calendar.get(Calendar.MONTH)+1) ;
				
				int fini = Integer.valueOf(calendar.get(Calendar.DAY_OF_MONTH)+""+mes+""+(calendar.get(Calendar.YEAR)));
				String minu = (calendar.get(Calendar.MINUTE) < 10 ) ? ("0"+calendar.get(Calendar.MINUTE)) : ""+(calendar.get(Calendar.MINUTE)) ;
				int hini = Integer.valueOf(calendar.get(Calendar.HOUR_OF_DAY)+""+minu);
				calendar.setTime(fechafin);
				mes =  ((calendar.get(Calendar.MONTH)+1) < 10 ) ? ("0"+(calendar.get(Calendar.MONTH)+1)) : ""+(calendar.get(Calendar.MONTH)+1) ;
				minu = (calendar.get(Calendar.MINUTE) < 10 ) ? ("0"+calendar.get(Calendar.MINUTE)) : ""+(calendar.get(Calendar.MINUTE)) ;
				int ffin = Integer.valueOf(calendar.get(Calendar.DAY_OF_MONTH)+""+mes+""+(calendar.get(Calendar.YEAR)));
				int hfin = Integer.valueOf(calendar.get(Calendar.HOUR_OF_DAY)+""+minu);
				
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
				System.out.println("Error cerrando la conexi?n");
			}
		}
		return eventos;	
	}

	@Override
	public Evento get(String establecimiento, String tituloEvento) throws Exception {
		// TODO Auto-generated method stub
                Evento e = null;
		try{
			
			db.abrirConexion();
			String sql =  "select * from programa where bar like \""+establecimiento+"\" and titulo like "+ tituloEvento +";"; // bar es un acronimo sacarlo de la tabla bar
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			
			while (rs.next()){
				//SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date fechainicio = rs.getDate("inicio");
				Date fechafin = rs.getDate("fin");
                                
                                System.err.println("FI:" + fechainicio);
                                
				int fini = Integer.valueOf(fechainicio.getDay()+""+fechainicio.getMonth()+""+fechainicio.getYear());
				int ffin = Integer.valueOf(fechafin.getDay()+""+fechafin.getMonth()+""+fechafin.getYear());
				int hini = Integer.valueOf(fechainicio.getHours()+""+fechainicio.getMinutes());
				int hfin = Integer.valueOf(fechafin.getHours()+""+fechafin.getMinutes());
				
				e= new Evento(
						//nombre,desc, fechaini,fechafin,categoria
						rs.getString("titulo"),rs.getString("descr"),new Fecha(fini,hini),new Fecha(ffin,hfin),rs.getString("cat")
						);
			
				
		
				
			}
		}catch (Exception ex){
			System.out.println("Error al obtener evento: "+ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi?n");
			}
		}
                return e;
	}

	@Override
	public boolean add(String establecimiento, Evento e) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
//			java.text.SimpleDateFormat sdf = 
//				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String da = sdf.format(comentario.getFecha());
			
			db.abrirConexion();
			String queryString = "insert into programa (titulo, bar, descr, destacado, inicio, fin, cat) values "
			 		+ "('"+e.getNombre()
			 		+"','"+establecimiento
			 		+"','"+e.getDescripcion()
			 		+"','0"
			 		+"','"+e.getInicio().toMySQL()
			 		+"','"+e.getFin().toMySQL()
			 		+"','"+e.getCategoria()
			 		+"');";                    
                        db.ejecutarUpdate(queryString);
		}catch (Exception ex){
			System.out.println("Error al insertar evento: "+ex.getMessage());
			esCorrecto = false;
		}
		finally {
			try{
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi?n");
				esCorrecto = false;
			}
		}
		return esCorrecto;		
	}



	

}
