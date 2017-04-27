package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

import configuracion.C;
import factoria.FactoriaDAO;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
	private String fechainicial;
	private String fechafinal;
	private String categoria;
	
	private Map<String, Object> session;
	
	private ArrayList<String> categorias;
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
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try{
			Date s = format.parse(fechainicial);
		}catch(Exception e){
			addFieldError("fechainicial", "Formato: dd/MM/yyyy HH:mm");
			hayErrores = true;
		}
		try{
			Date s = format.parse(fechafinal);
		}catch(Exception e){
			addFieldError("fechafinal", "Formato: dd/MM/yyyy HH:mm");
			hayErrores = true;
		}
		if (hayErrores){
			categorias = new ArrayList<String>();
			categorias.add("Deporte");
			categorias.add("Musica");
			categorias.add("Cine");
			categorias.add("Series");
			addActionError(getText("errors.login"));
		}
	}
	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (u.isEsAdmin()) return "error";	
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date s = format.parse(fechainicial);
			Date s1 = format.parse(fechafinal);
			
			
			Evento e = new Evento(nombre, descripcion, new Timestamp(s.getTime()), new Timestamp(s1.getTime()), categoria);
			try{
				FactoriaDAO.getEventoDAO(C.baseDatos).remove(e.getNombre(), u.getUsuario());
				FactoriaDAO.getEventoDAO(C.baseDatos).add(u.getUsuario(), e);
			}catch(Exception ex){
				
			}
			
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	
	

	
	/**
	 * @return the fechainicial
	 */
	public String getFechainicial() {
		return fechainicial;
	}

	/**
	 * @param fechainicial the fechainicial to set
	 */
	public void setFechainicial(String fechainicial) {
		this.fechainicial = fechainicial;
	}

	/**
	 * @return the fechafinal
	 */
	public String getFechafinal() {
		return fechafinal;
	}

	/**
	 * @param fechafinal the fechafinal to set
	 */
	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}

	/**
	 * @return the categorias
	 */
	public ArrayList<String> getCategorias() {
		return categorias;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
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