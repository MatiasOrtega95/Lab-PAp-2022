package logica;

import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.NoExisteInstitucionDepEx;
import excepciones.NoExistenUsuariosEx;
import excepciones.UsuarioRepetidoEx;
import interfaces.IControladorUsuario;
import persistencia.Conexion;

import java.util.ArrayList;

import javax.persistence.EntityManager;


public class ControladorUsuario implements IControladorUsuario{

	public ControladorUsuario() {
		super();
	}
	
	public void altaUsuario(DtUsuario dtU) throws UsuarioRepetidoEx, NoExisteInstitucionDepEx{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorInstitucionDep mInstDep = ManejadorInstitucionDep.getInstancia();
		Usuario uN = mU.buscarUsuarioPorNickname(dtU.getNickname());
		Usuario uE = mU.buscarUsuarioPorEmail(dtU.getEmail());
		
		if(uN != null) 
			throw new UsuarioRepetidoEx("El usuario " + uN.getNickname() + " ya esta registrado");
		
		if(uE != null) 
			throw new UsuarioRepetidoEx("El usuario con email " + uE.getEmail() + " ya esta registrado");
		
		if(dtU instanceof DtProfesor) {
			InstitucionDeportiva instDep = mInstDep.buscarInstitucion(((DtProfesor) dtU).getInstitucion().getNombre());
			if (instDep == null)
				throw new NoExisteInstitucionDepEx("No existe la institución deportiva: " +((DtProfesor) dtU).getInstitucion().getNombre());
			uN = new Profesor(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getContrasenia(), dtU.getpfp(),
					dtU.getFecha(), ((DtProfesor) dtU).getDescripcion(), ((DtProfesor) dtU).getBiografia(), ((DtProfesor) dtU).getSitioWeb(),instDep);
		}
		if(dtU instanceof DtSocio) {
			uN = new Socio(dtU.getNickname(), dtU.getNombre(), dtU.getApellido(), dtU.getEmail(), dtU.getContrasenia(), dtU.getpfp(), dtU.getFecha());
		}
		
		mU.agregarUsuario(uN);
	}
	
	@Override
	public void modificarUsuario(DtUsuario dtU) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uN = mU.buscarUsuarioPorNickname(dtU.getNickname());
		
		uN.setNombre(dtU.getNombre());
		uN.setApellido(dtU.getApellido());
		uN.setDtFechaNac(dtU.getFecha());
		uN.setContrasenia(dtU.getContrasenia());
		uN.setpfp(dtU.getpfp());
		
		if(uN instanceof Profesor) {
			((Profesor) uN).setSitioWeb(((DtProfesor) dtU).getSitioWeb());
			((Profesor) uN).setBiografia(((DtProfesor) dtU).getBiografia());
			((Profesor) uN).setDescripcion(((DtProfesor) dtU).getDescripcion());
		}
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(uN);
		
		em.getTransaction().commit();
	}
	
	public String[] mostrarUsuarios(){ // Retorna un set(String): ArrayList
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> users = mU.toNickString();
		String[] users_ret = new String[users.size()];
		int i = 0;
		for(String s : users) {
			users_ret[i]=s;
			i++;
		}		
		return users_ret;
	}	
	
	public DtUsuario consultaUsuario(String nick){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uS = mU.buscarUsuarioPorNickname(nick);
		DtUsuario dtU;
		
		if (uS instanceof Profesor) {
			Profesor p = (Profesor) uS;
			 //dtU = new DtProfesor(p.getNickname(),p.getNombre(),p.getApellido(),p.getEmail(),p.getDtFechaNac(),p.getBiografia(),p.getDescripcion(),p.getSitioWeb(), new DtInstitucionDeportiva(p.getInstitucion().getNombre(),p.getInstitucion().getDescripcion(),p.getInstitucion().getUrl()));
			dtU = p.getDtProfesor();
		}	
		else {
			Socio s = (Socio) uS;
			//dtU = new DtSocio(s.getNickname(),s.getNombre(),s.getApellido(),s.getEmail(),s.getDtFechaNac());
			dtU = s.getDtSocio();
		}
		
		return dtU;
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
	public DtInstitucionDeportiva getDtinstitucionDeportiva(String institucion) {
		ManejadorInstitucionDep mI = ManejadorInstitucionDep.getInstancia();
		InstitucionDeportiva inst = mI.buscarInstitucion(institucion);
		DtInstitucionDeportiva dtInst = inst.getDtInstitucionDeportiva();
		return dtInst;
		
	}

	@Override
	public DtUsuario existeUsuario(String nickname, String pass) throws NoExistenUsuariosEx{
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario uS = mU.buscarUsuarioPorNickname(nickname);
		DtUsuario dtU;
		if (uS == null){
			throw new NoExistenUsuariosEx("El usuario no existe");
		}
		if (uS.getContrasenia().equals(pass)) {
			if (uS instanceof Profesor) {
				Profesor p = (Profesor) uS;
				dtU = p.getDtProfesor();
			}	
			else {
				Socio s = (Socio) uS;
				dtU = s.getDtSocio();
			}
		}else{
			throw new NoExistenUsuariosEx("Datos equivocados");
		}
		return dtU;
	}

}
