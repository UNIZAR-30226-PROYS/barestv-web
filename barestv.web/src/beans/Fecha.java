package beans;

public class Fecha {
	private int fecha;
	private int hora;
	private String fe;
	private String ho;
	
	public Fecha(){
		fecha = 0;
		hora = 0;
	}
	public Fecha(int fecha, int hora) {
		this.fecha = fecha;
		this.hora = hora;
		
		
		String anyo = ""+(fecha%10000);
		String mes = ""+((fecha/10000)%100);
		String dia =""+(fecha/1000000);
		fe = ""+dia+"/"+mes+"/"+anyo;
		String minutos = ""+(hora%100);
		String horas = ""+(hora/100);
		ho = ""+horas+":"+minutos;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
		String anyo = ""+(fecha%10000);
		String mes = ""+((fecha/10000)%100);
		String dia =""+(fecha/1000000);
		fe = ""+dia+"/"+mes+"/"+anyo;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
		String minutos = ""+(hora%100);
		String horas = ""+(hora/100);
		ho = ""+horas+":"+minutos;
	}
	
	public String getFe() {
		return fe;
	}

	public String getHo() {
		return ho;
	}

	
}
