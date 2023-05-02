package logica;

import interfaces.IControladorInstitucionDep;
import persistencia.Conexion;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import datatypes.DtInstitucionDeportiva;
import excepciones.InstitucionDepRepetidaEx;

public class ControladorInstitucionDep implements IControladorInstitucionDep {
	public ControladorInstitucionDep() {
		super();
	}
	
	@Override
	public void addInstitucionDep(String nombre, String descripcion, String URL) throws InstitucionDepRepetidaEx{
		ManejadorInstitucionDep mid = ManejadorInstitucionDep.getInstancia();
		if (!mid.existeInstitucion(nombre)) {
			InstitucionDeportiva instDep = new InstitucionDeportiva(nombre, descripcion, URL);
			mid.add(instDep);
		}else{
			throw new InstitucionDepRepetidaEx("La institución de nombre: " + nombre + " ya existe.");
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
	public void updateInstDep(DtInstitucionDeportiva dtInstDep) {
		ManejadorInstitucionDep mid = ManejadorInstitucionDep.getInstancia();
		InstitucionDeportiva instDep = mid.buscarInstitucion(dtInstDep.getNombre());
		instDep.setDescripcion(dtInstDep.getDescripcion());
		instDep.setUrl(dtInstDep.getUrl());
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(instDep);
		
		em.getTransaction().commit();
	}

}
