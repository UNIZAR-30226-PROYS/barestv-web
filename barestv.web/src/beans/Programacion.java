package beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Programacion {
	
	private HashMap<Fecha,ArrayList<Evento>> programacion;
	private String establacimiento;
	
	public Programacion(HashMap<Fecha, ArrayList<Evento>> programacion,
			String establacimiento) {
		this.programacion = programacion;
		this.establacimiento = establacimiento;
	}

	public HashMap<Fecha, ArrayList<Evento>> getProgramacion() {
		return programacion;
	}

	public void setProgramacion(HashMap<Fecha, ArrayList<Evento>> programacion) {
		this.programacion = programacion;
	}

	public String getEstablacimiento() {
		return establacimiento;
	}

	public void setEstablacimiento(String establacimiento) {
		this.establacimiento = establacimiento;
	}
	
	
}
