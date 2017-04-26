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
public class UsuarioCreateAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Usuario usr;
	private String password1;

	private Map<String, Object> session;
	
	public void validate() {
		Boolean hayErrores = false;
		if(usr.getUsuario().equals("")){
			addFieldError("usr.usuario", getText("errors.vacio"));
			hayErrores = true;
		}
		if(usr.getPassword().equals("")){
			addFieldError("usr.password", getText("errors.vacio"));
			hayErrores = true;
		}
		if(password1.equals("")){
			addFieldError("password1", getText("errors.vacio"));
			hayErrores = true;
		}
		if(!password1.equals(usr.getPassword())){
			addFieldError("password1", getText("errors.duplicated"));
			addFieldError("usr.password", getText("errors.duplicated"));
		}
		if (hayErrores){
			addActionError(getText("errors.login"));
		}
	}
	
	public String execute() throws Exception {
		
		try{
			usr.setEsAdmin(false); 
			usr.setEsAlta(true);
			
			if(FactoriaDAO.getUsuarioDAO(C.baseDatos).exist(usr.getUsuario())){
				addFieldError("usr.usuario", " ya existe");
				addActionError("El nombre de usuario no esta disponible.");
				return "fail";
			}
			if(FactoriaDAO.getUsuarioDAO(C.baseDatos).add(usr)){
				Establecimiento e = new Establecimiento(usr.getUsuario(), "","",true, 0, 0,"", "");
				if (FactoriaDAO.getEstablecimientoDAO(C.baseDatos).add(e)){
					addActionMessage("Cuenta creada, en breves un administrador habilitara la cuenta y podras acceder.");
					return "success";
				}else{
					addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde. O contacte con un admin.");
					return "fail";
				}
				
			}else{
				addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde.");
				return "fail";
			}
			
				
		}catch(Exception e){
			addActionError(e.getMessage());
			return "error";
		}
	}
	

	

	/**
	 * @return the usr
	 */
	public Usuario getUsr() {
		return usr;
	}

	/**
	 * @param usr the usr to set
	 */
	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	/**
	 * @return the password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1 the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}