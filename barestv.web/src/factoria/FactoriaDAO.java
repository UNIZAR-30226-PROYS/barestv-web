package factoria;


import implementacionPrueba.*;
import dao.*;
import implementacionMysql.EventoDAOMysql;
import implementacionMysql.UsuarioDAOMysql;

public class FactoriaDAO {
	public static EstablecimientoInterfazDAO getEstablecimientoDAO (String basededatos) throws Exception{
		if ("prueba".equals(basededatos)){
			return new EstablecimientoDAOPrueba();
		}else {
			return null;
		}
		
	}
	public static UsuarioInterfazDAO getUsuarioDAO (String basededatos) throws Exception{
		if ("prueba".equals(basededatos)){
			return new UsuarioDAOPrueba();
		}else if ("mysql".equals(basededatos)){
			return new UsuarioDAOMysql();
		}else {
			return null;
		}
		
	}
	
	public static EventoInterfazDAO getEventoDAO (String basededatos) throws Exception{
System.err.println("ENTRA getevtodao");
		if ("prueba".equals(basededatos)){
			return new EventoDAOPrueba();
		}else if ("mysql".equals(basededatos)){
			return new EventoDAOMysql();
		}else {
			return null;
		}
		
	}
	
	public static ProgramacionInterfazDAO getProgramacionDAO (String basededatos) throws Exception{
		if ("prueba".equals(basededatos)){
			return new ProgramacionDAOPrueba();
		}else {
			return null;
		}
		
	}
}
