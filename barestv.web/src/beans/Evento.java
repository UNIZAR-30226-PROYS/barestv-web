package beans;

import java.sql.Timestamp;

public class Evento {
    
	private String titulo;	
	private String bar;
	private String descr;
	private Boolean destacado;
	
	/* Fecha */
	private Timestamp inicio;
	private Timestamp fin;
	
	private String cat;

	public Evento(){
		titulo = null;
		bar = null;
		descr = null;
		destacado = null;
		inicio = null;
		fin = null;
	}
	public Evento(String titulo, String bar, String descr, Boolean destacado,
			Timestamp inicio, Timestamp fin, String cat) {
		this.titulo = titulo;
		this.bar = bar;
		this.descr = descr;
		this.destacado = destacado;
		this.inicio = inicio;
		this.fin = fin;
		this.cat = cat;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the bar
	 */
	public String getBar() {
		return bar;
	}

	/**
	 * @param bar the bar to set
	 */
	public void setBar(String bar) {
		this.bar = bar;
	}

	/**
	 * @return the descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * @return the destacado
	 */
	public Boolean getDestacado() {
		return destacado;
	}

	/**
	 * @param destacado the destacado to set
	 */
	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
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

	/**
	 * @return the cat
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(String cat) {
		this.cat = cat;
	}

	
	

}
