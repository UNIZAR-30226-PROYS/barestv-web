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
		fe = String.format("%02d/%02d/%04d", (fecha/1000000), ((fecha/10000)%100), (fecha%10000));
		ho = String.format("%02d:%02d", hora/100, hora%100);

	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
		fe = String.format("%02d/%02d/%04d", (fecha/1000000), ((fecha/10000)%100), (fecha%10000));
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
		ho = String.format("%02d:%02d", hora/100, hora%100);
	}
	
	public String getFe() {
		return fe;
	}

	public String getHo() {
		return ho;
	}
        
        public String toMySQL() {
                int anyo = (fecha%10000);
		int mes = ((fecha/10000)%100);
		int dia =(fecha/1000000);
		int minutos = (hora%100);
		int horas = (hora/100);
                return String.format("%04d-%02d-%02d %02d:%02d:00", 
                                    anyo, mes, dia, horas, minutos);
        }
	
}
