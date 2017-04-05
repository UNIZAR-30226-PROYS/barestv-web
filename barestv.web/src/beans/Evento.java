package beans;

public class Evento {
    
	private String nombre;	
	private String descripcion;
	
	/* Fecha */
	private Fecha inicio;
	private Fecha fin;
	
	private String categoria;
	
	public Evento(){
		nombre = "";
		descripcion ="";
		inicio = new Fecha();
		fin = new Fecha();
		categoria = "";
	}
	
	public Evento(String nombre, String descripcion, Fecha inicio, Fecha fin,
			String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Fecha getInicio() {
		return inicio;
	}

	public void setInicio(Fecha inicio) {
		this.inicio = inicio;
	}

	public Fecha getFin() {
		return fin;
	}

	public void setFin(Fecha fin) {
		this.fin = fin;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
	
	
	
}
