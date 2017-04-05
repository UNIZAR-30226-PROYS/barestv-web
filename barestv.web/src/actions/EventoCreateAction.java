package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

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
public class EventoCreateAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	private int fechainicio;
	private int horainicio;
	private int fechafin;
	private int horafin;
	private String categoria;
	
	private Map<String, Object> session;
	
	public void validate() {
		Boolean hayErrores = false;
		if(nombre.equals("")){
			addFieldError("nombre", getText("errors.vacio"));
			hayErrores = true;
		}
		if(descripcion.equals("")){
			addFieldError("descripcion", getText("errors.vacio"));
			hayErrores = true;
		}
		if(categoria.equals("")){
			addFieldError("categoria", getText("errors.vacio"));
			hayErrores = true;
		}
	
		if (hayErrores){
			addActionError(getText("errors.login"));
		}
	}
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (u.isEsAdmin()) return "error";	
			
			Evento e = new Evento(nombre, descripcion, new Fecha(fechainicio,horainicio), new Fecha(fechafin,horafin), categoria);
			FactoriaDAO.getEventoDAO("prueba").add(u.getEstablecimiento(), e);
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(int fechainicio) {
		this.fechainicio = fechainicio;
	}

	public int getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}

	public int getFechafin() {
		return fechafin;
	}

	public void setFechafin(int fechafin) {
		this.fechafin = fechafin;
	}

	public int getHorafin() {
		return horafin;
	}

	public void setHorafin(int horafin) {
		this.horafin = horafin;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}