package excepciones;

public class FechaInvalidaEx extends Exception{
	private static final long serialVersionUID = 1L;

	public FechaInvalidaEx(String msj) {
		super(msj);
	}
}
