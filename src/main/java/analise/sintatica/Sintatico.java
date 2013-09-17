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
		
		Token proximoToken;
		Token tokenAtual = lexico.getNextToken() ;
		
		List<Token> tokens = new ArrayList<Token>();
		
		while (lexico.hasToken()) {
			
			proximoToken = lexico.getNextToken();
			
			if (proximoToken != null)
				tokens.add(tokenAtual);
			
			tokenAtual = proximoToken;
			
		}
		
		tokens.add(tokenAtual);
		
		return tokens;
		
	}
	
}
