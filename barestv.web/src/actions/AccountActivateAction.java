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
public class AccountActivateAction extends ActionSupport implements SessionAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private String nickbar;
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (!u.isEsAdmin()) return "login";
			
			boolean correcto = FactoriaDAO.getUsuarioDAO(C.baseDatos).activate(nickbar);

			if (correcto){
				return "success";
			}else{
				return "fail";
			}
			
				
		}catch(Exception e){
			return "error";
		}
	}
	
	
	/**
	 * @return the nickbar
	 */
	public String getNickbar() {
		return nickbar;
	}


	/**
	 * @param nickbar the nickbar to set
	 */
	public void setNickbar(String nickbar) {
		this.nickbar = nickbar;
	}



	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}