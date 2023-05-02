package excepciones;

public class HoraInvalidaEx extends Exception{
	private static final long serialVersionUID = 1L;

	public HoraInvalidaEx(String msj) {
		super(msj);
	}
}
