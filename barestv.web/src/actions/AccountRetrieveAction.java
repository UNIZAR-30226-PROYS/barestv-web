package actions;


import beans.Historial;
import beans.Usuario;
import beans.Producto;


import com.opensymphony.xwork2.ActionSupport;

import factoria.FactoriaDAO;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/**
 * Esta clase es llamada cuando muestra la pagina de cuenta
 * se obtiene los productos creados y el historial de acciones
 * @author alumno
 *
 */
public class AccountRetrieveAction extends ActionSupport implements SessionAware {
	
	// Lista de productos puestos a la venta
	private ArrayList<Producto> lista;
	
	private String fecha1 = "";
    private String fecha2 = "";
    private ArrayList<Historial> filtrado;
    private Usuario user;
	
	private Map<String, Object> session;

	public String execute() throws Exception {
		
		// Obtener los productos creados.
		user = (Usuario)session.get("usuario");
		lista = FactoriaDAO.getProductoDAO("MySql").getCreateBy(user);
		
		// Obtener el historial en un tiempo dado
		ArrayList<Historial> total = FactoriaDAO.getHistorialDAO("MySql").get(user.getIdUsuario());
        if (!fecha1.equals("")){
        	
        	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
    		Date f1 = df.parse(fecha1);
    		Date f2 = df.parse(fecha2);
    		f2.setHours(23);
    		f2.setMinutes(59);
    		f2.setSeconds(59);
    		filtrado = new ArrayList<Historial>();
	        for (Historial h : total) {
	            if (h.getFecha().after(f1) 
	                                && h.getFecha().before(f2)) {
	                filtrado.add(h);
	            }
	        }
	        
        }else{
        	filtrado = (ArrayList<Historial>) total.clone();
        }

        // Reordena segun fecha
        Collections.sort(filtrado, new Comparator<Historial>() {
        	public int compare(Historial o1, Historial o2) {
                return o2.getFecha().compareTo(o1.getFecha());
            }
        });
		return "success";	
	}
	
	
	public Usuario getUser() {
		return user;
	}





	public void setUser(Usuario user) {
		this.user = user;
	}

	public ArrayList<Producto> getLista() {
		return lista;
	}





	public String getFecha1() {
		return fecha1;
	}


	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}


	public String getFecha2() {
		return fecha2;
	}


	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}




	public void setLista(ArrayList<Producto> lista) {
		this.lista = lista;
	}


	


	public ArrayList<Historial> getFiltrado() {
		return filtrado;
	}


	public void setFiltrado(ArrayList<Historial> filtrado) {
		this.filtrado = filtrado;
	}


	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}