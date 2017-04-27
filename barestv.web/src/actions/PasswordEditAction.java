package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

import configuracion.C;
import db.DBFacade;
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
public class PasswordEditAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String old, new1,new2;

	private Map<String, Object> session;
	
	public void validate() {
		Boolean hayErrores = false;
		if(old.equals("")){
			addFieldError("oldPass", getText("errors.vacio"));
			hayErrores = true;
		}
		if(new1.equals("")){
			addFieldError("new1", getText("errors.vacio"));
			hayErrores = true;
		}
		if(new2.equals("")){
			addFieldError("new2", getText("errors.vacio"));
			hayErrores = true;
		}
		if(!new1.equals(new2)){
			addFieldError("new1", getText("errors.duplicated"));
			addFieldError("new2", getText("errors.duplicated"));
			hayErrores = true;
		}
		if (hayErrores){
			addActionError("Por favor revise el formulario.");
		}
	}
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if(!u.getPassword().equals(old)){
				addFieldError("old", " no corresponde.");
				addActionError("Revise el formulario. Si persistente los problemas contacte con un administrador para mas información.");
				return "fail";
			}
			FactoriaDAO.getUsuarioDAO(C.baseDatos).newPassword(u, new1);
			return "success";	
		}catch(Exception e){
			addActionError(e.getMessage());
			return "error";
		}
	}
	

	
	

	/**
	 * @return the old
	 */
	public String getOld() {
		return old;
	}

	/**
	 * @param old the old to set
	 */
	public void setOld(String old) {
		this.old = old;
	}

	/**
	 * @return the new1
	 */
	public String getNew1() {
		return new1;
	}

	/**
	 * @param new1 the new1 to set
	 */
	public void setNew1(String new1) {
		this.new1 = new1;
	}

	/**
	 * @return the new2
	 */
	public String getNew2() {
		return new2;
	}

	/**
	 * @param new2 the new2 to set
	 */
	public void setNew2(String new2) {
		this.new2 = new2;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}