package excepciones;

public class RegistroRepetidoEx extends Exception{
	private static final long serialVersionUID = 1L;
	
	public RegistroRepetidoEx(String msj) {
		super(msj);
	}

}
