package excepciones;

public class NoExisteInstitucionDepEx extends Exception{
	private static final long serialVersionUID = 1L;

	public NoExisteInstitucionDepEx(String message) {
		super(message);
	}
	
}
