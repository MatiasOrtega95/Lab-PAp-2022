package logica;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistencia.RegistroID;

@Entity
@IdClass(RegistroID.class)
public class Registro {
	
	//links (ver cuando se haga el CU)
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false, 
			updatable=false
	)
	private Clase clase;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false, 
			updatable=false
	)
	private Socio socio;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaReg;
	
	public Registro() {
		super();
	}
	
	public Registro(Clase clase, Socio socio) {
		super();
		this.clase = clase;
		this.socio = socio;
		//this.clase.agregarRegistro(this);
		//this.socio.agregarRegistro(this);
		Calendar c = Calendar.getInstance();
		this.fechaReg = c;
	}

	public Calendar getDtFechaReg() {
		return fechaReg;
	}

	public Clase getClase() {
		return clase;
	}

	public Socio getSocio() {
		return socio;
	}

}
