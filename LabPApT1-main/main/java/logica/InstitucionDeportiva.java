package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtInstitucionDeportiva;


@Entity
public class InstitucionDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	//links
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActividadDeportiva> actDeportivas = new ArrayList<>();
	//private ArrayList<Profesor> profesores;

	
	
	public InstitucionDeportiva() {
		super();
	}

	public InstitucionDeportiva(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<ActividadDeportiva> getActDeportivas() {
		ArrayList<ActividadDeportiva> a = new ArrayList<ActividadDeportiva>(actDeportivas);
		//return (ArrayList<ActividadDeportiva>)actDeportivas;
		return a;
	}
	
	public DtInstitucionDeportiva getDtInstitucionDeportiva() {
		return new DtInstitucionDeportiva(this.nombre, this.descripcion, this.url);
	}
	
	public void agregarActividadDeportiva(ActividadDeportiva a) {
		actDeportivas.add(a);
	}
}
