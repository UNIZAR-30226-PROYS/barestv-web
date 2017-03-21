package implementacionMysql;

import java.sql.ResultSet;
import java.util.ArrayList;


















import beans.Comentario;
import beans.Compra;
import beans.Producto;
import beans.Usuario;
import dao.CompraInterfazDAO;
import db.DBFacade;

public class CompraDAOMysql implements CompraInterfazDAO {

	private DBFacade db = null;
	public CompraDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Compra> get(Producto producto) throws Exception {
		ArrayList<Compra> vendidos = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from compra where idProducto  = "+producto.getIdProducto()+";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			vendidos = new ArrayList<Compra>();
			while (rs.next()){
				Compra c= new Compra(
						rs.getInt("idProducto"),rs.getInt("idUsuario"),rs.getInt("valoracion"),rs.getTimestamp("fecha")
						);
				vendidos.add(c);
			}
		}catch (Exception e){
			System.out.println("Error al obtener compras: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return vendidos;	
	}
	@Override
	public ArrayList<Compra> get(Usuario usuario) throws Exception {
		ArrayList<Compra> comprados = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from compra where idUsuario  = "+usuario.getIdUsuario()+";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			comprados = new ArrayList<Compra>();
			while (rs.next()){
				Compra c= new Compra(
						rs.getInt("idProducto"),rs.getInt("idUsuario"),rs.getInt("valoracion"),rs.getTimestamp("fecha")
						);
				comprados.add(c);
			}
		}catch (Exception e){
			System.out.println("Error al obtener compras: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return comprados;	
	}
	@Override
	public Boolean edit(Compra compra) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fechaMysql = sdf.format(compra.getFecha());
			db.abrirConexion();
			 String queryString = "UPDATE compra " +
                "SET valoracion = '"+compra.getValoracion()+"'"
					 + " WHERE  idProducto = "+compra.getIdProducto()+" and fecha = '"+fechaMysql+"' and idUsuario = "+compra.getIdUsuario()+" ";                    
           
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
	public Boolean remove(Compra compra) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fechaMysql = sdf.format(compra.getFecha());
			db.abrirConexion();
			 String queryString = "delete from compra WHERE idProducto = "+compra.getIdProducto()+" "
			 		+ "and fecha = '"+fechaMysql+"' and idUsuario = "+compra.getIdUsuario()+"";                    
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
	public Boolean add(Compra compra) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(compra.getFecha());
			
			db.abrirConexion();
			 String queryString = "insert into compra (idProducto,fecha,valoracion,idUsuario) values "
			 		+ "("+compra.getIdProducto()
			 		+",'"+da
			 		+"','"+compra.getValoracion()
			 		+"',"+compra.getIdUsuario()
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
