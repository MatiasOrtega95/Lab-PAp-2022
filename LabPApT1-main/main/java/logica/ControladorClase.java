package logica;

import java.util.ArrayList;
import java.util.Collections;

import datatypes.DtClase;
import datatypes.DtFecha;
import datatypes.DtFechaHora;
import excepciones.ClaseRepetidaEx;
import excepciones.NoExistenUsuariosEx;
import interfaces.IControladorClase;

public class ControladorClase implements IControladorClase{
	
	public ControladorClase() {
		super();
	}
	
	public void addClase(String actDep,String nombreClase, DtFechaHora fechaInicio, String nomProf, String URL, DtFecha fechaReg, String picture) throws ClaseRepetidaEx, NoExistenUsuariosEx {
		ManejadorClase mid = ManejadorClase.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorActividadDeportiva mAD = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDeportiva = mAD.buscarActividadDeportiva(actDep);
		Usuario us = mU.buscarUsuarioPorNickname(nomProf);
		if (us==null)
			throw new NoExistenUsuariosEx("el usuario" + nomProf + "no existe");
		if (!mid.existeClase(nombreClase)) {
			//verificar que sea profesor
			Clase clase = new Clase(nombreClase, fechaInicio, (Profesor)us, URL, fechaReg, picture);
			mid.add(clase);
			actDeportiva.agregarClase(clase);
			
		}else{
			throw new ClaseRepetidaEx("La clase de nombre: " + nombreClase + " ya existe.");
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
	public ArrayList<String> listarProfesores(String institucion) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<Usuario> usuarios = mU.listarUsuarios();
		ArrayList<String> profesores = new ArrayList<String>();
		for(Usuario u : usuarios) {
			if(u instanceof Profesor) {
				if(((Profesor) u).getInstitucion().getNombre().equals(institucion)) {
					profesores.add(u.getNickname());
				}
				
			}
		}
		
		return profesores;
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
	
	
	public ArrayList<DtClase> rankingClases(){
		
		ManejadorClase mC = ManejadorClase.getInstancia();
		ArrayList<Clase>ranking  = mC.getClases();
		
		//Sorting (bubble)
		
		for(int i=0;i<ranking.size();i++) {
			for(int j=0;j<ranking.size()-i-1;j++) {
				if(ranking.get(j).getCantRegistros()<ranking.get(j+1).getCantRegistros()) {
					 Collections.swap(ranking, j, j+1);
				}
			}
		}
		ArrayList<DtClase> rankingRet = new ArrayList<DtClase>();
			for(Clase c : ranking) {
				rankingRet.add(c.getDtClase());
			}
			
		
		return rankingRet;
	}	
		


}
