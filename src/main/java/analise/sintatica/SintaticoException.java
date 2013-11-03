package analise.sintatica;

import utils.token.Token;

public class SintaticoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SintaticoException() {
		super("Erro Sintático.");
	}
	
	public SintaticoException(Token token) {
		super("Linha: " + token.getPosicao().getLinha() +
			  " - Coluna: " + token.getPosicao().getColuna() +
			  " .Token não esperado: " + token.getValor());
	}

	public SintaticoException(String topo) {
		super("Erro! Token: '" + topo + "' não encontrado.");
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}