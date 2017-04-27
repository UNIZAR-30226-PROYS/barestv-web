package beans;

import java.sql.Timestamp;
import java.util.Date;

public class Evento {
    
	private String nombre;	
	private String descripcion;
	
	/* Fecha */
	private Timestamp inicio;
	private Timestamp fin;
	
	private String categoria;
	
	public Evento(){
		nombre = "";
		descripcion ="";
		inicio = Timestamp.valueOf("2007-09-23 10:10:10.0");
		fin = Timestamp.valueOf("2007-09-23 10:10:10.0");
		categoria = "";
		System.out.println(inicio.toLocaleString());
	}
	
	


	public Evento(String nombre, String descripcion, Timestamp inicio,
			Timestamp fin, String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.categoria = categoria;
		System.out.println(inicio.toLocaleString());
	}




	
	







	



	/**
	 * @return the inicio
	 */
	public Timestamp getInicio() {
		return inicio;
	}




	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}




	/**
	 * @return the fin
	 */
	public Timestamp getFin() {
		return fin;
	}




	/**
	 * @param fin the fin to set
	 */
	public void setFin(Timestamp fin) {
		this.fin = fin;
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
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
	
	
	
}
