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
 * Esta clase es llamada cuando se crea una nueva cuenta
 * comprueba los campos y lo inserta en el BD
 * @author alumno
 *
 */
public class AccountCreateAction extends ActionSupport implements SessionAware {


	private Usuario usr;
	private Map<String, Object> session;
	private String contrasenya2;
	
	@Override
	public void validate() {
		Boolean hayErrores= false;
		//Comprobar que todo esta rellenado
		if("".equals(usr.getNick())){
            addFieldError("usr.nick", getText("errors.vacio"));
            hayErrores= true;
        }
		if("".equals(usr.getNombre())){
            addFieldError("usr.nombre", getText("errors.vacio"));
            hayErrores= true;
        }
		if("".equals(usr.getApellido())){
            addFieldError("usr.apellido", getText("errors.vacio"));
            hayErrores= true;
        }
		if("".equals(usr.getCorreo())){
            addFieldError("usr.correo", getText("errors.vacio"));
            hayErrores= true;
        }
		if("".equals(usr.getContrasenya())){
            addFieldError("usr.contrasenya", getText("errors.vacio"));
            hayErrores= true;
        }
		if("".equals(contrasenya2)){
            addFieldError("contrasenya2", getText("errors.vacio"));
            hayErrores= true;
        }
		if(!contrasenya2.equals(usr.getContrasenya())){
			addFieldError("contrasenya2",getText("errors.duplicated"));
			hayErrores= true;
		}
		
		//mostrar mensaje de que esta mal
		if(hayErrores){
			addActionError(getText("errors.relleno"));
		}
	}
	
	public String execute() throws Exception {
		try{
			usr.setFecha(new Date());
			usr.setEstado("active");
			if(FactoriaDAO.getUsuarioDAO("MySql").add(usr)){
				addActionMessage(getText("exito"));
				
				//Introducimos evento
				Historial h = new Historial(usr.getIdUsuario(),new Date(),"Creado usuario");
				FactoriaDAO.getHistorialDAO("MySql").add(h);
				
				usr = null;
				contrasenya2 = null;
				return "success";
			}else{
				addActionError(getText("errors.crear"));
				return "fail";
			}
			
		}catch(Exception e){
			
			addActionError(e.getMessage());
			return "error";

		}
	}
	





	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public String getContrasenya2() {
		return contrasenya2;
	}

	public void setContrasenya2(String contrasenya2) {
		this.contrasenya2 = contrasenya2;
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