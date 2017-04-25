package beans;

public class Usuario {
	private String usuario;
	private String password;
	private boolean esAdmin;

	public Usuario() {
		usuario = "";
		password = "";
		esAdmin = false;
	}

	/**
	 * Crea un Usuario tipo normal
	 * 
	 * @param usuario
	 * @param password
	 */
	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		esAdmin = false;
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

}
