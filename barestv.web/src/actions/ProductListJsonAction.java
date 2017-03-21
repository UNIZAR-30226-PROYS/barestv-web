package actions;
import java.net.URLEncoder;
import beans.Compra;
import beans.Etiqueta;
import beans.Producto;
import beans.Usuario;

import com.opensymphony.xwork2.ActionSupport;

import db.DBFacade;
import factoria.FactoriaDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * Esta clase es llamada cuando se muestra la lista de productos
 * se obtiene toda la lista, los filtra segun el buscador
 * y se muestra
 * @author alumno
 *
 */
public class ProductListJsonAction extends ActionSupport implements SessionAware {


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
				String texto;
				JSONObject json;
				try{
					texto = SolrControl.obtenerJson(filtro);
					JSONParser parser = new JSONParser();
					json = (JSONObject) parser.parse(texto);
					JSONObject a = (JSONObject) json.get("response");
					
					ArrayList<JSONObject> docs = (ArrayList<JSONObject>) a.get("docs");
					if (docs!=null) {
						productos= new ArrayList<Producto>();
						for (JSONObject prodc : docs) {
							int id = Integer.parseInt((String)prodc.get("id"));
							productos.add(FactoriaDAO.getProductoDAO("MySql").get(id));
						}
					}
					//FactoriaDAO.getCompraDAO("MySql").get()
				}catch(Exception eix){
					System.out.println("Error contactanto con Solr");
					return "error";
				}
				
				
				
				
				return "success";
			}
			
		}catch(Exception e){
			return "error";
		}
		
	}
	public  String stringToHtmlString(String s){
	       StringBuffer sb = new StringBuffer();
	       int n = s.length();
	       for (int i = 0; i < n; i++) {
	          char c = s.charAt(i);
	          switch (c) {
	             case '<': sb.append("&lt;"); break;
	             case '>': sb.append("&gt;"); break;
	             case '&': sb.append("&amp;"); break;
	             case '"': sb.append("&quot;"); break;
	             default:  sb.append(c); break;
	          }
	       }
	       return sb.toString();
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