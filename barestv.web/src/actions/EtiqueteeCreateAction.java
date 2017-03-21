package actions;

import beans.Etiqueta;
import beans.Historial;
import beans.Imagen;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se crea una nueva etiqueta
 * se crea la etiqueta si no existe y se lo asocia al producto
 * @author alumno
 *
 */
public class EtiqueteeCreateAction extends ActionSupport implements SessionAware {

	private String nombre;
	private int idProducto; 
	

	private Map<String, Object> session;
	
	public String execute() throws Exception {
		Usuario user = (Usuario)session.get("usuario");
		Etiqueta nuevo = new Etiqueta();
		nuevo.setNombre(nombre);
		Producto producto = FactoriaDAO.getProductoDAO("MySql").get(idProducto);
		
		// Se crea la etiqueta si no existe y se lo asigna al producto
		if (FactoriaDAO.getEtiquetaDAO("MySql").add(nuevo)
				&& FactoriaDAO.getProductoDAO("MySql").addEtiquetaTo(producto, nuevo)){
			//Introducimos evento
			Historial h = new Historial(user.getIdUsuario(),new Date(),"Añadido etiqueta a producto #"+idProducto);
			FactoriaDAO.getHistorialDAO("MySql").add(h);
			return "success";
			
		}else{
			return "error";
		}
	}
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}


	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}