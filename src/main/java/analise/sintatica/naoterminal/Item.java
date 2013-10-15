package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class Item extends NaoTerminal {
	
private static Item instance;
	
	public static Item getInstance() {
		if (instance == null)
			instance = new Item();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Exp>"));
		producoes.put("import", Arrays.asList("<Dec>"));
		producoes.put("[", Arrays.asList("<Exp>"));
		producoes.put("print", Arrays.asList("<Exp>"));
		producoes.put("if", Arrays.asList("<Exp>"));
		producoes.put("for", Arrays.asList("<Exp>"));
		producoes.put("while", Arrays.asList("<Exp>"));
		producoes.put("break", Arrays.asList("<Exp>"));
		producoes.put("return", Arrays.asList("<Exp>"));
		producoes.put("(", Arrays.asList("<Exp>"));
		producoes.put(NUMERO, Arrays.asList("<Exp>"));
		producoes.put("function", Arrays.asList("<Dec>"));
	}

}
