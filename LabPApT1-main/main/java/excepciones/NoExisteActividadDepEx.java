package excepciones;

public class NoExisteActividadDepEx extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoExisteActividadDepEx(String msj) {
		super(msj);
	}
}
