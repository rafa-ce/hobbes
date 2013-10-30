package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;

public class ArgList extends NaoTerminal {
	
	private static ArgList instance;
	
	public static ArgList getInstance() {
		if (instance == null)
			instance = new ArgList();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("[", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("print", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("if", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("for", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("while", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("break", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("return", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put("(", Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put(NUMERO, Arrays.asList("<Exp>", "<ArgListPr>"));
		producoes.put(")", Arrays.asList("ε"));
		producoes.put("]", Arrays.asList("ε"));
	}
	
	public static String codigo() {
		return "<ArgList>";
	}
}
