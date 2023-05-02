package logica;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ManejadorUsuario() {}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null) 
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void actualizarUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		usuarios = (ArrayList<Usuario>) query.getResultList();
		
		
	}
	
	
	public void agregarUsuario(Usuario u) {
		//usuarios.add(u);
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(u);
		
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuarioPorNickname(String nickname) {
		actualizarUsuarios();
		Usuario usuario=null;
		for(Usuario u: usuarios) {
			if (u.getNickname().equals(nickname))
				usuario = u;
		}
		return usuario;
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		actualizarUsuarios();
		Usuario usuario=null;
		for(Usuario u: usuarios) {
			if (u.getEmail().equals(email))
				usuario = u;
		}
		return usuario;
	}

	public ArrayList<String> toNickString() {
		actualizarUsuarios();
		ArrayList<String> nickUsuarios = new ArrayList<>();
		for(Usuario u : this.usuarios){
			nickUsuarios.add(u.getNickname());
		}
		return nickUsuarios;
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		actualizarUsuarios();
		return usuarios;
	}
	
	public ArrayList<Socio> listarSocio(){
		actualizarUsuarios();
		ArrayList<Socio> socios = new ArrayList<Socio>();
		
		for(Usuario u : usuarios){			
			//Socio s = (Socio) u;
			if ( u instanceof Socio)
				socios.add((Socio)u);					
		}
		return socios;	
	}

}
	

