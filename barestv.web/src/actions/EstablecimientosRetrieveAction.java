package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;






import configuracion.C;
import factoria.FactoriaDAO;

import java.util.ArrayList;
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



	ArrayList<Establecimiento> establecimientos;
	String filtro; // con filtro activado se mira el nickbar, nombre o direccion para proporcionar la lista
	private static final long serialVersionUID = 7067934472341215569L;
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		ArrayList<Establecimiento> e
			= FactoriaDAO.getEstablecimientoDAO(C.baseDatos).getAll();
		establecimientos= new ArrayList<Establecimiento>();
		if(filtro != null){
			for (Establecimiento esta : e) {
				if(esta.isActivado() && (esta.getNombre().contains(filtro) || esta.getNickbar().contains(filtro) || esta.getDireccion().contains(filtro))){
					
					establecimientos.add(esta);
				}
			}
		}else{
			for (Establecimiento esta : e) {
				if(esta.isActivado()){
					
					establecimientos.add(esta);
				}
			}
		}
		
		
		return "success";
	}
	
	public String soloSinAlta() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		
		ArrayList<Establecimiento> e
			= FactoriaDAO.getEstablecimientoDAO(C.baseDatos).getAll();
		establecimientos= new ArrayList<Establecimiento>();
		for (Establecimiento esta : e) {
			if(!esta.isActivado()){
				establecimientos.add(esta);
			}
		}
		
		return "success";
	}
	/**
	 * @return the establecimientos
	 */
	public ArrayList<Establecimiento> getEstablecimientos() {
		return establecimientos;
	}


	/**
	 * @param establecimientos the establecimientos to set
	 */
	public void setEstablecimientos(ArrayList<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}
	

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}