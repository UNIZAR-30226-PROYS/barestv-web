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
public class DestacadosAction extends ActionSupport implements SessionAware {



	ArrayList<Evento> destacados;
	ArrayList<Evento> nodestacados;
	String filtro = "";
	String titulo ="";
	String bar ="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7067934472341215569L;
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		ArrayList<Evento> e
			= FactoriaDAO.getEventoDAO(C.baseDatos).getAllAll();
		destacados= new ArrayList<Evento>();
		nodestacados = new ArrayList<Evento>();
		for (Evento event : e) {
			if(event.getDestacado()){
				destacados.add(event);
			}else{
				if(!filtro.equals("")){
					//Se ha puesto un filtro con lo que 
					// solo pondran aquellos que el bar o nombre coincida
					if(event.getBar().contains(filtro)
					   || event.getCat().contains(filtro)
					   || event.getDescr().contains(filtro)
					   || event.getTitulo().contains(filtro)){
						nodestacados.add(event);
					}
				}else{
					nodestacados.add(event);
				}
			}
		}
		
		return "success";
	}
	public String destacar() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		if(FactoriaDAO.getEventoDAO(C.baseDatos).destacar(titulo,bar)){
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	public String nodestacar() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		if(FactoriaDAO.getEventoDAO(C.baseDatos).nodestacar(titulo,bar)){
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	// Metodos getters y setters
	

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @return the destacados
	 */
	public ArrayList<Evento> getDestacados() {
		return destacados;
	}
	/**
	 * @param destacados the destacados to set
	 */
	public void setDestacados(ArrayList<Evento> destacados) {
		this.destacados = destacados;
	}
	/**
	 * @return the nodestacados
	 */
	public ArrayList<Evento> getNodestacados() {
		return nodestacados;
	}
	/**
	 * @param nodestacados the nodestacados to set
	 */
	public void setNodestacados(ArrayList<Evento> nodestacados) {
		this.nodestacados = nodestacados;
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
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the bar
	 */
	public String getBar() {
		return bar;
	}
	/**
	 * @param bar the bar to set
	 */
	public void setBar(String bar) {
		this.bar = bar;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}