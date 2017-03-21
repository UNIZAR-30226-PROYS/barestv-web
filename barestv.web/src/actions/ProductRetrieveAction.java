package actions;

import beans.Compra;
import beans.Producto;
import beans.Usuario;
import beans.Comentario;

import com.opensymphony.xwork2.ActionSupport;

import db.DBFacade;
import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se muestra el producto
 * se obtiene el producto y se examina si el cliente que visita si ha comprado el
 * producto
 * @author alumno
 *
 */
public class ProductRetrieveAction extends ActionSupport implements SessionAware {


	private Producto producto;
	private int idProducto;
	private boolean esComprador = false;
	
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		
		try{
			producto = FactoriaDAO.getProductoDAO("MySql").get(idProducto);
			Usuario user = (Usuario)session.get("usuario");

			// Si el usuario que visita ha comprado el producto o no
			if (user == null){
				esComprador = false;
			}else{
				ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(user);
				for (Iterator iterator = c.iterator(); iterator.hasNext();) {
					Compra compra = (Compra) iterator.next();
					if (compra.getIdProducto()==idProducto){
						esComprador = true;
						
					}
				}
				
			}
			
			
		}catch(Exception e){
			return "error";
		}
		return "success";
	}
	
	public String addLike() throws Exception{
		Usuario user = (Usuario)session.get("usuario");
		if (user == null){
			addActionError(getText("loginNecesario"));
			return "login";
		}
		try{
			
			ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(user);
			if (c.size()==0){
			
				addActionMessage(getText("noHasCompradoEseProducto"));
				return "error";
			}
			
			for (Iterator iterator = c.iterator(); iterator.hasNext();) {
				Compra compra = (Compra) iterator.next();
				if (compra.getIdProducto()==idProducto){
					compra.setValoracion(1);
					FactoriaDAO.getCompraDAO("MySql").edit(compra);
				}
				
			}
			addActionMessage(getText("valoradoProducto"));
			return "success";
		}catch(Exception e){
			return "error";
		}
		
	}
	public String removeLike() throws Exception{
		Usuario user = (Usuario)session.get("usuario");
		if (user == null){
			addActionError(getText("loginNecesario"));
			return "login";
		}
		try{
			
			ArrayList<Compra> c = FactoriaDAO.getCompraDAO("MySql").get(user);
			if (c.size()==0){
			
				addActionMessage(getText("noHasCompradoEseProducto"));
				return "error";
			}
			
			for (Iterator iterator = c.iterator(); iterator.hasNext();) {
				Compra compra = (Compra) iterator.next();
				if (compra.getIdProducto()==idProducto){
					compra.setValoracion(0);
					FactoriaDAO.getCompraDAO("MySql").edit(compra);
				}
				
			}
			addActionMessage(getText("valoradoProducto"));
			return "success";
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

	public int getIdProducto() {
		return idProducto;
	}



	

	public boolean isEsComprador() {
		return esComprador;
	}

	public void setEsComprador(boolean esComprador) {
		this.esComprador = esComprador;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}