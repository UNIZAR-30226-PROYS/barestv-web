package beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class Usuario {
    
    private int idUsuario;
	private String correo;	//Maximo 100
	private String estado;	//maximo 20
	private String nick;	//maximo 20
	private String contrasenya; //maximo 100
	private String apellido; //maximo 100
	private String nombre;	//maximo 100
	private Date fecha;
	private String imagen;
	
	//EXtras
	private int valoracion;

	public Usuario(){
	   
	}

	public Usuario(int idUsuario, String correo, String estado, String nick,
			String contrasenya, String apellido, String nombre, Date fecha, String imagen) {
		this.idUsuario = idUsuario;
		this.correo = correo;
		this.estado = estado;
		this.nick = nick;
		this.contrasenya = contrasenya;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fecha = fecha;
		this.imagen = imagen;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}
	
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	 

}
