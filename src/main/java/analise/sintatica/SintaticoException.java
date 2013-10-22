package analise.sintatica;

public class SintaticoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SintaticoException() {
		super("Erro Sintático.");
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}