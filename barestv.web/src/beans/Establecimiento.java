package beans;

public class Establecimiento {

    private String nickbar;
	private String nombre;	
	private String descrbar;
	private boolean activado;
	private double lat;
	private double lng;
	private String direccion; 
	private String urlimagen; 
	

	public Establecimiento(){
	   
	}
	
	
	/**
	 * 
	 * @param nickbar
	 * @param nombre
	 * @param descrbar
	 * @param activado
	 * @param lat
	 * @param lng
	 * @param direccion
	 * @param urlimagen
	 */
	public Establecimiento(String nickbar, String nombre, String descrbar,
			boolean activado, double lat, double lng, String direccion,
			String urlimagen) {
		this.nickbar = nickbar;
		this.nombre = nombre;
		this.descrbar = descrbar;
		this.activado = activado;
		this.lat = lat;
		this.lng = lng;
		this.direccion = direccion;
		this.urlimagen = urlimagen;
	}

	/**
	 * @return the nickbar
	 */
	public String getNickbar() {
		return nickbar;
	}

	/**
	 * @param nickbar the nickbar to set
	 */
	public void setNickbar(String nickbar) {
		this.nickbar = nickbar;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descrbar
	 */
	public String getDescrbar() {
		return descrbar;
	}

	/**
	 * @param descrbar the descrbar to set
	 */
	public void setDescrbar(String descrbar) {
		this.descrbar = descrbar;
	}

	/**
	 * @return the activado
	 */
	public boolean isActivado() {
		return activado;
	}

	/**
	 * @param activado the activado to set
	 */
	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the urlimagen
	 */
	public String getUrlimagen() {
		return urlimagen;
	}

	/**
	 * @param urlimagen the urlimagen to set
	 */
	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}
	
	
	
	
}
