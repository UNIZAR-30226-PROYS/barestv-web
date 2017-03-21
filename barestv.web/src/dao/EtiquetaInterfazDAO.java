package dao;


import java.util.ArrayList;

import beans.*;

public interface EtiquetaInterfazDAO {
	//Obtener varios
	public ArrayList<Etiqueta> getAll()throws Exception;
	public ArrayList<Etiqueta> get(Producto p)throws Exception;
	
	//Busqueda
	public ArrayList<Etiqueta> get(String nombre)throws Exception;
	
	//Obtener uno
	public Etiqueta get(int idEtiqueta) throws Exception;
	
	//Edicion y eliminacion
	public Boolean edit(Etiqueta etiqueta) throws Exception;
	public Boolean remove(Etiqueta etiqueta) throws Exception;
	public Boolean add(Etiqueta etiqueta)throws Exception;
}
