package implementacionMysql;


import implementacionPrueba.*;
import beans.*;
import dao.*;


public class UsuarioDAOMysql implements UsuarioInterfazDAO {

	@Override
	public Usuario get(String usuario) throws Exception {
		// TODO Auto-generated method stub
                
		if (usuario.equals("usuario")){
			return new Usuario("usuario","password","usuario");

		}else if(usuario.equals("admin")){
			return new Usuario("admin","password");
		}else{
			return null;
		}
	}



}
