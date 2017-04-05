package factoria;


import implementacionPrueba.*;
import dao.*;

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
		}else {
			return null;
		}
		
	}
	
	public static EventoInterfazDAO getEventoDAO (String basededatos) throws Exception{
		if ("prueba".equals(basededatos)){
			return new EventoDAOPrueba();
		}else {
			return null;
		}
		
	}
}
