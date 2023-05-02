package datatypes;

import java.util.ArrayList;


public class DtProfesor extends DtUsuario{
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private DtInstitucionDeportiva institucion;
	private ArrayList<DtClase> clases = new ArrayList<DtClase>();

	public DtProfesor(String nickname, String nombre, String apellido, String email, String contrasenia, String pfp, DtFecha fecha, String descripcion,
			String biografia, String sitioWeb, DtInstitucionDeportiva institucion, ArrayList<DtClase> clases) {
		super(nickname, nombre, apellido, email, contrasenia, pfp, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.institucion = institucion;
		this.clases = clases;
	}

	public DtProfesor(String nickname, String nombre, String apellido, String email, String contrasenia, String pfp, DtFecha fecha) {
		super(nickname, nombre, apellido, email, contrasenia, pfp, fecha);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}
	
	public DtInstitucionDeportiva getInstitucion() {
		return institucion;
	}
	@Override
	public String toString() {
		
		String datos ="PROFESOR:\nNickname : " + getNickname() + "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEmail: " + getEmail() 
		+ "\nFecha de Nacimiento: " + "\nContraseña: " + getContrasenia() + "\nFoto de perfil: " + getpfp() + fechaNac.toString()
		+ "\nDescripción: " + descripcion + "\nBiografía: " + biografia + "\nSitioWeb: " + sitioWeb
		+ "\nInstitución: " + institucion.getNombre()+ "\nClases que dicta: \n";
		
		String datosClase = "";
		for(DtClase c : clases) {
			datosClase = datosClase + c.getNombre() + " - " + c.getActDep() + "\n";
		}
		
		if(datosClase == "") {
			datosClase = "No dicta clases";
		}
		
		datos = datos + datosClase;
		
		return datos;
	}
	
	public ArrayList<DtClase> getClases(){
		return clases;
	}
	

}
