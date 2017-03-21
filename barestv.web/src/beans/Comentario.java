package beans;


import java.util.Date;




public class Comentario {
    
	private int idProducto ;
	private Date fecha;
	private String comentario;		//maximo 255
	private int idUsuario;
	
	
	//Extras
	private Usuario creador;
	
	public Comentario(){
		
	}

	public Comentario(int idProducto, Date fecha, String comentario,
			int idUsuario) {
		this.idProducto = idProducto;
		this.fecha = fecha;
		this.comentario = comentario;
		this.idUsuario = idUsuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}


	
	
    
	
}
