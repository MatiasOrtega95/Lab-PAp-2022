package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorClase {
	private static ManejadorClase instancia = null;
	
	private ArrayList<Clase> clases = new ArrayList<Clase>();
	
	private ManejadorClase() {}
	
	public static ManejadorClase getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorClase();
		}
		return instancia;
	}
	
	public void actualizarClases() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Clase u");
		clases = (ArrayList<Clase>) query.getResultList();
		
	}
	
	public boolean existeClase(String nombre) {
		actualizarClases();
		Boolean existe = false; 
		for (Clase cls : clases) {
			if (cls.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public Clase buscarClase(String nombre) {
		actualizarClases();
		Clase clase=null;
		for(Clase c: clases) {
			if (c.getNombre().equals(nombre))
				clase = c;
		}
		return clase;
	}
	
	public boolean existeRegistro(String clase, String socio) {
		actualizarClases();
		if(!existeClase(clase)) {
			return false;
		}
		Clase c = buscarClase(clase);
		ArrayList<Registro> registros = c.getRegistros();
		for(Registro r : registros) {
			if (r.getSocio().getNickname().equals(socio)) {
				return true;
			}
		}
		return false;
	}
	
	public void add(Clase clase) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(clase);
		
		em.getTransaction().commit();
		//clases.add(clase);		
	}
	
	public ArrayList<Clase> getClases(){
		actualizarClases();
		ArrayList<Clase> retorno = new ArrayList<Clase>();
		
		for(Clase c : clases) {
			retorno.add(c);
		}
		return retorno;
	}

}
