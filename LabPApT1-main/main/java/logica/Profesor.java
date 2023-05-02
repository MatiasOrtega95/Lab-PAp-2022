package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtProfesor;

@Entity
public class Profesor extends Usuario {
	private String descripcion;
	private String biografia;//opcional
	private String sitioWeb;//opcional
	//links
	@ManyToOne
	private InstitucionDeportiva institucion;	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases = new ArrayList<Clase>();

	public Profesor() {
		super();
	}

	public Profesor(String nickname, String nombre, String apellido, String email, String contrasenia, String pfp, DtFecha fecha, String descripcion,
			String biografia, String sitioWeb, InstitucionDeportiva institucion) {
		super(nickname, nombre, apellido, email, contrasenia, pfp, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
	}

	public InstitucionDeportiva getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDeportiva institucion) {
		this.institucion = institucion;
	}

	public Profesor(String nickname, String nombre, String apellido, String email, String contrasenia, String pfp, DtFecha fecha) {
		super(nickname, nombre, apellido, email, contrasenia, pfp, fecha);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	
	public ArrayList<Clase> getClases() {
		ArrayList<Clase> cl = new ArrayList<Clase>(clases);
		return cl;
	}
	
	public void agregarClase(Clase c) {
		clases.add(c);//persistencia?
	}
	
	public DtProfesor getDtProfesor() {
		
		ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
		for(Clase c : clases) {
			dtClases.add(c.getDtClase());
		}
		
		return new DtProfesor(this.getNickname(), this.getNombre(), this.getApellido(), this.getEmail(), this.getContrasenia(), this.getpfp(), this.getDtFechaNac(), this.descripcion,
				this.biografia, this.sitioWeb, this.institucion.getDtInstitucionDeportiva(), dtClases);
	}
	
	public DtProfesor consultaProfesor(Profesor prof) {
		DtProfesor retorno;
		retorno = new DtProfesor(prof.getNickname(), prof.getNombre(), prof.getApellido(), prof.getEmail(), prof.getContrasenia(), prof.getpfp(),
				prof.getDtFechaNac());
		return retorno;
	}

	//@Override
	//public DtUsuario consulta(Usuario uS) {

	//	DtProfesor dtP;
	//	dtP = new DtProfesor(uS.getNickname(), uS.getNombre(), uS.getApellido(), uS.getEmail(),
	//			uS.getDtFechaNac(), this.biografia, this.descripcion, this.sitioWeb,
	//			new DtInstitucionDeportiva(((Profesor) uS).getInstitucion().getNombre(),
	//					((Profesor) uS).getInstitucion().getDescripcion(), ((Profesor) uS).getInstitucion().getUrl()));

	//	return dtP;
	//}
}
