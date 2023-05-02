package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;

@Entity
public class Clase {
	@Id
	private String nombre;//unico
	private Calendar fechaInicio;
	private String url;
	private Calendar fechaReg;
	private String picture;
	//links
	//@Transient
	//private Profesor profe;
	private String profesorNickname;
	//private ArrayList<Socio> socios;
	@OneToMany(mappedBy="clase",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<Registro>();
	
	
	
	public Clase() {
		super();
	}

	public Clase(String nombre, DtFechaHora fechaInicio, Profesor profe, String url, DtFecha fechaReg, String picture) {
		super();
		this.nombre = nombre;
		Calendar c = new GregorianCalendar(fechaInicio.getAnio(),fechaInicio.getMes(),fechaInicio.getDia(),fechaInicio.getHora(),fechaInicio.getMin());
		this.fechaInicio = c;
		//this.profe = profe;
		this.profesorNickname = profe.getNickname();
		this.url = url;
		Calendar cal = new GregorianCalendar(fechaReg.getAnio(),fechaReg.getMes(),fechaReg.getDia());
		
		this.fechaReg = cal;
		this.picture = picture;
		profe.agregarClase(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DtFechaHora getDtFechaInicio() {
		DtFechaHora dtF = new DtFechaHora(fechaInicio, fechaInicio.get(Calendar.HOUR), fechaInicio.get(Calendar.MINUTE));
		return dtF;
	}

	public void setDtFechaInicio(DtFechaHora fechaInicio) {
		Calendar c = new GregorianCalendar(fechaInicio.getAnio(), fechaInicio.getMes(), fechaInicio.getDia(), fechaInicio.getHora(), fechaInicio.getMin());
		this.fechaInicio = c;
	}

	public String getProfesorNickname() {
		return profesorNickname;
	}

	public void setProfesorNickname(String profe) {
		this.profesorNickname = profe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DtFecha getDtFechaAlta() {
		DtFecha dtF = new DtFecha(fechaReg);
		return dtF;
	}

	public void setDtFechaAlta(DtFecha fechaReg) {
		Calendar c = new GregorianCalendar(fechaReg.getAnio(), fechaReg.getMes(), fechaReg.getDia());
		this.fechaReg = c;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public ArrayList<Registro> getRegistros(){
		ArrayList<Registro> reg = new ArrayList<Registro>(registros);
		return reg;
	}
	
	public void agregarSocioPorRegistro(Socio s) {
		//registros.add(r);
		Registro r = new Registro(this, s);
		registros.add(r);
		s.agregarRegistro(r);
	}

	public DtClase getDtClase() {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mAD.buscarActividadDeportivaPorClase(this);
		String actDepNombre = actDep.getNombre();
		
		DtFecha dtF = new DtFecha(fechaReg);
		DtFechaHora dtFH = new DtFechaHora(fechaInicio, fechaInicio.get(Calendar.HOUR), fechaInicio.get(Calendar.MINUTE));
		DtClase dt = new DtClase(nombre, dtFH, profesorNickname, url, dtF, actDepNombre, registros.size(), picture);
		return dt;
	}
	public Integer getCantRegistros() {
		return registros.size();
	}
	public void removerRegistro(Socio s) {
		for(Registro r : registros) {
			if(r.getSocio().equals(s)) {
				r.getSocio().removerRegistro(r);
				registros.remove(registros.indexOf(r));
				return;
			}
		}
	}
	
}
