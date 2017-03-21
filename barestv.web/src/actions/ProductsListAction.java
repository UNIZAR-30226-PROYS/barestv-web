package actions;

import beans.Compra;
import beans.Etiqueta;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import db.DBFacade;
import factoria.FactoriaDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando se muestra la lista de productos
 * se obtiene toda la lista, los filtra segun el buscador
 * y se muestra
 * @author alumno
 *
 */
public class ProductsListAction extends ActionSupport implements SessionAware {


	private ArrayList<Producto> productos;

	private String filtro="";

	private Map<String, Object> session;

	public String execute() throws Exception {
		try{
			
			// Buscador
			if (filtro.equals("")) {	
				productos= FactoriaDAO.getProductoDAO("MySql").getAll();
				return "success";
			} else {
				ArrayList<Producto> busqueda= FactoriaDAO.getProductoDAO("MySql").getAll();
				productos = new ArrayList<Producto>();
				for (Producto producto : busqueda) {
					boolean categoria = false;
					for (Etiqueta etiqueta : producto.getEtiquetas()) {
						if (etiqueta.getNombre().equals(filtro)) {
							categoria = true;
							break;
						}
					}

					// Se puede buscar por etiqueta o nombre
					if (categoria || producto.getNombre().contains(filtro)) {
						productos.add(producto);
					}	
				}
				return "success";
			}
			
		}catch(Exception e){
			return "error";
		}
		
	}
	
	
	
	// Metodos para hacer visible el array a la vista
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}




	public String getFiltro() {
		return filtro;
	}



	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}



	/* 
	 * Los dos metodos siguientes son para 
	 *  tener acceso a la sesion del usuario
	 * 
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}