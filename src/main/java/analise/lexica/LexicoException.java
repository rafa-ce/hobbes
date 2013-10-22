package analise.lexica;

public class LexicoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LexicoException(String valorDoToken, Integer tokenLinha, Integer tokenColuna) {
		super("Linha: " + tokenLinha + 
			" - Coluna: " + tokenColuna + ". Token " + 
				valorDoToken + " inválido");
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}