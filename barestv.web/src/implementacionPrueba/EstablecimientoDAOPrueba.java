package implementacionPrueba;


import beans.Establecimiento;
import dao.EstablecimientoInterfazDAO;


public class EstablecimientoDAOPrueba implements EstablecimientoInterfazDAO {

	@Override
	public Establecimiento get(String usuario) throws Exception {
		// TODO Auto-generated method stub
		return new Establecimiento("Establecimiento", "Calle pardos", "Descripcion del establecimiento", "https://dummyimage.com/600x400/000/fff");
	}

	
	

}
