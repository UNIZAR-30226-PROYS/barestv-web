package implementacionPrueba;


import beans.*;
import dao.*;


public class UsuarioDAOPrueba implements UsuarioInterfazDAO {

	@Override
	public Usuario get(String usuario) throws Exception {
		// TODO Auto-generated method stub
		if (usuario.equals("establecimiento")){
			return new Usuario("usuario","password","establecimiento");

		}else if(usuario.equals("admin")){
			return new Usuario("usuario","password");
		}else{
			return null;
		}
	}



}
