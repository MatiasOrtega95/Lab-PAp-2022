package datatypes;

import java.util.Calendar;

import excepciones.FechaInvalidaEx;
import excepciones.HoraInvalidaEx;

public class DtFechaHora extends DtFecha{
	//formato 24hs
	final int MAXHORA = 23;
	final int MINHORA = 0;
	final int MINMIN = 0;
	final int MAXMIN = 59;
	final int MINSEG = 0;
	final int MAXSEG = 59;
	private int hora;
	private int min;
	private int seg;

	public DtFechaHora(int anio, int mes, int dia, int hora, int min, int seg) throws HoraInvalidaEx, FechaInvalidaEx {
		super(anio, mes, dia);
		if (hora >= MAXHORA && hora <=MINHORA) {
			throw new HoraInvalidaEx("La hora ingresada es inválida. Rango permitido: " + MINHORA +"-" +MAXHORA);
		}else if (min >= MAXMIN && min <= MINMIN) {
			throw new HoraInvalidaEx("Los minutos ingresados son inválidos. Rango permitido: " + MINMIN +"-" +MAXMIN);
		}else if (seg >= MAXSEG && seg <= MINSEG) {
			throw new HoraInvalidaEx("Los segundos ingresados son inválidos. Rango permitido: " + MINSEG +"-" +MAXSEG);
		}
		this.hora = hora;
		this.min = min;
		this.seg = seg;
	}
	
	public DtFechaHora(Calendar cal, int hora, int min) {
		super(cal);
		this.hora = hora;
		this.min = min;
		this.seg = cal.get(Calendar.SECOND);
	}
	
	public int getHora() {
		return hora;
	}

	public int getMin() {
		return min;
	}

	public int getSeg() {
		return seg;
	}
	
	@Override
	public String toString() {
		return getDia() + "/" + getMes() + "/" + getAnio() + " " + hora + ":" + min + ":" + seg;
	}

}
