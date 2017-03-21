package beans;



import java.util.Date;





public class Compra {
    
	private int idProducto;
	private int idUsuario;
	private int valoracion;
	private Date fecha;

	
	public Compra(){
		
	}

	public Compra(int idProducto, int idUsuario, int valoracion, Date fecha) {
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.valoracion = valoracion;
		this.fecha = fecha;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	
	
}
