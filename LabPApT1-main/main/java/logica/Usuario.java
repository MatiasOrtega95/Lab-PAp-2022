package logica;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;

import datatypes.DtFecha;

@Entity
public abstract class Usuario {
	@Id
	private String nickname;//unico
	private String nombre;
	private String apellido;
	private String email;//unico
	private String contrasenia;
	private String pfp;
	private Calendar fechaNac;
	
	public Usuario(String nickname, String nombre, String apellido, String email, String contrasenia, String pfp, DtFecha fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.pfp = pfp;
		Calendar cal = new GregorianCalendar(fechaNac.getAnio(),fechaNac.getMes(),fechaNac.getDia());
		this.fechaNac = cal;
	}
	
	public Usuario() {
		super();
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getpfp() {
		return pfp; 
	}
	public void setpfp(String pfp) {
		this.pfp = pfp;
	}
	public DtFecha getDtFechaNac() {
		DtFecha dtF = new DtFecha(fechaNac);
		return dtF;
	}
	public void setDtFechaNac(DtFecha fechaNac) {
		Calendar cal = new GregorianCalendar(fechaNac.getAnio(),fechaNac.getMes(),fechaNac.getDia());
		this.fechaNac = cal;
	}
	//public abstract DtUsuario consulta(Usuario uS);
	
}
