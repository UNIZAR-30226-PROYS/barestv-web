package beans;

public class Evento {
    
	private String nombre;	
	private String descripcion;
	
	private int dia;
	private int mes;
	private int anyo;
	private int hora;
	private int minuto;
	
	private String categoria;
	
	public Evento(){
		nombre = "";
		descripcion ="";
		dia = 0;
		mes = 0;
		anyo = 0;
		hora = 0;
		minuto = 0;
		categoria = "";
	}
	public Evento(String nombre, String descripcion, int dia, int mes,
			int anyo, int hora, int minuto, String categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.hora = hora;
		this.minuto = minuto;
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

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	} 
	
	
	
}
