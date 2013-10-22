package analise.sintatica.naoterminal;

import java.util.Arrays;

public class TermPr extends NaoTerminal {
	
	private static TermPr instance;
	
	public static TermPr getInstance() {
		if (instance == null)
			instance = new TermPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("+", Arrays.asList("+", "<Term>", "<TermPr>"));
		producoes.put("-", Arrays.asList("-", "<Term>", "<TermPr>"));
		producoes.put(">", Arrays.asList("ε"));
		producoes.put("<", Arrays.asList("ε"));
		producoes.put("=", Arrays.asList("ε"));		
		producoes.put("<>", Arrays.asList("ε"));
		producoes.put(">=", Arrays.asList("ε"));
		producoes.put("<=", Arrays.asList("ε"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("then", Arrays.asList("ε"));
		producoes.put("else", Arrays.asList("ε"));
		producoes.put("return", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<TermPr>";
	}
}
