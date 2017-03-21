package actions;

import beans.Comentario;
import beans.Compra;
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
 * Esta clase es llamada cuando se compra un producto
 * se comprueba que el usuario esta logeado
 * @author alumno
 *
 */
public class PurchaseAddAction extends ActionSupport implements SessionAware {

    private int idProducto; 
    
    
    private Map<String, Object> session;
    
    public String execute() throws Exception {
        Usuario user = (Usuario)session.get("usuario");
        if (user == null){
        	return "login";
        }
        Compra c = new Compra();
        c.setFecha(new Date());
        c.setIdProducto(idProducto);
        c.setValoracion(0); 
        c.setIdUsuario(user.getIdUsuario());
        
        if(FactoriaDAO.getCompraDAO("MySql").add(c)){
        	Historial h = new Historial(user.getIdUsuario(),new Date(),"Comprado producto #"+idProducto);
        	FactoriaDAO.getHistorialDAO("MySql").add(h);
            return "success";
        } else{
            return "error";
        }
    }

    public Map<String, Object> getSession() {
        return session;
    }
    

    public int getIdProducto() {
		return idProducto;
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
