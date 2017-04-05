package actions;



import com.opensymphony.xwork2.ActionSupport;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se muestra el producto
 * se obtiene el producto y se examina si el cliente que visita si ha comprado el
 * producto
 * @author alumno
 *
 */
public class EstablecimientosRetrieveAction extends ActionSupport implements SessionAware {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7067934472341215569L;
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		
		return "success";
	}
	
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}