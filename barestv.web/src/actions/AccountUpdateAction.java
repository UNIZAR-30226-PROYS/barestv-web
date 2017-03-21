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
 * Esta clase es llamada cuando se edita los datos de la cuenta
 * se comprueba los datos y lo edita
 * @author alumno
 *
 */
public class AccountUpdateAction extends ActionSupport implements SessionAware {

	private Usuario usr;
	private Map<String, Object> session;
	private String pass1="";
	private String pass2="";
	private String correo="";
	private String imagen="";
	
	@Override
	public void validate() {
		
		//Comprobar que los campos estan rellenos
		if("".equals(pass1)){
            addFieldError("pass1",  getText("errors.vacio"));
           
        }
		
		if("".equals(pass2)){
            addFieldError("contrasenya2",  getText("errors.vacio"));
           
        }
		if(!pass2.equals(pass1)){
			addFieldError("contrasenya2",getText("errors.duplicated"));
			
		}
	
	}
	
	public String execute() throws Exception {
		try{
			Usuario usr = (Usuario) session.get("usuario");
			usr.setContrasenya(pass1);
			usr.setImagen(imagen);
			usr.setCorreo(correo);
			if(FactoriaDAO.getUsuarioDAO("MySql").edit(usr)){
				addActionMessage(getText("exito.actualizar"));
				
				//Introducimos evento
				Historial h = new Historial(usr.getIdUsuario(),new Date(),"Actualizado cuenta usuario");
				FactoriaDAO.getHistorialDAO("MySql").add(h);
			
				return "success";
			}else{
				addActionError(getText("errors.actualizar"));
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

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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