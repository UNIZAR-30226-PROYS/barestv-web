package actions;

import beans.Historial;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import db.DBFacade;
import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se elimina un producto
 * se obtiene el producto y lo elimina
 * @author alumno
 *
 */
public class DeleteProductAction extends ActionSupport implements SessionAware {

	private Producto producto;
	
	private Map<String, Object> session;

	public String execute() throws Exception {
		try{
			Usuario user = null;
			if (session != null && (user = (Usuario)session.get("usuario"))!= null){
				
				if( FactoriaDAO.getProductoDAO("MySql").remove(producto)){
					//Introducimos evento
					Historial h = new Historial(user.getIdUsuario(),new Date(),"Borrado producto #"+producto.getIdProducto());
					FactoriaDAO.getHistorialDAO("MySql").add(h);
					//actualizar indices
					SolrControl.actualizarIndices();
					return "success";
				} else {
					return "error";
				}
			}else{
				return "error";
			}
			
		}catch(Exception e){
			return "error";
		}
		
	
	}
	
	

	public Map<String, Object> getSession() {
		return session;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}