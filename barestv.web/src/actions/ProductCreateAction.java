package actions;

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
 * Esta clase es llamada cuando se crea un nuevo producto
 * se comprueba los campos y se lo inserta en el BD
 * @author alumno
 *
 */
public class ProductCreateAction extends ActionSupport implements SessionAware {

	private Producto producto;
	private String imagen1;
	private String imagen2;
	private String imagen3;
	
	private Map<String, Object> session;
	
	@Override
	public void validate() {
		// Se comprueba que todos los campos estan rellenados
		if("".equals(producto.getNombre())){
			addFieldError("producto.nombre", getText("errors.vacio"));
		}
		if("".equals(producto.getPrecio())){
			addFieldError("producto.precio", getText("errors.vacio"));
			
		}
		if("".equals(producto.getDescripcionCorta())){
			addFieldError("producto.descripcionCorta", getText("errors.vacio"));
			
		}
		if("".equals(producto.getDescripcionLarga())){
			addFieldError("producto.descripcionLarga", getText("errors.vacio"));
			
		}

		// Comprueba que no son iguales los imagenes
		boolean[] errIm={false,false,false};
		if(!"".equals(imagen1) && !"".equals(imagen2)){
			if (imagen1.equals(imagen2)){
				errIm[1]=true;
				errIm[0]=true;
			}
		}
		if(!"".equals(imagen1) && !"".equals(imagen3)){
			if (imagen1.equals(imagen3)){
				errIm[2]=true;
				errIm[0]=true;
			}
		}
		if(!"".equals(imagen2) && !"".equals(imagen3)){
			if (imagen2.equals(imagen3)){
				errIm[2]=true;
				errIm[1]=true;
			}
		}
		for (int i =0;i<errIm.length;i++){
			if (errIm[i]){
				addFieldError("imagen"+(i+1), getText("errors.imagen"));
			}
		}
	}
	
	public String execute() throws Exception {
		
		Usuario user = (Usuario)session.get("usuario");
		if (user == null){
			return "login";
		}
		try{
			producto.setIdUsuario(user.getIdUsuario());
			producto.setFechaPublicacion(new Date());
			if(FactoriaDAO.getProductoDAO("MySql").add(producto)){
				if (imagen1 != null && !imagen1.equals("")){
					Imagen img1 = new Imagen();
					img1.setUrl(imagen1);
					img1.setIdProducto(producto.getIdProducto());
					FactoriaDAO.getImagenDAO("MySql").add(img1);
					
				}
				if (imagen2 != null && !imagen2.equals("")){
					Imagen img1 = new Imagen();
					img1.setUrl(imagen2);
					img1.setIdProducto(producto.getIdProducto());
					FactoriaDAO.getImagenDAO("MySql").add(img1);
					
				}
				if (imagen3 != null && !imagen3.equals("")){
					Imagen img1 = new Imagen();
					img1.setUrl(imagen3);
					img1.setIdProducto(producto.getIdProducto());
					FactoriaDAO.getImagenDAO("MySql").add(img1);
					
				}
			}else{
				addActionError(getText("errors.crearproducto"));
				return "fail";
			}
			
		}catch(Exception e){
			addActionError(getText("errors.crearproducto"));
			return "error";
		}
		Historial h = new Historial(user.getIdUsuario(),new Date(),"Creado producto #"+producto.getIdProducto());
		FactoriaDAO.getHistorialDAO("MySql").add(h);
		SolrControl.actualizarIndices();
		return "success";
	}
	
	
	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public String getImagen1() {
		return imagen1;
	}


	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}


	public String getImagen2() {
		return imagen2;
	}


	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}


	public String getImagen3() {
		return imagen3;
	}


	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
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