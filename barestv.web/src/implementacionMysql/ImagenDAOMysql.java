package implementacionMysql;

import java.sql.ResultSet;
import java.util.ArrayList;
















import beans.Etiqueta;
import beans.Imagen;
import beans.Producto;
import dao.ImagenInterfazDAO;
import db.DBFacade;

public class ImagenDAOMysql implements ImagenInterfazDAO {

	private DBFacade db = null;
	public ImagenDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Imagen> get(Producto p) throws Exception {
		ArrayList<Imagen> todas = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from imagen where idProducto = "+p.getIdProducto()+"";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todas = new ArrayList<Imagen>();
			while (rs.next()){
				Imagen e= new Imagen(
					rs.getInt("idImagen"),rs.getString("url"),rs.getInt("idProducto")
						);
				todas.add(e);
			}
		}catch (Exception e){
			System.out.println("Error al obtener imagenes: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return todas;	
	}
	@Override
	public Imagen get(int idImagen) throws Exception {
		Imagen img = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from imagen where idImagen = "+idImagen+"";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			
			while (rs.next()){
				img= new Imagen(
					rs.getInt("idImagen"),rs.getString("url"),rs.getInt("idProducto")
						);
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener imagenes: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return img;	
	}
	@Override
	public Boolean edit(Imagen imagen) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{

			db.abrirConexion();
			 String queryString = "UPDATE imagen " +
                "SET url = '"+imagen.getUrl()+"'"
					 + " WHERE  idImagen = "+imagen.getIdImagen();                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar imagen: "+e.getMessage());
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
	public Boolean remove(Imagen imagen) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "delete from imagen WHERE idImagen = "+imagen.getIdImagen()+" ";
			 		               
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar imagen: "+e.getMessage());
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
	public Boolean add(Imagen imagen) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "insert into imagen (url,idProducto) values "
			 		+ "('"+imagen.getUrl()
			 		+"',"+imagen.getIdProducto()
			 		+")";                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al insertar imagen: "+e.getMessage());
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
