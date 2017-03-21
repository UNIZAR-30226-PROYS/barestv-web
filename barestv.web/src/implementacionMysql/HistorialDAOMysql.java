package implementacionMysql;


import java.sql.ResultSet;





import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.Comentario;
import beans.Historial;
import beans.Producto;
import beans.Usuario;
import dao.HistorialInterfazDAO;
import dao.UsuarioInterfazDAO;
import db.DBFacade;
import factoria.FactoriaDAO;

public class HistorialDAOMysql implements HistorialInterfazDAO {

	private DBFacade db = null;
	public HistorialDAOMysql() throws Exception {
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public ArrayList<Historial> get(int idUsuario) throws Exception {
		ArrayList<Historial> historia = null;
		
		try{
			
			db.abrirConexion();
			String sql =  "select * from historial where idUsuario  = "+idUsuario+";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			historia = new ArrayList<Historial>();
			
			/*
			 *  private int idUsuario;
				 private int idEvento;
				 private Date fecha;
				 private String evento;
			 * 
			 */
			while (rs.next()){
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Historial hc= new Historial(
						rs.getInt("idUsuario"),rs.getInt("idEvento"),rs.getTimestamp("fecha"),rs.getString("evento")
						);
			
				
				historia.add(hc);
				
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
		return historia;	
	}
	@Override
	public Boolean add(Historial h) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try{
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String da = sdf.format(h.getFecha());
			
			db.abrirConexion();
			 String queryString = "insert into historial (idUsuario,fecha,evento) values "
			 		+ "("+h.getIdUsuario()
			 		+",'"+da
			 		+"','"+h.getEvento()
			 		+"')"; 
			 System.out.println(queryString);
           db.ejecutarUpdate(queryString);
		}catch (Exception e){
			System.out.println("Error al insertar historial: "+e.getMessage());
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
