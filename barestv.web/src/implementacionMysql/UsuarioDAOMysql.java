package implementacionMysql;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import implementacionPrueba.*;
import beans.*;
import dao.*;
import db.DBFacade;


public class UsuarioDAOMysql implements UsuarioInterfazDAO {

	private DBFacade db = null;
	
	public UsuarioDAOMysql() throws Exception {
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
	public Usuario get(String usuario, String password) throws Exception {
		Usuario user = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from usuario where nick like \""+usuario+"\" and clave like \""+password+"\";"; 
			ResultSet rs = db.ejecutarConsulta(sql);
          
			while (rs.next()){                              		                    
				user = new Usuario(usuario, rs.getString("clave"), rs.getBoolean("permisos"),rs.getBoolean("esAlta")); // c				
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
		return user;	
	}

	@Override
	public Boolean edit(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "UPDATE usuario " +
                "SET  clave = '"+usuario.getPassword()+"'"
					 + ", permisos = "+usuario.isEsAdmin()+""
					 + ", esAlta = "+usuario.isEsAlta()+""
					 + " WHERE  nick = '"+usuario.getUsuario()+"'";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar usuario: "+e.getMessage());
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
	public Boolean add(Usuario usuario) throws Exception {
		Boolean esCorrecto = true;
		try{			
			db.abrirConexion();
			 String queryString = "insert into usuario (nick,clave,permisos,esAlta) values "
			 		+ "('"+usuario.getUsuario()+"'"
					 +",'"+usuario.getPassword()+"'"
			 		+","+usuario.isEsAdmin()+""
					 +","+usuario.isEsAlta()+")";
			 
			db.ejecutarUpdate(queryString);

		}catch (Exception e){
			System.out.println("Error al insertar usuario: "+e.getMessage());
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
	public boolean exist(String usuario) throws Exception {
		boolean es= false;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from usuario where nick like \""+usuario+"\";"; 
			ResultSet rs = db.ejecutarConsulta(sql);
          
			while (rs.next()){                              		                    
				es = true;			
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
		return es;	
	}



}
