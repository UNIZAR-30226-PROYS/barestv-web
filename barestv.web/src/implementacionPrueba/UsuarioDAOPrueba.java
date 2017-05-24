package implementacionPrueba;


import beans.*;
import dao.*;


public class UsuarioDAOPrueba implements UsuarioInterfazDAO {

	@Override
	public Usuario get(String usuario, String password) throws Exception {
		// TODO Auto-generated method stub
		if (usuario.equals("admin")){
			return new Usuario("admin", "password",  true,true);
		}else{
			return new Usuario("barejemplo", "password",  false,true);
		}
		
	}
	
	@Override
	public Boolean exist(String usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
		
	}
	@Override
	public Boolean edit(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean newPassword(Usuario usuario, String password)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(String nickbar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean activate(String nickbar) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean check(Usuario u, String old) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
