package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;

public class Term extends NaoTerminal {
	
	private static Term instance;
	
	public static Term getInstance() {
		if (instance == null)
			instance = new Term();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("print", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("if", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("for", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("while", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("break", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("return", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("(", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("[", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put("-", Arrays.asList("<Factor>", "<FactorPr>"));
		producoes.put(NUMERO, Arrays.asList("<Factor>", "<FactorPr>"));				
	}

	public static String codigo() {
		return "<Term>";
	}
}
