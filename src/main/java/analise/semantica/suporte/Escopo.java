package analise.semantica.suporte;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;

import utils.Token;

public class Escopo {
	
	List<Token> tokens = new ArrayList<Token>();

	public void adicionaToken(Token token) {
		tokens.add(token);
	}

	public Boolean possui(Token token) {
		for (Token tokenEscopo : tokens) {
			if (tokenEscopo.equals(token))
				return TRUE;
		}
		
		return FALSE;
	}

}
