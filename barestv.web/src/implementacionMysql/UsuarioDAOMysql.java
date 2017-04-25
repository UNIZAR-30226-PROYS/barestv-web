package implementacionMysql;

import implementacionPrueba.*;

import java.sql.ResultSet;
import java.util.ArrayList;

import beans.*;
import dao.*;
import db.DBFacade;

public class UsuarioDAOMysql implements UsuarioInterfazDAO {

	private DBFacade db = null;

	@Override
	public Usuario get(String usuario) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<Usuario> usuarios = null;

		try {

			db.abrirConexion();
			String sql = "select * from usuario where nick like \"" + usuario + "\";";
			System.out.println(sql);
			ResultSet rs = db.ejecutarConsulta(sql);
			usuarios = new ArrayList<Usuario>();

			if (rs.next()) {

			}

		} catch (Exception e) {

		} finally {
			try {
				db.cerrarConexion();
			} catch (Exception e1) {
				System.out.println("Error cerrando la conexión");
			}
		}
		return null;

	}

}
