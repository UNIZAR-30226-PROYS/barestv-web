package implementacionPrueba;


import beans.Establecimiento;
import dao.EstablecimientoInterfazDAO;


public class EstablecimientoDAOPrueba implements EstablecimientoInterfazDAO {

	@Override
	public Establecimiento get(String usuario) throws Exception {
		// TODO Auto-generated method stub
		return new Establecimiento("nickbar", "nombre", "descrbar", true, 12.002, -0.89,"direccion", "https://dummyimage.com/600x400/000/fff");

	}

	@Override
	public Boolean edit(Establecimiento e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(Establecimiento e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
