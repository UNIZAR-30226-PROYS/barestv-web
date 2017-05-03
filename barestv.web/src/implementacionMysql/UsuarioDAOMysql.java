package implementacionMysql;

import java.sql.ResultSet;
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
			String sql =  "select nick, clave, permisos, activado from usuario left join bar on usuario.nick = bar.nickbar where nick = '"+usuario+"' and clave = SHA2('"+password+"', 512) ;"; 
			ResultSet rs = db.ejecutarConsulta(sql);
          
			while (rs.next()){                              		                    
				user = new Usuario(usuario, rs.getString("clave"), rs.getBoolean("permisos"),rs.getBoolean("activado")); // c				
			}
		}catch (Exception e){
			System.out.println("Error al obtener usuario: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexion");
			}
		}
		return user;	
	}



	@Override
	public Boolean edit(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub

		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			 String queryString = "UPDATE usuario " 
                                         + "SET  clave = SHA2('"+usuario.getPassword()+"', 512)"
					 + ", permisos = "+usuario.isEsAdmin()+""
					 + " WHERE  nick = '"+usuario.getUsuario()+"'";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar usuario: "+e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public Boolean add(Usuario usuario) throws Exception {
		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			 String queryString = "insert into usuario (nick,clave,permisos) values "
			 		+ "('"+usuario.getUsuario()+"'"
					+", SHA2('"+usuario.getPassword()+"', 512)"
			 		+","+usuario.isEsAdmin()+")";
			db.ejecutarUpdate(queryString);
		} catch (Exception e) {
			System.out.println("Error al insertar usuario: " + e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public Boolean exist(String usuario) throws Exception {
		boolean es = false;

		try {

			db.abrirConexion();
			String sql = "select * from usuario where nick like \"" + usuario + "\";";
			ResultSet rs = db.ejecutarConsulta(sql);

			while (rs.next()) {
				es = true;
			}
		} catch (Exception e) {
			System.out.println("Error al obtener usuario: " + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {

				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
			}
		}
		return es;
	}

	@Override
	public Boolean newPassword(Usuario usuario, String password) throws Exception {
		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			String queryString = "UPDATE usuario " 
                                        + "SET  clave = SHA2('" + password + "', 512)" 
                                        + " WHERE  nick = '" + usuario.getUsuario() + "'";

			db.ejecutarUpdate(queryString);
		} catch (Exception e) {
			System.out.println("Error al modificar el password del usuario: " + e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public Boolean remove(String nickbar) throws Exception {
		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			String queryString = "delete from usuario WHERE nick = '" + nickbar + "'; ";
			db.ejecutarUpdate(queryString);
		} catch (Exception e) {
			System.out.println("Error al eliminar usuario: " + e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}


	@Override
	public Boolean activate(String nickbar) throws Exception {
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "UPDATE bar " 
                                        + "SET  activado = 1 "				
					+ " WHERE  nickbar = '"+nickbar+"'";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar el alta del usuario: "+e.getMessage());
			esCorrecto = false;
		}
		finally {
			try{
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexi�n");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}


}
