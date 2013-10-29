package analise.semantica.suporte;

import java.util.ArrayList;
import java.util.List;

import utils.Token;

public class Escopo {
	
	List<Token> tokens = new ArrayList<Token>();

	public void adicionaToken(Token token) {
		tokens.add(token);
	}

}
