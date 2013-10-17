package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;

public class ExpPr extends NaoTerminal {
	
	private static ExpPr instance;
	
	public static ExpPr getInstance() {
		if (instance == null)
			instance = new ExpPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("[", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("print", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("if", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("for", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("while", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("break", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("return", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put("(", Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put(NUMERO, Arrays.asList("<Exp>", "<ExpPr>"));
		producoes.put(")", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<ExpPr>";
	}
}
