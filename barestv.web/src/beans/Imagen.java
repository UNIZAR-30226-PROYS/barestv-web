package beans;



public class Imagen {
    
	private int idImagen;
	private String url;		//maximo 200
	private int idProducto;
	
	public Imagen(){
		
	}

	public Imagen(int idImagen, String url, int idProducto) {
		this.idImagen = idImagen;
		this.url = url;
		this.idProducto = idProducto;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	
}
