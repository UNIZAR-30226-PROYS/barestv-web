package beans;
import java.util.ArrayList;
import java.util.Date;





public class Producto { 
   
	private int idProducto;
	private String nombre;		//maximo 100 caracteres
	private String descripcionCorta;	//maximo 255
	private String descripcionLarga;	//maximo 255
	private double precio;
	private Date fechaPublicacion;
	private int idUsuario;
	
	//Atributos adicionales 
	private Usuario creador;
	private int valoracion;
	private ArrayList<Imagen> imagenes;
	private ArrayList<Comentario> comentarios;
	private ArrayList<Etiqueta> etiquetas;
	private int ventas;
	
	
	public Producto() {
		
	}
	

	public Producto(int idProducto, String nombre, String descripcionCorta,
			String descripcionLarga, double precio, Date fechaPublicacion,
			int idUsuario) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.precio = precio;
		this.fechaPublicacion = fechaPublicacion;
		this.idUsuario = idUsuario;
	}
	public String getImagen(int index){
		return imagenes.get(index).getUrl();
	}
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public ArrayList<Imagen> getImagenes() {
		return imagenes;
	}
	
	public void setImagenes(ArrayList<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	public ArrayList<Etiqueta> getEtiquetas() {
		return etiquetas;
	}


	public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}


	public int getVentas() {
		return ventas;
	}


	public void setVentas(int ventas) {
		this.ventas = ventas;
	}




	
	
}
