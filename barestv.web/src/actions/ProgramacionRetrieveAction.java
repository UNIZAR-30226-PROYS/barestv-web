package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

import configuracion.C;
import factoria.FactoriaDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se muestra el producto
 * se obtiene el producto y se examina si el cliente que visita si ha comprado el
 * producto
 * @author alumno
 *
 */
public class ProgramacionRetrieveAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private HashMap<String,ArrayList<Evento>> programacion;
	
	private Map<String, Object> session;
	
	private ArrayList<String> categorias;
	
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (u.isEsAdmin()) return "error";	
			
			categorias = new ArrayList<String>();
			categorias.add("Deporte");
			categorias.add("Musica");
			categorias.add("Cine");
			categorias.add("Series");
			ArrayList<Evento> eventos = FactoriaDAO.getEventoDAO(C.baseDatos).getAll(u.getUsuario());
			programacion = new HashMap<String,ArrayList<Evento>>();
			for (Evento evento : eventos) {
				if(!programacion.containsKey(evento.getInicio().getFe())){
					ArrayList<Evento> x = new ArrayList<Evento>();
					x.add(evento);
					programacion.put(evento.getInicio().getFe(),x );
				}else{
					programacion.get(evento.getInicio()).add(evento);
				}
			}
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	


	public ArrayList<String> getCategorias() {
		return categorias;
	}



	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}


	



	/**
	 * @return the programacion
	 */
	public HashMap<String, ArrayList<Evento>> getProgramacion() {
		return programacion;
	}



	/**
	 * @param programacion the programacion to set
	 */
	public void setProgramacion(HashMap<String, ArrayList<Evento>> programacion) {
		this.programacion = programacion;
	}



	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}