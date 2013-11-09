package analise.semantica.suporte;

import java.util.ArrayList;
import java.util.List;

import analise.lexica.token.Token;

public class Escopo {
	
	List<Token> tokens = new ArrayList<Token>();

	public void adicionaToken(Token token) {
		tokens.add(token);
	}

	public Token possui(Token token) {
		for (Token tokenEscopo : tokens) {
			if (tokenEscopo.equals(token))
				return tokenEscopo;
		}
		
		return null;
	}

}
