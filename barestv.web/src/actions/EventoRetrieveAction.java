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
public class EventoRetrieveAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String bar;
	
	private String nombre;
	private String descripcion;
	private String fechainicial;
	private String fechafinal;
	private String categoria;
	
	private ArrayList<String> categorias;
	
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			if (u.isEsAdmin()) return "error";
			
			//
			categorias = new ArrayList<String>();
			categorias.add("Deporte");
			categorias.add("Musica");
			categorias.add("Cine");
			categorias.add("Series");
			
			Evento x = FactoriaDAO.getEventoDAO(C.baseDatos).get(bar, titulo);
			nombre = titulo;
			descripcion = x.getDescripcion();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
			fechainicial = format.format(x.getInicio());
			fechafinal = format.format(x.getFin());
			categoria = x.getCategoria();
			return "success";
				
		}catch(Exception e){
			return "error";
		}
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




	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}




	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}




	/**
	 * @param categoria the categoria to set
	 */
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