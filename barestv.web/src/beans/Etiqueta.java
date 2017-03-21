package beans;
import java.util.ArrayList;
import java.util.List;


public class Etiqueta {
    
	private int idEtiqueta;
	private String nombre;		//maximo 50
	
	public Etiqueta(){
		
	}

	public Etiqueta(int idEtiqueta, String nombre) {
		this.idEtiqueta = idEtiqueta;
		this.nombre = nombre;
	}

	public int getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
