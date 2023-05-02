package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import persistencia.Conexion;

public class ManejadorInstitucionDep {
	private static ManejadorInstitucionDep instancia = null;
	
	private ArrayList<InstitucionDeportiva> instDeportivas = new ArrayList<>();
	
	private ManejadorInstitucionDep() {}
	
	public static ManejadorInstitucionDep getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorInstitucionDep();
		}
		return instancia;
	}
	
	public void actualizarInstitucionDep() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from InstitucionDeportiva u");
		instDeportivas = (ArrayList<InstitucionDeportiva>) query.getResultList();
		
	}

	public boolean existeInstitucion(String nombre) {
		actualizarInstitucionDep();
		Boolean existe = false; 
		for (InstitucionDeportiva instDep : instDeportivas) {
			if (instDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	public InstitucionDeportiva buscarInstitucion(String nombre) {
		actualizarInstitucionDep();
		InstitucionDeportiva institucion=null;
		for(InstitucionDeportiva i: instDeportivas) {
			if (i.getNombre().equals(nombre))
				institucion = i;
		}
		return institucion;
	}

	public void add(InstitucionDeportiva instDep) {
		//instDeportivas.add(instDep);		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(instDep);
		
		em.getTransaction().commit();
	}
	
	public ArrayList<InstitucionDeportiva> listarInstituciones(){
		actualizarInstitucionDep();
		return instDeportivas;
	}

}
