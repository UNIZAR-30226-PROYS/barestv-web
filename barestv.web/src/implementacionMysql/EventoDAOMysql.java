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
				
				Evento e= new Evento(
						//nombre,desc, fechaini,fechafin,categoria
						rs.getString("titulo"),rs.getString("descr"),rs.getTimestamp("inicio"),rs.getTimestamp("fin"),rs.getString("cat")
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
		Evento ev= null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from programa where bar like \""+establecimiento+"\" and titulo like \""+tituloEvento+"\";"; // bar es un acronimo sacarlo de la tabla bar
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);

            
			while (rs.next()){   			
				ev= new Evento(
						//nombre,desc, fechaini,fechafin,categoria
						rs.getString("titulo"),rs.getString("descr"),rs.getTimestamp("inicio"),rs.getTimestamp("fin"),rs.getString("cat")
						);
			
				
				
					
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener evento: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi?n");
			}
		}
		return ev;	
	}

	@Override
	public boolean add(String establecimiento, Evento e) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ini = sdf.format(e.getInicio());
			String fin = sdf.format(e.getFin());
			
			db.abrirConexion();
			String queryString = "insert into programa (titulo, bar, descr, destacado, inicio, fin, cat) values "
			 		+ "('"+e.getNombre()
			 		+"','"+establecimiento
			 		+"','"+e.getDescripcion()
			 		+"','0"
			 		+"','"+ini
			 		+"','"+fin
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

	@Override
	public boolean remove(String titulo, String user) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "delete from programa WHERE titulo = \""+titulo+"\" and bar = \""+user+" \"; ";                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar evento: "+e.getMessage());
			esCorrecto = false;
		}
		finally {
			try{
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public boolean edit(String usuario, Evento e) throws Exception {
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ini = sdf.format(e.getInicio());
			String fin = sdf.format(e.getFin());
			 String queryString = "UPDATE programa " +
                "SET  descr = '"+e.getDescripcion()+"'"
					 + ", destacado = 0"
					 + ", inicio = '"+ini+"'"
					 + ", fin = '"+fin+"'"
					 + ", cat = '"+e.getCategoria()+"'"
					 + " WHERE  titulo = '"+e.getNombre()+"' and bar = '"+usuario+" ' ";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception ex){
			System.out.println("Error al modificar establecimiento: "+ex.getMessage());
			esCorrecto = false;
		}
		finally {
			try{
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
				esCorrecto = false;
			}
		}
		return esCorrecto;
		
	}



	

}
