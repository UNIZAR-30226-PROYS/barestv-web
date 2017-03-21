package actions;

import beans.Historial;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se elimina una cuenta
 * no se elimina todos los datos, solo se cambia a modo "deleted"
 * la eliminacion de los datos se realiza segun el plan de mantenimiento
 * @author alumno
 *
 */
public class AccountDeleteAction extends ActionSupport implements SessionAware {


	private Map<String, Object> session;

	public String execute() throws Exception {
		try{
			Usuario user = (Usuario)session.get("usuario");
			user.setEstado("deleted");
			if(FactoriaDAO.getUsuarioDAO("MySql").edit(user)){
				addActionMessage(getText("exito¡£eliminar"));
				
				//Introducimos evento
				Historial h = new Historial(user.getIdUsuario(),new Date(),"Eliminado cuenta usuario");
				FactoriaDAO.getHistorialDAO("MySql").add(h);
				
				addActionMessage(getText("exito¡£deslogear"));
				session.clear();
				return "success";
			}else{
				addActionError(getText("errors¡£eliminar"));
				return "fail";
			}
			
			
		}catch(Exception e){
			
			return "error";

		}
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