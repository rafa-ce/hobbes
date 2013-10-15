package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class ArithExp extends NaoTerminal {
	
	private static ArithExp instance;
		
	public static ArithExp getInstance() {
		if (instance == null)
			instance = new ArithExp();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("[", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("print", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("if", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("for", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("while", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("break", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("return", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put("(", Arrays.asList("<Term>", "<TermPr>"));
		producoes.put(NUMERO, Arrays.asList("<Term>", "<TermPr>"));
	}

}
