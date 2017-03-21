package actions;

import beans.Comentario;
import beans.Historial;
import beans.Imagen;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se crea un nuevo comentario
 * se comprueba los campos y lo inserta en el BD
 * @author alumno
 *
 */
public class ComentaryCreateAction extends ActionSupport implements SessionAware {

	private String comentario;
	private int idProducto; 

	private Map<String, Object> session;
	
	public String execute() throws Exception {
		Usuario user = (Usuario)session.get("usuario");
		Comentario nuevo = new Comentario();
		nuevo.setComentario(comentario);
		nuevo.setIdProducto(idProducto);
		nuevo.setFecha(new Date());
		nuevo.setIdUsuario(user.getIdUsuario());
		
		if (FactoriaDAO.getComentarioDAO("MySql").add(nuevo)){
			//Introducimos evento
			Historial h = new Historial(user.getIdUsuario(),new Date(),"Comentado producto #"+idProducto);
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