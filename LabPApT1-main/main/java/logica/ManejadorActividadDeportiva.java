package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorActividadDeportiva {
	private static ManejadorActividadDeportiva instancia = null;
	
	private ArrayList<ActividadDeportiva> actDeportivas = new ArrayList<>();
	
	private ManejadorActividadDeportiva() {}
	
	public static ManejadorActividadDeportiva getInstancia() {
		if(instancia == null) {
			instancia = new ManejadorActividadDeportiva();
		}
		return instancia;
	}
	
	public void actualizarActividadesDeportivas() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from ActividadDeportiva u");
		actDeportivas = (ArrayList<ActividadDeportiva>) query.getResultList();
		
		
	}
	
	public boolean existeActividad(String nombre) {
		actualizarActividadesDeportivas();
		Boolean existe = false; 
		for (ActividadDeportiva actDep : actDeportivas) {
			if (actDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public ActividadDeportiva buscarActividadDeportiva(String nombre) {
		actualizarActividadesDeportivas();
		//Conexion conexion = Conexion.getInstancia();
		//EntityManager em = conexion.getEntityManager();
		
		//ActividadDeportiva actDep = em.find(ActividadDeportiva.class, nombre);
		
		
		ActividadDeportiva actDep=null;
		for(ActividadDeportiva a: actDeportivas) {
			if (a.getNombre().equals(nombre))
				actDep = a;
		}
		
		return actDep;
	}
	
	public ActividadDeportiva buscarActividadDeportivaPorClase(Clase clase) {
		actualizarActividadesDeportivas();
		//Conexion conexion = Conexion.getInstancia();
		//EntityManager em = conexion.getEntityManager();
		
		//Query query = em.createQuery("select s from Socio s");
		//ArrayList<ActividadDeportiva> actDeportivas = (ArrayList<ActividadDeportiva>) query.getResultList();
		
		
		
		ActividadDeportiva actDep=null;
		for(ActividadDeportiva a: actDeportivas) {
			ArrayList<Clase> clases = a.getClases();
			for(Clase c : clases) {
				if (c.getNombre().equals(clase.getNombre())) {
					actDep = a;
				}
			}
			
		}
		return actDep;
	}
	
	public void add(ActividadDeportiva actDep) {	
		
		//actDeportivas.add(actDep);	
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(actDep);
		
		em.getTransaction().commit();
	}
	
	public ArrayList<ActividadDeportiva> listarActividadesDeportivas(){
		actualizarActividadesDeportivas();
		return actDeportivas;
	}
}
