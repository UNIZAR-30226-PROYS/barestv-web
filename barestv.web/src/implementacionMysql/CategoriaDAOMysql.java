package implementacionMysql;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import implementacionPrueba.*;
import beans.*;
import dao.*;
import db.DBFacade;

public class CategoriaDAOMysql implements CategoriaInterfazDAO {

	private DBFacade db = null;

	public CategoriaDAOMysql() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			db = new DBFacade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando DBDacade");
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Categoria get(String nombreCat) throws Exception {
		Categoria cat = null;
		try {
			db.abrirConexion();
			String sql = "select nombrecat from categoria where nombrecat like \"" + nombreCat + "\";";
			ResultSet rs = db.ejecutarConsulta(sql);

			while (rs.next()) {
				cat = new Categoria(rs.getString("nombrecat"));
			}
		} catch (Exception e) {
			System.out.println("Error al obtener categoria: " + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
			}
		}
		return cat;
	}

	@Override
	public Boolean edit(Categoria cat) throws Exception {
		// TODO Auto-generated method stub
		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			String queryString = "UPDATE categoria " + "SET  nombrecat = '" + cat.getNombreCat() + "'"
					+ " WHERE  nombrecat = '" + cat.getNombreCat() + "'";
			db.ejecutarUpdate(queryString);
		} catch (Exception e) {
			System.out.println("Error al modificar categoria: " + e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public Boolean add(Categoria cat) throws Exception {
		Boolean esCorrecto = true;
		try {
			db.abrirConexion();
			String queryString = "insert into categoria (nombrecat) values " + "('" + cat.getNombreCat() + "')";
			db.ejecutarUpdate(queryString);
		} catch (Exception e) {
			System.out.println("Error al modificar categoria: " + e.getMessage());
			esCorrecto = false;
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
				esCorrecto = false;
			}
		}
		return esCorrecto;
	}

	@Override
	public boolean exist(String nombreCat) throws Exception {
		boolean es = false;
		try {
			db.abrirConexion();
			String sql = "select * from categoria where nombrecat like \"" + nombreCat + "\";";
			ResultSet rs = db.ejecutarConsulta(sql);

			while (rs.next()) {
				es = true;
			}
		} catch (Exception e) {
			System.out.println("Error al obtener categoria: " + e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexion");
			}
		}
		return es;
	}

}
