package dao;


import java.util.ArrayList;



import beans.*;

public interface CompraInterfazDAO {
	//Obtener varios
	//public ArrayList<Compra> getAll()throws Exception;
	public ArrayList<Compra> get(Producto producto) throws Exception;
	public ArrayList<Compra> get(Usuario usuario) throws Exception;
	
	//edicion, eliminacion y crear de uno en concreto
	public Boolean edit(Compra compra) throws Exception;
	public Boolean remove(Compra compra) throws Exception;
	public Boolean add(Compra compra)throws Exception;
}
