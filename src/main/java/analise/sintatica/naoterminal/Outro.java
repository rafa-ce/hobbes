package analise.sintatica.naoterminal;

import java.util.Arrays;


public class Outro extends NaoTerminal {
	
	private static Outro instance;
	
	public static Outro getInstance() {
		if (instance == null)
			instance = new Outro();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("[", Arrays.asList("[", "<Exp>", "]", "<Outro>"));
		producoes.put("/", Arrays.asList("ε"));
		producoes.put("*", Arrays.asList("ε"));
	}

}
