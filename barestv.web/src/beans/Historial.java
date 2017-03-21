package beans;

import java.util.Date;

public class Historial {
	 private int idUsuario;
	 private int idEvento;
	 private Date fecha;
	 private String evento;
	 
	 public Historial(){
		 
	 }
	 public Historial(int idUsuario,Date fecha, String evento){
		 this.idUsuario = idUsuario;
		 this.fecha = fecha;
		 this.evento = evento;
	 }
	 public Historial(int idUsuario, int idEvento,Date fecha, String evento){
		 this.idUsuario = idUsuario;
		 this.idEvento = idEvento;
		 this.fecha = fecha;
		 this.evento = evento;
	 }
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	 
	 
}
