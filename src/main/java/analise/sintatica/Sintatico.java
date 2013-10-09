package analise.sintatica;

import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;

import utils.Token;
import analise.lexica.Lexico;

public class Sintatico {
	
	private Lexico lexico;
	
	public Sintatico(String entrada) {
		this.lexico = new Lexico(entrada);
	}
	
	public List<Token> montaASA() throws Throwable {
		
		Token token;
		List<Token> tokens = new ArrayList<Token>();
		
		while (lexico.hasToken()) {
			token = lexico.getNextToken();
			
			if (token != null)
				tokens.add(token);			
		}
		
		return tokens;
		
	}
	
	private Boolean isTokenEsperado(Token token) {
		return TRUE;
	}
	
}
