package logica;

import interfaces.IControladorActividadDeportiva;
//import interfaces.Socio;
import persistencia.Conexion;

import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.EntityManager;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtFecha;
import excepciones.ActividadDepRepetidaEx;
import excepciones.NoExisteActividadDepEx;
import excepciones.NoExistenUsuariosEx;
import excepciones.RegistroRepetidoEx;

public class ControladorActividadDeportiva implements IControladorActividadDeportiva{
	public ControladorActividadDeportiva() {
		super();
	}
	
	@Override 
	public Boolean existeInstitucionD(String nombreInst) {
		Boolean exists = false; 
		ManejadorInstitucionDep manejador = ManejadorInstitucionDep.getInstancia();
		exists = manejador.existeInstitucion(nombreInst);
		return exists;
	}
	
	@Override
	public void AltaActividadDeportiva(String nombre, String nombreInst, String descripcion, int duracion, float costo, DtFecha fecha, String picture) throws ActividadDepRepetidaEx{
		Boolean exists = false; 
		ManejadorActividadDeportiva manejador = ManejadorActividadDeportiva.getInstancia();
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		exists = manejador.existeActividad(nombre);
		
		if(existeInstitucionD(nombreInst)){
			if(exists == false) {
				ActividadDeportiva nuevaActividad = new ActividadDeportiva(nombre, descripcion, duracion, costo, fecha, picture);
				InstitucionDeportiva inst = mI.buscarInstitucion(nombreInst);
				inst.agregarActividadDeportiva(nuevaActividad);
				manejador.add(nuevaActividad);
			}
			else {
				throw new ActividadDepRepetidaEx("La actividad de nombre: " + nombre + " ya existe.");
			}
		}
		else {
			throw new ActividadDepRepetidaEx("La institución deportiva " + nombreInst + " no existe.");
		}
	
	}

	@Override
	public ArrayList<String> listarInstituciones() {
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		ArrayList<InstitucionDeportiva> instituciones = mI.listarInstituciones();
		ArrayList<String> institucionesNombre = new ArrayList<String>();
		for(InstitucionDeportiva i : instituciones) {
			institucionesNombre.add(i.getNombre());
		}
		return institucionesNombre;
	}

	@Override
	public ArrayList<String> listarActividadesDeportivas(String institucion) {
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		InstitucionDeportiva institucionDep = mI.buscarInstitucion(institucion);
		ArrayList<ActividadDeportiva> actDep = institucionDep.getActDeportivas();
		ArrayList<String> actDepNombre = new ArrayList<String>();
		for(ActividadDeportiva i : actDep) {
			actDepNombre.add(i.getNombre());
		}
		return actDepNombre;
	}

	@Override
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) throws NoExisteActividadDepEx {
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actividad = mAD.buscarActividadDeportiva(actDep);
		if(actividad == null) {
			throw new NoExisteActividadDepEx("No existe la actividad deportiva");
		}
		DtActividadDeportiva dtActividad = actividad.getDtActividadDeportiva();
		
		return dtActividad;
	}
	
	
	@Override
	public DtActividadDeportiva RegistroDictadoDeClase(String regClas) throws NoExisteActividadDepEx{
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actividad = mAD.buscarActividadDeportiva(regClas);
		if(actividad == null) {
			throw new NoExisteActividadDepEx("No existe la actividad deportiva");
		}
		DtActividadDeportiva dtActividad = actividad.getDtActividadDeportiva();
		
		return dtActividad;
	}
	
	@Override
	public void altaRegistroDictadoDeClase(String socio, String clase) throws RegistroRepetidoEx{
		ManejadorClase mC = ManejadorClase.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mC.existeRegistro(clase, socio)) {
			throw new RegistroRepetidoEx("Ya existe ese registro");
		}
		Clase c = mC.buscarClase(clase);
		Socio s = (Socio)mU.buscarUsuarioPorNickname(socio);
		c.agregarSocioPorRegistro(s);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		
	}
	@Override
	public void eliminarRegistro(String socio, String clase) throws RegistroRepetidoEx{
		ManejadorClase mC = ManejadorClase.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(!mC.existeRegistro(clase, socio)) {
			throw new RegistroRepetidoEx("No existe ese registro, entonces no se puede eliminar");
		}
		Clase c = mC.buscarClase(clase);
		Socio s = (Socio)mU.buscarUsuarioPorNickname(socio);
		
		c.removerRegistro(s);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	@Override
	public ArrayList<String> listarClases(String actividadDeportiva) {
		ManejadorActividadDeportiva mA = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mA.buscarActividadDeportiva(actividadDeportiva);
		ArrayList<Clase> clas = actDep.getClases();
		ArrayList<String> actClasNombre = new ArrayList<String>();
		for(Clase i : clas) {
			actClasNombre.add(i.getNombre());
		}
		return actClasNombre;
	}
	@Override
	public DtClase getDtClase(String clase) {
		ManejadorClase mC = ManejadorClase.getInstancia();
		Clase cl = mC.buscarClase(clase);
		DtClase dt = cl.getDtClase();
		return dt;
	}
	@Override
	public ArrayList<String> getSocios() throws NoExistenUsuariosEx{
		ManejadorUsuario mS = ManejadorUsuario.getInstancia();
		ArrayList<Socio> socios = mS.listarSocio();
		if (socios == null)
				throw new NoExistenUsuariosEx("No existen socios creados");
		ArrayList<String> retorno = new ArrayList<String>();
		for(Socio s :socios) {
			retorno.add(s.getNickname());
		}
		return retorno;
		
	}
	@Override
	public ArrayList<String> getActividadesDeportivas(){
		ManejadorActividadDeportiva mA = ManejadorActividadDeportiva.getInstancia();
		ArrayList<ActividadDeportiva> actDeps = mA.listarActividadesDeportivas();
		ArrayList<String> retorno = new ArrayList<String>();
		for(ActividadDeportiva a :actDeps) {
			retorno.add(a.getNombre());
		}
		return retorno;

	}
	@Override
	public DtActividadDeportiva getDtActividadDeportiva(String actDep) {
		ManejadorActividadDeportiva mA = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva ad = mA.buscarActividadDeportiva(actDep);
		DtActividadDeportiva dtAD = ad.getDtActividadDeportiva();
		return dtAD;
	}
	@Override
	public void modificarActividadDeportiva(DtActividadDeportiva dtA) {
		ManejadorActividadDeportiva mA = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva ad = mA.buscarActividadDeportiva(dtA.getNombre());
		
		ad.setDescripcion(dtA.getDescripcion());
		ad.setCosto(dtA.getCosto());
		ad.setDuracion(dtA.getDuracion());
		ad.setPicture(dtA.getPicture());
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(ad);
		
		em.getTransaction().commit();
	}
	@Override
	public ArrayList<DtActividadDeportiva> rankingActividadesDeportivas(){
		
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ArrayList<ActividadDeportiva>ranking  = mAD.listarActividadesDeportivas();
			
		//Sorting (bubble)
			
		for(int i=0;i<ranking.size();i++) {
			for(int j=0;j<ranking.size()-i-1;j++) {
				if(ranking.get(j).getCantClases()<ranking.get(j+1).getCantClases()) {
					 Collections.swap(ranking, j, j+1);
				}
			}
		}
		ArrayList<DtActividadDeportiva> rankingRet = new ArrayList<DtActividadDeportiva>();
			for(ActividadDeportiva a : ranking) {
				rankingRet.add(a.getDtActividadDeportiva());
			}
				
			
		return rankingRet;
	}
	
}
