package implementacionMysql;


import java.sql.ResultSet;
import java.util.ArrayList;
import beans.*;
import dao.*;
import db.DBFacade;


public class EstablecimientoDAOMysql implements EstablecimientoInterfazDAO {

	private DBFacade db = null;
	
	public EstablecimientoDAOMysql() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public Establecimiento get(String usuario) throws Exception {
		Establecimiento est = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from bar where nickbar like \""+usuario+"\";"; 
			ResultSet rs = db.ejecutarConsulta(sql);
          
			while (rs.next()){                              		                    
				est = new Establecimiento(usuario, rs.getString("nombre")
						, rs.getString("descrbar")
						, rs.getBoolean("activado"),
						rs.getDouble("lat"),
						rs.getDouble("lng"),
						rs.getString("direccion"),
						rs.getString("urlimagen")); 			
			}
		}catch (Exception e){
			System.out.println("Error al obtener usuario: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi?n");
			}
		}
		return est;	
	}

	@Override
	public Boolean edit(Establecimiento est) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "UPDATE bar " +
                "SET  nombre = '"+est.getNombre()+"'"
					 + ", descrbar = '"+est.getDescrbar()+"'"
					 + ", activado = "+est.isActivado()+""
					 + ", lat = "+est.getLat()+""
					 + ", lng = "+est.getLng()+""
					 + ", direccion = '"+est.getDireccion()+"'"
					 + ", urlimagen = '"+est.getUrlimagen()+"'"
					 + " WHERE  nickbar = '"+est.getNickbar()+"'";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar establecimiento: "+e.getMessage());
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
	public Boolean add(Establecimiento est) throws Exception {
		Boolean esCorrecto = true;
		try{			
			db.abrirConexion();
			 String queryString = "insert into bar (nickbar,nombre,descrbar,activado,lat,lng,direccion,urlimagen) values "
			 		+ "('"+est.getNickbar()+"'"
					 +",'"+est.getNombre()+"'"
					  +",'"+est.getDescrbar()+"'"
			 		+","+est.isActivado()+""
			 		+","+est.getLat()+""
			 		+","+est.getLng()+""
			 		+",'"+est.getDireccion()+"'"
					 +",'"+est.getUrlimagen()+"')";
			 
			db.ejecutarUpdate(queryString);

		}catch (Exception e){
			System.out.println("Error al modificar establecimiento: "+e.getMessage());
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
	public ArrayList<Establecimiento> getAll() throws Exception {
		ArrayList<Establecimiento> x = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from bar;"; // bar es un acronimo sacarlo de la tabla bar
			ResultSet rs = db.ejecutarConsulta(sql);
			x = new ArrayList<Establecimiento>();         
			while (rs.next()){   
				
				Establecimiento es= new Establecimiento(
						rs.getString("nickbar"), 
						rs.getString("nombre"), rs.getString("descrbar"), 
						rs.getBoolean("activado"), rs.getDouble("lat"), 
						rs.getDouble("lng"), rs.getString("direccion"), 
						rs.getString("urlimagen"));
			
				
				x.add(es);
					
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener todos los establecimientos: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi?n");
			}
		}
		return x;	
	}

	@Override
	public Boolean remove(String nickbar) throws Exception {
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "delete from bar WHERE nickbar = \""+nickbar+"\"; ";                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar establecimiento: "+e.getMessage());
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
