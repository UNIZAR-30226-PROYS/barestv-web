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
 * Esta clase es llamada cuando se elimina una etiqueta
 * deasocia la etiqueta del producto, y si es necesario, borra la etiqueta
 * @author alumno
 *
 */
public class EtiqueteeDeleteAction extends ActionSupport implements SessionAware {

	private int idEtiqueta;
	private int idProducto; 
	

	private Map<String, Object> session;
	
	public String execute() throws Exception {
		Usuario user = (Usuario)session.get("usuario");
		Etiqueta etiqueta = FactoriaDAO.getEtiquetaDAO("MySql").get(idEtiqueta);
		Producto producto = FactoriaDAO.getProductoDAO("MySql").get(idProducto);
		
		if (FactoriaDAO.getProductoDAO("MySql").removeEtiquetaTo(producto, etiqueta)){
			// Se elimina definitivamente la etiqueta si no esta asociado con ningun producto
			// No es necesario si usa el plan de mantenimiento correcto
			FactoriaDAO.getEtiquetaDAO("MySql").remove(etiqueta);
			// Introducimos evento
			Historial h = new Historial(user.getIdUsuario(),new Date(),"Eliminado etiqueta del producto #"+idProducto);
			FactoriaDAO.getHistorialDAO("MySql").add(h);
			return "success";
			
		}else{
			return "error";
		}
	}
	
	


	public int getIdEtiqueta() {
		return idEtiqueta;
	}




	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
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