package actions;

import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.io.PrintStream;
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
	
	//Variables que queremos tener disponibles en la acción.
	// la variable "usuario" se corresponde con el name en las jsp
	private Usuario usuario;
	
	private Map<String, Object> session;

	//PAra hacer validaciones sobre el formulario antes de procesarlo
	@Override
	public void validate() {
		Boolean hayErrores = false;
		if(usuario.getCorreo().equals("")){
			addFieldError("usuario.correo", getText("errors.vacio"));
			hayErrores = true;
		}
		if(usuario.getContrasenya().equals("")){
			addFieldError("usuario.contrasenya", getText("errors.vacio"));
			hayErrores = true;
		}
		
		if (hayErrores){
			addActionError(getText("errors.login"));
		}
	}
	
	//Para procesar lo que se tiene que hacer con el formulario de logeo
	public String execute() throws Exception {
		
		try{
			Usuario user = FactoriaDAO.getUsuarioDAO("MySql").get(usuario.getCorreo());
			if ((user != null) && (user.getEstado().equals("active"))){
				if (!user.getContrasenya().equals(usuario.getContrasenya())){
					addActionError(getText("contasenyaInconrrecta"));
					return "fail";
				}else{
					this.session.put("usuario",user);
					addActionMessage(getText("correcto"));
					return "success";
				}
				
			}else{
				addActionError(getText("usuarioNoEncontrado"));
				return "fail";
			}
		}catch(Exception e){
			addActionError(getText("usuarioNoEncontrado"));
			return "fail";
		}
	}
	
	// Metodos getters y setters para tener disponible en el action 
	// lo que el usuario nos envia , autogenerados 
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}