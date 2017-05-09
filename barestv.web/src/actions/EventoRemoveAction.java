package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

import configuracion.C;
import factoria.FactoriaDAO;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se muestra el producto
 * se obtiene el producto y se examina si el cliente que visita si ha comprado el
 * producto
 * @author alumno
 *
 */
public class EventoRemoveAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String bar;
	private String user;
	
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		user = bar;
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";

		
			FactoriaDAO.getEventoDAO(C.baseDatos).remove(titulo,bar);
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the bar
	 */
	public String getBar() {
		return bar;
	}


	/**
	 * @param bar the bar to set
	 */
	public void setBar(String bar) {
		this.bar = bar;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}