package implementacionMysql;


import java.sql.ResultSet;
import java.util.ArrayList;
















import java.util.Collections;
import java.util.Comparator;

import beans.Comentario;
import beans.Compra;
import beans.Etiqueta;
import beans.Imagen;
import beans.Producto;
import beans.Usuario;
import dao.ProductoInterfazDAO;
import db.DBFacade;
import factoria.FactoriaDAO;

public class ProductoDAOMysql implements ProductoInterfazDAO {

	private DBFacade db = null;
	public ProductoDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Producto> getAll() throws Exception {
		ArrayList<Producto> todos = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from producto";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todos = new ArrayList<Producto>();
			while (rs.next()){
				Producto p= new Producto(
						rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("descripcionCorta"),
						rs.getString("descripcionLarga"),rs.getDouble("precio"),rs.getTimestamp("fechaPublicacion"),rs.getInt("idUsuario")
						);
				String consulta = "select count(*)as cuenta from compra where idProducto = "+p.getIdProducto();
				ResultSet result = db.ejecutarConsulta(consulta);
				result.next();
				p.setVentas(result.getInt("cuenta"));
				p.setCreador(new UsuarioDAOMysql().get(p));
				p.setValoracion(0);
				p.setImagenes(new ImagenDAOMysql().get(p));
				p.setComentarios(new ComentarioDAOMysql().get(p));
				p.setEtiquetas(new EtiquetaDAOMysql().get(p));
				int valoracion = 0;
				ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(p);
				for (int i = 0; i < c.size(); i++) {
					valoracion += c.get(i).getValoracion();
				}
				p.setValoracion(valoracion);
				todos.add(p);
			}
			Collections.sort(todos,new Comparator<Producto>()
					  { public int compare (Producto o1, Producto o2){
						  if (o1.getValoracion() == o2.getValoracion())
		                    {
		                        return 0;
		                    }
		                    else if (o1.getValoracion() < o2.getValoracion())
		                    {
		                        return 1;
		                    }
		                    return -1;
			}});
		}catch (Exception e){
			System.out.println("Error al obtener productos: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return todos;	
	}
	@Override
	public ArrayList<Producto> getCreateBy(Usuario usuario) throws Exception {
		ArrayList<Producto> todos = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from producto where idUsuario = "+usuario.getIdUsuario();
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todos = new ArrayList<Producto>();
			while (rs.next()){
				Producto p= new Producto(
						rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("descripcionCorta"),
						rs.getString("descripcionLarga"),rs.getDouble("precio"),rs.getTimestamp("fechaPublicacion"),rs.getInt("idUsuario")
						);
				String consulta = "select count(*) as cuenta from compra where idProducto = "+p.getIdProducto();
				ResultSet result = db.ejecutarConsulta(consulta);
				result.next();
				p.setVentas(result.getInt("cuenta"));
				p.setCreador(new UsuarioDAOMysql().get(p));
				p.setValoracion(0);
				p.setImagenes(new ImagenDAOMysql().get(p));
				p.setComentarios(new ComentarioDAOMysql().get(p));
				p.setEtiquetas(new EtiquetaDAOMysql().get(p));
				int valoracion = 0;
				ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(p);
				for (int i = 0; i < c.size(); i++) {
					valoracion += c.get(i).getValoracion();
				}
				p.setValoracion(valoracion);
				todos.add(p);
			}
		}catch (Exception e){
			System.out.println("Error al obtener productos: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return todos;	
	}
	@Override
	public ArrayList<Producto> getBuyBy(Usuario usuario) throws Exception {
		ArrayList<Producto> todos = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from producto where idProducto in ( select idProducto from compra where idUsuario  = "+usuario.getIdUsuario()+" ) ";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			todos = new ArrayList<Producto>();
			while (rs.next()){
				Producto p= new Producto(
						rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("descripcionCorta"),
						rs.getString("descripcionLarga"),rs.getDouble("precio"),rs.getTimestamp("fechaPublicacion"),rs.getInt("idUsuario")
						);
				String consulta = "select count(*) as cuenta from compra where idProducto = "+p.getIdProducto();
				ResultSet result = db.ejecutarConsulta(consulta);
				result.next();
				p.setVentas(result.getInt("cuenta"));
				p.setCreador(new UsuarioDAOMysql().get(p));
				p.setValoracion(0);
				p.setImagenes(new ImagenDAOMysql().get(p));
				p.setComentarios(new ComentarioDAOMysql().get(p));
				p.setEtiquetas(new EtiquetaDAOMysql().get(p));
				int valoracion = 0;
				ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(p);
				for (int i = 0; i < c.size(); i++) {
					valoracion += c.get(i).getValoracion();
				}
				p.setValoracion(valoracion);
				todos.add(p);
			}
		}catch (Exception e){
			System.out.println("Error al obtener productos: "+e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return todos;	
	}
	@Override
	public Producto get(int idProducto) throws Exception {
		Producto p = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from producto where idProducto  = "+idProducto;
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			
			while (rs.next()){
				 p= new Producto(
						rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("descripcionCorta"),
						rs.getString("descripcionLarga"),rs.getDouble("precio"),rs.getTimestamp("fechaPublicacion"),rs.getInt("idUsuario")
						);
				String consulta = "select count(*) as cuenta from compra where idProducto = "+idProducto;
				ResultSet result = db.ejecutarConsulta(consulta);
				result.next();
				p.setVentas(result.getInt("cuenta"));
				p.setCreador(new UsuarioDAOMysql().get(p));
				p.setValoracion(0);
				p.setImagenes(new ImagenDAOMysql().get(p));
				p.setComentarios(new ComentarioDAOMysql().get(p));
				p.setEtiquetas(new EtiquetaDAOMysql().get(p));
				int valoracion = 0;
				ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(p);
				for (int i = 0; i < c.size(); i++) {
					valoracion += c.get(i).getValoracion();
				}
				p.setValoracion(valoracion);
				
			}
		}catch (Exception e){
			System.out.println("Error al obtener compras: "+e.getMessage());
		}
		finally {
			try{
				
				db.cerrarConexion();
			}catch (Exception e1){
				System.out.println("Error cerrando la conexión");
			}
		}
		return p;	
	}
	@Override
	public Boolean edit(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fechaMysql = sdf.format(producto.getFechaPublicacion());
			db.abrirConexion();
			 String queryString = "UPDATE producto " +
				
                "SET nombre = '"+producto.getNombre()+"'"
                +",descripcionCorta = '"+producto.getDescripcionCorta()+"'"
                +",descripcionLarga = '"+producto.getDescripcionLarga()+"'"
                +",precio = "+producto.getPrecio()+""
                +",fechaPublicacion = '"+fechaMysql+"'"
					 + " WHERE  idProducto =  "+producto.getIdProducto();                    
            
            db.ejecutarUpdate(queryString);
            //Borrar imagenes y crear nuevas...
            
           String q2= "delete from imagen WHERE idProducto = "+producto.getIdProducto();
           db.ejecutarUpdate(q2);
           ArrayList<Imagen> amf = producto.getImagenes();
           for (int i=0;i<amf.size();i++){
        	   FactoriaDAO.getImagenDAO("MySql").add(amf.get(i));
           }
            
		}catch (Exception e){
			System.out.println("Error al modificar producto: "+e.getMessage());
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
	public Boolean remove(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
	
			db.abrirConexion();
			 String queryString = "delete from producto WHERE idProducto = "+producto.getIdProducto()+" ";
			 		                    
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar producto: "+e.getMessage());
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
	public Boolean add(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(producto.getFechaPublicacion());
			
			db.abrirConexion();
			 String queryString = "insert into producto (nombre,descripcionCorta,descripcionLarga,precio,fechaPublicacion,idUsuario) values "
			 		+ "('"+producto.getNombre()
			 		+"','"+producto.getDescripcionCorta()
			 		+"','"+producto.getDescripcionLarga()
			 		+"',"+producto.getPrecio()
			 		+",'"+da
			 		+"',"+producto.getIdUsuario()
			 		+")";   
			int num= db.ejecutarUpdate(queryString);
           producto.setIdProducto(num);
		}catch (Exception e){
			System.out.println("Error al insertar producto: "+e.getMessage());
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
	
	//Extras
	@Override
	public Boolean addEtiquetaTo(Producto producto, Etiqueta etq)
			throws Exception {
		
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			
			db.abrirConexion();
			String sql =  "select * from productoEtiqueta where idProducto = " + producto.getIdProducto()
					+ " AND idEtiqueta = " + etq.getIdEtiqueta();
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			if (!rs.next()){
				 String queryString = "insert into productoEtiqueta (idProducto,idEtiqueta) values "
				 		+ "("+producto.getIdProducto()
				 		+","+etq.getIdEtiqueta()
				 		+")";                    
	           db.ejecutarUpdate(queryString);
			} 
			
			
		}catch (Exception e){
			System.out.println("Error al insertar producto: "+e.getMessage());
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
	public Boolean removeEtiquetaTo(Producto producto, Etiqueta etq)
			throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			db.abrirConexion();
			 String queryString = "delete from productoetiqueta WHERE idEtiqueta = "+etq.getIdEtiqueta()+" and idProducto = "+producto.getIdProducto();
			 		                  
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al eliminar productoetiqueta: "+e.getMessage());
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
