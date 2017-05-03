package implementacionPrueba;

import implementacionMysql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import implementacionPrueba.*;
import beans.*;
import dao.*;
import db.DBFacade;

public class CategoriaDAOPrueba implements CategoriaInterfazDAO {

	@Override
	public Categoria get(String nombreCat) throws Exception {
		return new Categoria("Categoria");
	
	}
        
	@Override
	public ArrayList<Categoria> getAll() throws Exception {
                ArrayList<Categoria> categorias = new ArrayList<Categoria>();
                categorias.add(new Categoria("Cat prueba 1"));                
                categorias.add(new Categoria("Cat prueba 2"));
                return categorias;
        }
	@Override
	public boolean edit(Categoria cat, String nombreCatNuevo) throws Exception {
		// TODO Auto-generated method stub
                return true;
	}

	@Override
	public boolean add(Categoria cat) throws Exception {
                return true;
	}
        
	@Override
	public boolean remove(Categoria cat) throws Exception {
                return true;
	}

	@Override
	public boolean exist(String nombreCat) throws Exception {
                return true;
	}

}
