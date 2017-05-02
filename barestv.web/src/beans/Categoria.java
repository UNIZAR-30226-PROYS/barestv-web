package beans;

public class Categoria {

    private String nombreCat;

	public Categoria(){
	   
	}
	
	/**
	 * @param nombreCat
	 */
	public Categoria(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	/**
	 * @return the nombreCat
	 */
	public String getNombreCat() {
		return nombreCat;
	}

	/**
	 * @param nombreCat the nombreCat to set
	 */
	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}
	
}
