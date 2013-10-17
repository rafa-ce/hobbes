package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class Lista extends NaoTerminal {

	private static Lista instance;
	
	public static Lista getInstance() {
		if (instance == null)
			instance = new Lista();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Item>", "<Lista>"));
		producoes.put("import", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("[", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("print", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("if", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("for", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("while", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("break", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("return", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("(", Arrays.asList("<Item>", "<Lista>"));
		producoes.put(NUMERO, Arrays.asList("<Item>", "<Lista>"));
		producoes.put("function", Arrays.asList("<Item>", "<Lista>"));
		producoes.put("$", Arrays.asList("ε"));
	}
	
	public static String codigo() {
		return "<Lista>";
	}
}
