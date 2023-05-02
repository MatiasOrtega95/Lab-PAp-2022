package excepciones;

public class UsuarioRepetidoEx extends Exception{
	private static final long serialVersionUID = 1L;

	public UsuarioRepetidoEx(String message) {
		super(message);
	}

}
