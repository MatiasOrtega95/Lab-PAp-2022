package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import persistencia.Conexion;

@Entity
public class ActividadDeportiva {
	@Id
	private String nombre;//unico
	private String descripcion;
	private int duracion;
	private Float costo;
	private Calendar fechaReg;
	private String picture;
	//links
	@OneToMany(cascade = CascadeType.ALL)
	private List<Clase> clases = new ArrayList<Clase>();
	
	
	public ActividadDeportiva() {
		super();
	}

	public ActividadDeportiva(String nombre, String descripcion, int duracion, Float costo, DtFecha fechaReg, String picture) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		Calendar cal = new GregorianCalendar(fechaReg.getAnio(),fechaReg.getMes(),fechaReg.getDia());
		this.fechaReg = cal;
		this.picture = picture;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public DtFecha getDtFechaReg() {
		DtFecha dtF = new DtFecha(fechaReg);
		return dtF;
	}

	public void setDtFechaReg(DtFecha fechaReg) {
		//this.fechaReg = fechaReg;
	}

	public ArrayList<Clase> getClases() {
		ArrayList<Clase> cl = new ArrayList<Clase>(clases);
		return cl;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}

	public void agregarClase(Clase c) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		clases.add(c);// se persiste??????
		em.getTransaction().begin();
		em.persist(this);
		em.getTransaction().commit();
		
	}
	
	public DtActividadDeportiva getDtActividadDeportiva() {
		
		ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
		for(Clase c : clases) {
			dtClases.add(c.getDtClase());
		}
		DtFecha dtF = new DtFecha(fechaReg);
		DtActividadDeportiva dt = new DtActividadDeportiva(nombre, descripcion, duracion, costo, dtF, dtClases, picture);
		return dt;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public int getCantClases() {
		return clases.size();
	}
	
	
	
	
}
