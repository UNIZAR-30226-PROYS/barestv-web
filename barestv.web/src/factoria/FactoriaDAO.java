package factoria;

import implementacionMysql.*;
import dao.*;

public class FactoriaDAO {
	public static ComentarioInterfazDAO getComentarioDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new ComentarioDAOMysql();
		}else {
			return null;
		}
		
	}
	public static CompraInterfazDAO getCompraDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new CompraDAOMysql();
		}else {
			return null;
		}
		
	}
	public static EtiquetaInterfazDAO getEtiquetaDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new EtiquetaDAOMysql();
		}else {
			return null;
		}
		
	}
	public static ImagenInterfazDAO getImagenDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new ImagenDAOMysql();
		}else {
			return null;
		}
		
	}
	public static ProductoInterfazDAO getProductoDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new ProductoDAOMysql();
		}else {
			return null;
		}
		
	}
	public static UsuarioInterfazDAO getUsuarioDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new UsuarioDAOMysql();
		}else {
			return null;
		}
		
	}
	public static HistorialInterfazDAO getHistorialDAO (String basededatos) throws Exception{
		if ("MySql".equals(basededatos)){
			return new HistorialDAOMysql();
		}else {
			return null;
		}
		
	}
}
