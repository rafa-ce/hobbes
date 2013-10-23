package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class ExpOrPr extends NaoTerminal {
	
	private static ExpOrPr instance;
	
	public static ExpOrPr getInstance() {
		if (instance == null)
			instance = new ExpOrPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("ε"));
		producoes.put("import", Arrays.asList("ε"));
		producoes.put("[", Arrays.asList("ε"));
		producoes.put("]", Arrays.asList("ε"));
		producoes.put("print", Arrays.asList("ε"));
		producoes.put("if", Arrays.asList("ε"));
		producoes.put("then", Arrays.asList("ε"));
		producoes.put("else", Arrays.asList("ε"));
		producoes.put("for", Arrays.asList("ε"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("while", Arrays.asList("ε"));
		producoes.put("break", Arrays.asList("ε"));
		producoes.put("return", Arrays.asList("ε"));
		producoes.put("(", Arrays.asList("ε"));
		producoes.put(")", Arrays.asList("ε"));
		producoes.put("or", Arrays.asList("or", "<Exp>"));
		producoes.put(NUMERO, Arrays.asList("ε"));
		producoes.put("function", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<ExpORPr>";
	}
}
