package actions;


import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Clase LoginAction
 * Esta clase es llamada cuando se logea un usuario,
 * comprueba con la base de datos si el usuario esta autentificado
 * y entonces lo autoriza en el sistema mediante una inserción de sus datos en la session
 * @author alumno
 *
 */
public class SessionCreateAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9012354996701561702L;
	//Variables que queremos tener disponibles en la acción.
	// la variable "usuario" se corresponde con el name en las jsp
	private String usuario="";
	private String password="";
	
	private Map<String, Object> session;

	//PAra hacer validaciones sobre el formulario antes de procesarlo
	@Override
	public void validate() {
		Boolean hayErrores = false;
		if(usuario.equals("")){
			addFieldError("usuario", getText("errors.vacio"));
			hayErrores = true;
		}
		if(password.equals("")){
			addFieldError("password", getText("errors.vacio"));
			hayErrores = true;
		}
		
		if (hayErrores){
			addActionError(getText("errors.login"));
		}
	}
	
	//Para procesar lo que se tiene que hacer con el formulario de logeo
	public String execute() throws Exception {
		Usuario u = FactoriaDAO.getUsuarioDAO("prueba").get(usuario);
		
		if (u == null){
			addActionError("Usuario no encontrado");
			return "fail";
		}else {
			session.put("usuario", u);
			
			if (u.isEsAdmin()){
				session.put("admin", true);
				return "admin";
			}else{
				return "noadmin";
			}
			
		}
	}
	
	// Metodos getters y setters para tener disponible en el action 
	// lo que el usuario nos envia , autogenerados 
	
	public Map<String, Object> getSession() {
		return session;
	}



	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}