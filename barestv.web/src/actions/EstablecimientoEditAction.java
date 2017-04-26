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
public class EstablecimientoEditAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private Establecimiento est;

	private Map<String, Object> session;
	
	public void validate() {
		Boolean hayErrores = false;
		if(est.getNombre().equals("")){
			addFieldError("est.nombre", getText("errors.vacio"));
			hayErrores = true;
		}
		if (hayErrores){
			addActionError("Revise el que nombre no este vacio.");
		}
	}
	
	public String execute() throws Exception {
		
		try{
			est.setActivado(true); //
			
			if (FactoriaDAO.getEstablecimientoDAO(C.baseDatos).edit(est)){
				addActionMessage("Establecimiento modificado con exito.");
				return "success";
			}else{
				if(FactoriaDAO.getEstablecimientoDAO(C.baseDatos).add(est)){
					addActionMessage("Establecimiento modificado con exito.");
					return "success";
				}else{
					addActionError("No se ha podido modificar, intentelo mas tarde. O contacte con un admin.");
					return "fail";
				}
			}
		}catch(Exception e){
			addActionError(e.getMessage());
			return "error";
		}
	}
	

		


	/**
	 * @return the est
	 */
	public Establecimiento getEst() {
		return est;
	}

	/**
	 * @param est the est to set
	 */
	public void setEst(Establecimiento est) {
		this.est = est;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}