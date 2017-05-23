package actions;


import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se cierra la sesion
 * @author alumno
 *
 */
public class SessionCloseAction extends ActionSupport implements SessionAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7652208226990345411L;
	private Map<String, Object> session;

	public String execute() throws Exception {
		addActionMessage("Deslogeado con éxito");
		session.clear();
		return "success";
		
	}
	

	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}