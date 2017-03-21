package implementacionMysql;


import java.sql.ResultSet;





import java.util.Date;

import beans.Producto;
import beans.Usuario;
import dao.UsuarioInterfazDAO;
import db.DBFacade;

public class UsuarioDAOMysql implements UsuarioInterfazDAO {

	private DBFacade db = null;
	public UsuarioDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Usuario get(Producto p) throws Exception {
		Usuario user =null;
		
		try{
			db.abrirConexion();
			String sql =  "select * from usuario where idUsuario = "+p.getIdUsuario();
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			while (rs.next()){
				user = new Usuario(
						rs.getInt("idUsuario"),
						rs.getString("correo"),
						rs.getString("estado"),
						rs.getString("nick"),
						rs.getString("contrasenya"),
						rs.getString("apellido"),
						rs.getString("nombre"),
						rs.getDate("fecha"),
						rs.getString("imagen")
						);
				
			}
			sql ="select sum(valoracion) as valoracion from compra where idProducto in"
					+"(select idProducto from producto where idUsuario = "+p.getIdUsuario()+");";
			 rs = db.ejecutarConsulta(sql);
			 while (rs.next()){
					user.setValoracion(rs.getInt("valoracion"));
			  }
		}catch (Exception e){
			System.out.println("Error al obtener usuario: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return user;
	}
	@Override
	public Usuario get(int idUsuario) throws Exception {
		Usuario user =null;
		
		try{
			db.abrirConexion();
			String sql =  "select * from usuario where idUsuario = "+idUsuario;
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			while (rs.next()){
				user = new Usuario(
						rs.getInt("idUsuario"),
						rs.getString("correo"),
						rs.getString("estado"),
						rs.getString("nick"),
						rs.getString("contrasenya"),
						rs.getString("apellido"),
						rs.getString("nombre"),
						rs.getDate("fecha"),
						rs.getString("imagen")
						);
				
			}
			sql ="select sum(valoracion) as valoracion from compra where idProducto in"
					+"(select idProducto from producto where idUsuario = "+idUsuario+");";
			 rs = db.ejecutarConsulta(sql);
			 while (rs.next()){
					user.setValoracion(rs.getInt("valoracion"));
			  }
		}catch (Exception e){
			System.out.println("Error al obtener usuario: "+e.getMessage());
			
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return user;
	}
	@Override
	public Usuario get(String correo) throws Exception {
		Usuario user =null;
		
		try{
			db.abrirConexion();
			String sql =  "select * from usuario where correo like '"+correo+"';";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			while (rs.next()){
				user = new Usuario(
						rs.getInt("idUsuario"),
						rs.getString("correo"),
						rs.getString("estado"),
						rs.getString("nick"),
						rs.getString("contrasenya"),
						rs.getString("apellido"),
						rs.getString("nombre"),
						rs.getDate("fecha"),
						rs.getString("imagen")
						);
				
			}
			sql ="select sum(valoracion) as valoracion from compra where idProducto in"
					+"(select idProducto from producto where idUsuario = "+user.getIdUsuario()+");";
			 rs = db.ejecutarConsulta(sql);
			 while (rs.next()){
					user.setValoracion(rs.getInt("valoracion"));
			  }
		}catch (Exception e){
			System.out.println("Error al obtener usuario: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
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
                "SET estado = '"+usuario.getEstado()+"'"
					 +", nick = '"+usuario.getNick()+"'"
					  +", correo = '"+usuario.getCorreo()+"'"
					 + ", contrasenya = '"+usuario.getContrasenya()+"'"
					 + ", apellido = '"+usuario.getApellido()+"'"
					 + ", nombre = '"+usuario.getNombre()+"'"
					 + ", fecha = '"+usuario.getFecha()+"'"
					 + ", imagen = '"+usuario.getImagen()+"'"
					 + " WHERE  idUsuario = '"+usuario.getIdUsuario()+"'";                    
           
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

	/**
	 * Borrar usuario, 
	 * 	se ha decidido que si esta en conflicto solamente
	 * 	se actualice el estado de la cuenta a bloqueada.
	 */
	@Override
	public Boolean remove(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "delete from usuario WHERE idUsuario = "+usuario.getIdUsuario()+"";                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar usuario: "+e.getMessage());
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
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(usuario.getFecha());
			
			db.abrirConexion();
			 String queryString = "insert into usuario (correo,estado,nick,contrasenya,apellido,nombre,imagen,fecha) values "
			 		+ "('"+usuario.getCorreo()
			 		+"','"+usuario.getEstado()
			 		+"','"+usuario.getNick()
			 		+"','"+usuario.getContrasenya()
			 		+"','"+usuario.getApellido()
			 		+"','"+usuario.getNombre()
			 		+"','"+usuario.getImagen()
			 		+"','"+da+"')";                    
          int idUsuario = db.ejecutarUpdate(queryString);
          usuario.setIdUsuario(idUsuario);
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

}
