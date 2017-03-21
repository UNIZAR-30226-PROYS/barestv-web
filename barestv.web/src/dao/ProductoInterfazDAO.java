package dao;


import java.util.ArrayList;

import beans.*;

public interface ProductoInterfazDAO {
	//Obtener varios
	public ArrayList<Producto> getAll()throws Exception;
	public ArrayList<Producto> getCreateBy(Usuario usuario)throws Exception;
	public ArrayList<Producto> getBuyBy(Usuario usuario)throws Exception;
	
	//Obtener uno
	public Producto get(int idProducto) throws Exception;
	
	//Edicion y eliminacion
	public Boolean edit(Producto producto) throws Exception;
	public Boolean remove(Producto producto) throws Exception;
	public Boolean add(Producto producto)throws Exception;
	
	//Para asociar o quitar una etiqueta existente a un producto 
	public Boolean addEtiquetaTo(Producto producto, Etiqueta etq) throws Exception;
	public Boolean removeEtiquetaTo(Producto producto, Etiqueta etq) throws Exception;
}
