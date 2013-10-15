package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class Prog extends NaoTerminal {
	
	private static Prog instance;
	
	public static Prog getInstance() {
		if (instance == null)
			instance = new Prog();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Lista>"));
		producoes.put("import", Arrays.asList("<Lista>"));
		producoes.put("[", Arrays.asList("<Lista>"));
		producoes.put("print", Arrays.asList("<Lista>"));
		producoes.put("if", Arrays.asList("<Lista>"));
		producoes.put("for", Arrays.asList("<Lista>"));
		producoes.put("while", Arrays.asList("<Lista>"));
		producoes.put("break", Arrays.asList("<Lista>"));
		producoes.put("return", Arrays.asList("<Lista>"));
		producoes.put("(", Arrays.asList("<Lista>"));
		producoes.put(NUMERO, Arrays.asList("<Lista>"));
		producoes.put("function", Arrays.asList("<Lista>"));
		producoes.put("$", Arrays.asList("ε"));		
	}
}
