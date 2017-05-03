package actions;



import beans.*;

import com.opensymphony.xwork2.ActionSupport;






import configuracion.C;
import factoria.FactoriaDAO;

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
public class CategoriaAction extends ActionSupport implements SessionAware {


        ArrayList<Categoria> categorias;
        
	String nombreCat ="";
	String nombreCatNuevo = "";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	
	public String execute() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
		if (u == null || !u.isEsAdmin()) return "login";
		
		categorias = FactoriaDAO.getCategoriaDAO(C.baseDatos).getAll();
		
		return "success";
	}
        
	public String add() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
                categorias = FactoriaDAO.getCategoriaDAO(C.baseDatos).getAll();
		if (u == null || !u.isEsAdmin()) return "login";
                
                if(FactoriaDAO.getCategoriaDAO(C.baseDatos).exist(nombreCat)){
                        addFieldError("nombreCat", " ya existe");
                        addActionError("La categor?a ya existe.");
                        return "fail";
                }		
		if(FactoriaDAO.getCategoriaDAO(C.baseDatos).add(new Categoria(nombreCat))){
                        //addActionMessage("Categor?a creada correctamente.");
			return "success";
		}else{
                        addActionError("Hubo un error creando la categor?a.");
			return "fail";
		}
		
	}

	public String edit() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
                categorias = FactoriaDAO.getCategoriaDAO(C.baseDatos).getAll();
		if (u == null || !u.isEsAdmin()) return "login";
                
                if (nombreCatNuevo.equals("")) {
                    //inicializamos
                    return "continue";
                    
                } else {
                    if(!FactoriaDAO.getCategoriaDAO(C.baseDatos).exist(nombreCat)){
                            addActionError("La categor?a no existe.");
                            return "fail";
                    }		
                    if(FactoriaDAO.getCategoriaDAO(C.baseDatos).edit(new Categoria(nombreCat), nombreCatNuevo)){
                            //addActionMessage("Categor?a creada correctamente.");
                            nombreCat = nombreCatNuevo;
                            return "success";
                    }else{
                            addActionError("Hubo un error editando la categor?a.");
                            return "fail";
                    }
                }
		
	}        
	public String remove() throws Exception {
		Usuario u = (Usuario)session.get("usuario");
                categorias = FactoriaDAO.getCategoriaDAO(C.baseDatos).getAll();
		if (u == null || !u.isEsAdmin()) return "login";
                
                if(!FactoriaDAO.getCategoriaDAO(C.baseDatos).exist(nombreCat)){
                        addActionError("La categor?a no existe.");
                        return "fail";
                }		
		if(FactoriaDAO.getCategoriaDAO(C.baseDatos).remove(new Categoria(nombreCat))){
                        //addActionMessage("Categor?a creada correctamente.");
                        addActionMessage("Categoria '" + nombreCat + "' eliminada");
                        nombreCat = nombreCatNuevo;
			return "success";
		}else{
                        addActionError("Hubo un error editando la categor?a.");
			return "fail";
		}
		
	}        
	// Metodos getters y setters
	

	public Map<String, Object> getSession() {
		return session;
	}

        public ArrayList<Categoria> getCategorias() {
            return categorias;
        }

        public void setCategorias(ArrayList<Categoria> categorias) {
            this.categorias = categorias;
        }

        public String getNombreCat() {
            return nombreCat;
        }

        public void setNombreCat(String nombreCat) {
            this.nombreCat = nombreCat;
        }

        public String getNombreCatNuevo() {
            return nombreCatNuevo;
        }

        public void setNombreCatNuevo(String nombreCatNuevo) {
            this.nombreCatNuevo = nombreCatNuevo;
        }


	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}