package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class Factor extends NaoTerminal {
	
	private static Factor instance;
	
	public static Factor getInstance() {
		if (instance == null)
			instance = new Factor();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<LValue>"));
		producoes.put("[", Arrays.asList("[", "<ArgList>", "]"));
//		producoes.put("print", Arrays.asList("print string [, <Exp>]"));
		producoes.put("if", Arrays.asList("if", "<Exp>", "then", "<Exp>", "<Else>"));
		producoes.put("for", Arrays.asList("for", "id", ":=", "<Exp>", "to", "<Exp>", "do", "<Exp>"));
		producoes.put("while", Arrays.asList("while", "<Exp>", "do", "<Exp>"));
		producoes.put("break", Arrays.asList("break"));
		producoes.put("return", Arrays.asList("return"));
		producoes.put("(", Arrays.asList("(", "<ExpList>", ")"));
		producoes.put("-", Arrays.asList("-", "<Exp>"));
		producoes.put(NUMERO, Arrays.asList("numero"));	
	}

	public static String codigo() {
		return "<Factor>";
	}
}
