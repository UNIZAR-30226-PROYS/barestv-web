package dao;


import java.util.ArrayList;



import beans.*;

public interface ImagenInterfazDAO {
	//Obtener varios
	//public ArrayList<Imagen> getAll()throws Exception;
	public ArrayList<Imagen> get(Producto p)throws Exception;
	
	//Obtener uno
	public Imagen get(int idImagen) throws Exception;
	
	//Edicion y eliminacion
	public Boolean edit(Imagen imagen) throws Exception;
	public Boolean remove(Imagen imagen) throws Exception;
	public Boolean add(Imagen imagen)throws Exception;
}
