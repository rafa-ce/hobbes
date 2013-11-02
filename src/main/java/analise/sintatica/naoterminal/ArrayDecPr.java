package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;

public class ArrayDecPr extends NaoTerminal {

	private static ArrayDecPr instance;
	
	public static ArrayDecPr getInstance() {
		if (instance == null)
			instance = new ArrayDecPr();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("[", Arrays.asList("[", "]", ArrayDecPr.codigo()));
		producoes.put("]", Arrays.asList("ε"));
		
		producoes.put(IDENTIFICADOR, Arrays.asList("ε"));
		producoes.put("import", Arrays.asList("ε"));
		producoes.put("print", Arrays.asList("ε"));
		producoes.put("if", Arrays.asList("ε"));
		producoes.put("for", Arrays.asList("ε"));
		producoes.put("while", Arrays.asList("ε"));
		producoes.put("break", Arrays.asList("ε"));
		producoes.put("return", Arrays.asList("ε"));
		producoes.put("(", Arrays.asList("ε"));
		producoes.put(NUMERO, Arrays.asList("ε"));
		producoes.put("function", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
		producoes.put(")", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<ArrayDecPr>";
	}

}
