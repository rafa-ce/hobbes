package analise.lexica.automato;

public class AutomatoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AutomatoException() {
		super("Caractere Inválido");
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
