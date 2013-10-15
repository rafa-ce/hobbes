package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class IfElse extends NaoTerminal {
	
	private static IfElse instance;
	
	public static IfElse getInstance() {
		if (instance == null)
			instance = new IfElse();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("ε"));
		producoes.put("[", Arrays.asList("ε"));
		producoes.put("print", Arrays.asList("ε"));
		producoes.put("if", Arrays.asList("ε"));
		producoes.put("else", Arrays.asList("else", "<Exp>"));
		producoes.put("for", Arrays.asList("ε"));
		producoes.put("while", Arrays.asList("ε"));
		producoes.put("break", Arrays.asList("ε"));
		producoes.put("return", Arrays.asList("ε"));
		producoes.put("(", Arrays.asList("ε"));
		producoes.put(NUMERO, Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

}