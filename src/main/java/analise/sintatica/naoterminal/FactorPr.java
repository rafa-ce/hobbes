package analise.sintatica.naoterminal;

import java.util.Arrays;

public class FactorPr extends NaoTerminal {
	
	private static FactorPr instance;
	
	public static FactorPr getInstance() {
		if (instance == null)
			instance = new FactorPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("+", Arrays.asList("id", "<FieldListPr>"));
		producoes.put("-", Arrays.asList("ε"));
		producoes.put("/", Arrays.asList("/", "<Factor>", "<FactorPr>"));
		producoes.put("*", Arrays.asList("*", "<Factor>", "<FactorPr>"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<FactorPr>";
	}
}
