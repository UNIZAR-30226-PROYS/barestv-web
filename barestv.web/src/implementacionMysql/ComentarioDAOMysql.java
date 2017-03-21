package implementacionMysql;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;









import java.util.Calendar;
import java.util.Date;

import beans.Comentario;
import beans.Producto;
import beans.Usuario;
import dao.ComentarioInterfazDAO;
import db.DBFacade;
import factoria.FactoriaDAO;

public class ComentarioDAOMysql implements ComentarioInterfazDAO {

	private DBFacade db = null;
	public ComentarioDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Comentario> get(Producto producto) throws Exception {
		ArrayList<Comentario> comentarios = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from comentario where idProducto  = "+producto.getIdProducto()+";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			comentarios = new ArrayList<Comentario>();
			
			while (rs.next()){
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Comentario c= new Comentario(
						rs.getInt("idProducto"),rs.getTimestamp("fecha"),rs.getString("comentario"),rs.getInt("idUsuario")
						);
			
				Usuario u = FactoriaDAO.getUsuarioDAO("MySql").get(c.getIdUsuario());
				c.setCreador(u);
				comentarios.add(c);
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener comentarios: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return comentarios;	
	}
	@Override
	public ArrayList<Comentario> get(Usuario usuario) throws Exception {
		ArrayList<Comentario> comentarios = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from comentario where idUsuario  = "+usuario.getIdUsuario()+";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			comentarios = new ArrayList<Comentario>();
			while (rs.next()){
				Comentario c= new Comentario(
						rs.getInt("idProducto"),rs.getTimestamp("fecha"),rs.getString("comentario"),rs.getInt("idUsuario")
						);
				Usuario u = FactoriaDAO.getUsuarioDAO("MySql").get(c.getIdUsuario());
				c.setCreador(u);
				comentarios.add(c);
			}
		}catch (Exception e){
			System.out.println("Error al obtener comentarios: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return comentarios;	
	}
	@Override
	public Boolean edit(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fechaMysql = sdf.format(comentario.getFecha());
			db.abrirConexion();
			 String queryString = "UPDATE comentario " +
                "SET comentario = '"+comentario.getComentario()+"'"
					 + " WHERE  idProducto = "+comentario.getIdProducto()+" and fecha = '"+fechaMysql+"'";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar comentario: "+e.getMessage());
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
	public Boolean remove(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fechaMysql = sdf.format(comentario.getFecha());
			db.abrirConexion();
			 String queryString = "delete from comentario WHERE idProducto = "+comentario.getIdProducto()+" "
			 		+ "and fecha = '"+fechaMysql+"'";                    
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
	public Boolean add(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(comentario.getFecha());
			
			db.abrirConexion();
			 String queryString = "insert into comentario (idProducto,fecha,comentario,idUsuario) values "
			 		+ "("+comentario.getIdProducto()
			 		+",'"+da
			 		+"','"+comentario.getComentario()
			 		+"',"+comentario.getIdUsuario()
			 		+")";                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al insertar comentario: "+e.getMessage());
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
