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
public class EstablecimientoRetrieveAction extends ActionSupport implements SessionAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Establecimiento est;
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (u.isEsAdmin()) return "error";	
			est = FactoriaDAO.getEstablecimientoDAO(C.baseDatos).get(u.getUsuario());
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	
	
	public Establecimiento getEst() {
		return est;
	}


	public void setEst(Establecimiento est) {
		this.est = est;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}