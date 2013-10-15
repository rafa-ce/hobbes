package analise.sintatica.naoterminal;

import java.util.Arrays;

public class ArgListPr extends NaoTerminal {
	
	private static ArgListPr instance;
	
	public static ArgListPr getInstance() {
		if (instance == null)
			instance = new ArgListPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("$", Arrays.asList("ε"));
		producoes.put(",", Arrays.asList(",", "<Exp>", "<ArgListPr>"));
		producoes.put(")", Arrays.asList("ε"));
	}

}
