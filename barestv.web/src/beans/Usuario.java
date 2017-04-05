package beans;

public class Usuario { 
	private String usuario;	
	private String password;
	private String establecimiento;
	private boolean esAdmin;
	
	public Usuario (){
		usuario = "";
		password ="";
		establecimiento ="";
		esAdmin = false;
	}
	
	/**
	 * Crea un Usuario tipo normal
	 * @param usuario
	 * @param password
	 * @param establecimiento
	 */
	public Usuario(String usuario, String password, String establecimiento) {
		this.usuario = usuario;
		this.password = password;
		this.establecimiento = establecimiento;
		esAdmin = false;
	}
	/**
	 * Crea un Usuario tipo admin
	 * @param usuario
	 * @param password
	 */
	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		esAdmin = true;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	
}
