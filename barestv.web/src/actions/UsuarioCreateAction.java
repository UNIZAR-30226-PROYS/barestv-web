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
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			boolean esAdmin = (u != null && u.isEsAdmin());
			//Validacion
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
				hayErrores = true;
			}
			if (hayErrores){
				addActionError(getText("errors.login"));
				
				if(esAdmin){
					return "input_admin";
				}else{
					return "input";
				}
			}
			//
			usr.setEsAdmin(false); 
			usr.setEsAlta(true);
			
			if(FactoriaDAO.getUsuarioDAO(C.baseDatos).exist(usr.getUsuario())){
				addFieldError("usr.usuario", " ya existe");
				addActionError("El nombre de usuario no esta disponible.");
				
				if (esAdmin){
					return "fail_admin";
				}else{
					return "fail";
				}
				
			}
			else if(FactoriaDAO.getUsuarioDAO(C.baseDatos).add(usr)){
				Establecimiento e = new Establecimiento(usr.getUsuario(),"Establecimiento de "+usr.getUsuario(),"Descripcion de "+usr.getUsuario(),false, 0, 0,"Direccion de "+usr.getUsuario(),"http://cdn1.buuteeq.com/upload/18551/bar-brandy-2.jpg");
				if (FactoriaDAO.getEstablecimientoDAO(C.baseDatos).add(e)){
					if (esAdmin){
						addActionMessage("Cuenta creada. Activa la cuenta en la lista de espera para finalizar.");
						return "success_admin";
					}else{
						addActionMessage("Cuenta creada, en breves un administrador habilitara la cuenta y podras acceder.");
						return "success";
					}
					
				}else{
					if (esAdmin){
						addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde. O contacte con un admin.");
						
						return "fail_admin";
					}else{
						addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde. O contacte con un admin.");
						return "fail";
					}
					
				}
				
			}else{
				if (esAdmin){
					addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde. O contacte con un admin.");
					
					return "fail_admin";
				}else{
					addActionError("En estos momentos no se puede crear una cuenta, intentelo mas tarde. O contacte con un admin.");
					return "fail";
				}
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