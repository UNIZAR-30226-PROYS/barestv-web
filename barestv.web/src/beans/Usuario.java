package beans;

public class Usuario { 
	private String usuario;  // Nombre del usuario y del nickbar
	private String password;
	private boolean esAdmin;
	private boolean esAlta;
	
	public Usuario (){
		usuario = "";
		password ="";
		esAdmin = false;
		esAlta = false;
	}
	/**
	 * Crea un usuario
	 * @param usuario
	 * @param password
	 * @param esAdmin
	 */
	public Usuario(String usuario, String password,boolean esAdmin,boolean esAlta) {
		this.usuario = usuario;
		this.password = password;
		this.esAdmin = esAdmin;
		this.esAlta = esAlta;
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

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public boolean isEsAlta() {
		return esAlta;
	}
	public void setEsAlta(boolean esAlta) {
		this.esAlta = esAlta;
	}
	
	
}
