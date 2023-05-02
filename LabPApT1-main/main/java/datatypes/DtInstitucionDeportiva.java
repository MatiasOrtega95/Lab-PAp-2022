package datatypes;

public class DtInstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	
	public DtInstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "\nNombre de institución: " + nombre + "\nDescripción: " + descripcion + "\nURL: " + url;
	}
	
	
}
