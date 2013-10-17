package analise.sintatica.naoterminal;

import java.util.Arrays;


public class LValuePr extends NaoTerminal {
	
	private static LValuePr instance;
	
	public static LValuePr getInstance() {
		if (instance == null)
			instance = new LValuePr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("[", Arrays.asList("[", "<Exp>", "]", "<Outro>"));
		producoes.put("(", Arrays.asList("(", "<ArgList>", ")"));		
		producoes.put("/", Arrays.asList("ε"));
		producoes.put("*", Arrays.asList("ε"));
		producoes.put(":=", Arrays.asList(":=", "<Exp>"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

}
