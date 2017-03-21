package implementacionMysql;

import java.sql.ResultSet;
import java.util.ArrayList;






















import beans.Comentario;
import beans.Etiqueta;
import beans.Producto;
import dao.EtiquetaInterfazDAO;
import db.DBFacade;

public class EtiquetaDAOMysql implements EtiquetaInterfazDAO {

	private DBFacade db = null;
	public EtiquetaDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Etiqueta> getAll() throws Exception {
		ArrayList<Etiqueta> todas = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from etiqueta";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todas = new ArrayList<Etiqueta>();
			while (rs.next()){
				Etiqueta e= new Etiqueta(
					rs.getInt("idEtiqueta"),rs.getString("nombre")
						);
				todas.add(e);
			}
		}catch (Exception e){
			System.out.println("Error al obtener etiquetas: "+e.getMessage());
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
	public ArrayList<Etiqueta> get(Producto p) throws Exception {
		ArrayList<Etiqueta> todas = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from etiqueta where idEtiqueta in (select idEtiqueta from ProductoEtiqueta where idProducto = "+p.getIdProducto()+" ) ";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todas = new ArrayList<Etiqueta>();
			while (rs.next()){
				Etiqueta e= new Etiqueta(
					rs.getInt("idEtiqueta"),rs.getString("nombre")
						);
				todas.add(e);
			}
		}catch (Exception e){
			System.out.println("Error al obtener etiquetas: "+e.getMessage());
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
	public ArrayList<Etiqueta> get(String nombre) throws Exception {
		ArrayList<Etiqueta> todas = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from etiqueta where nombre like '%"+nombre+"%' ";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todas = new ArrayList<Etiqueta>();
			while (rs.next()){
				Etiqueta e= new Etiqueta(
					rs.getInt("idEtiqueta"),rs.getString("nombre")
						);
				todas.add(e);
			}
		}catch (Exception e){
			System.out.println("Error al obtener etiquetas: "+e.getMessage());
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
	public Etiqueta get(int idEtiqueta) throws Exception {
		Etiqueta etq = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from etiqueta where idEtiqueta = "+idEtiqueta+" ";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			
			while (rs.next()){
				etq= new Etiqueta(
					rs.getInt("idEtiqueta"),rs.getString("nombre")
						);
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener etiquetas: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return etq;
	}
	@Override
	public Boolean edit(Etiqueta etiqueta) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "UPDATE etiqueta " +
                "SET nombre = '"+etiqueta.getNombre()+"'"
					 + " WHERE  idEtiqueta = "+etiqueta.getIdEtiqueta()+" ";                    
           
            db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al modificar etiqueta: "+e.getMessage());
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
	public Boolean remove(Etiqueta etiqueta) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			// No es muy necesario
			 String sql = "select * from productoetiqueta WHERE idEtiqueta = "+etiqueta.getIdEtiqueta();
             
			 ResultSet rs = db.ejecutarConsulta(sql);
			 if (!rs.next()){
					
				 String queryString = "delete from etiqueta WHERE idEtiqueta = "+etiqueta.getIdEtiqueta();
                  
		         db.ejecutarUpdate(queryString);
			} 
		}catch (Exception e){
			System.out.println("Error al eliminar etiqueta: "+e.getMessage());
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
	public Boolean add(Etiqueta etiqueta) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			String sql =  "select * from etiqueta where nombre like '"+etiqueta.getNombre()+"' ";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			if (!rs.next()){
				
				 String queryString = "insert into etiqueta (nombre) values "
				 		+ "('"+etiqueta.getNombre()
				 		+"')";                    
				 int num= db.ejecutarUpdate(queryString);
		         etiqueta.setIdEtiqueta(num);
			} else {
				etiqueta.setIdEtiqueta(rs.getInt("idEtiqueta"));
			}
			
		}catch (Exception e){
			System.out.println("Error al insertar etiqueta: "+e.getMessage());
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
