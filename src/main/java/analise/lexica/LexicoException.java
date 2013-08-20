package analise.lexica;

public class LexicoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LexicoException() {
		super("Token inválido");
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
