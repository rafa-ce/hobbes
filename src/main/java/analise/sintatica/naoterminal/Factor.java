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
		producoes.put("if", Arrays.asList("<Bloco>"));
		producoes.put("for", Arrays.asList("<Bloco>"));
		producoes.put("while", Arrays.asList("<Bloco>"));
		producoes.put("break", Arrays.asList("break"));
		producoes.put("return", Arrays.asList("return", "<Exp>"));
		producoes.put("(", Arrays.asList("(", "<ExpList>", ")"));
		producoes.put("-", Arrays.asList("-", "<Exp>"));
		producoes.put(NUMERO, Arrays.asList("numero"));	
	}

	public static String codigo() {
		return "<Factor>";
	}
}
