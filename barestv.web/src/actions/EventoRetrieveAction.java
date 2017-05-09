package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;

import configuracion.C;
import factoria.FactoriaDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class EventoRetrieveAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String bar;
	
	private String nombre;
	private String descripcion;
	private String fechainicial;
	private String fechafinal;
	private String categoria;
	
	private String user;
	private ArrayList<String> categorias;
	
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		user = bar;
		try{
			Usuario u = (Usuario)session.get("usuario");
			if (u == null) return "login";
			
			
			categorias = new ArrayList<String>();
            ArrayList<Categoria> cats = FactoriaDAO.getCategoriaDAO(C.baseDatos).getAll();
            for (Categoria c : cats){
                categorias.add(c.getNombreCat());
            }
			
			Evento x = FactoriaDAO.getEventoDAO(C.baseDatos).get(bar, titulo);
			nombre = titulo;
			descripcion = x.getDescr();
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
			fechainicial = format.format(x.getInicio());
			fechafinal = format.format(x.getFin());
			categoria = x.getCat();
			
			return "success";
				
		}catch(Exception e){
			return "error";
		}
	}
	
	
	

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}




	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
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