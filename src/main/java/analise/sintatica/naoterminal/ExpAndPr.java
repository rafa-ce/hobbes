package analise.sintatica.naoterminal;

import java.util.Arrays;

public class ExpAndPr extends NaoTerminal {
	
	private static ExpAndPr instance;
	
	public static ExpAndPr getInstance() {
		if (instance == null)
			instance = new ExpAndPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("and", Arrays.asList("and", "<Exp>"));
		producoes.put("or", Arrays.asList("ε"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}
}