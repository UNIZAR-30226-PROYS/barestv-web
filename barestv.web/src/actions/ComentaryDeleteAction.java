package actions;

import beans.Comentario;
import beans.Historial;
import beans.Imagen;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se crea una nueva cuenta
 * se extrae todos los comentarios del producto y busca el comentario
 * que desea eliminar y lo elimina
 * @author alumno
 *
 */
public class ComentaryDeleteAction extends ActionSupport implements SessionAware {

	private String comentario;
	private int idProducto; 
	private String fecha;
	
	private Map<String, Object> session;
	
	public String execute() throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date f = df.parse(fecha);
		String fechaAbuscar =new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(f);
		
		Usuario user = (Usuario)session.get("usuario");
		Producto p = new Producto();
		p.setIdProducto(idProducto);

		// Se obtiene todo los comentarios del producto
		ArrayList<Comentario> coms = FactoriaDAO.getComentarioDAO("MySql").get(p);
		Comentario c = null;
		boolean encontrado = false;

		// Se busca el comentario pedido
		for (int i = 0; i < coms.size() && !encontrado; i++) {
			c = coms.get(i);
			Date v = c.getFecha();
			String fechaAbuscar2 =new SimpleDateFormat("dd-MM-yy HH:mm:ss").format(v);
			long a = coms.get(i).getFecha().getTime();
			long b = f.getTime();
			if (fechaAbuscar.equals(fechaAbuscar2)){
				encontrado = true;
			}
		}
		
		// Se elimina
		if (FactoriaDAO.getComentarioDAO("MySql").remove(c)){
			//Introducimos evento
			Historial h = new Historial(user.getIdUsuario(),new Date(),"Eliminado comentario de producto #"+idProducto);
			FactoriaDAO.getHistorialDAO("MySql").add(h);
			return "success";
		}else{
			return "error";
		}
		
		
	}
	
	

	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public int getIdProducto() {
		return idProducto;
	}

	

	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public Map<String, Object> getSession() {
		return session;
	}


	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}