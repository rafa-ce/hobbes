package analise.semantica;

import utils.Token;

public class SemanticoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SemanticoException(Token token) {
		super(token.getPosicao().toString());
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}