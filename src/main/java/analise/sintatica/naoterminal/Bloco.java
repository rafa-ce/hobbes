package analise.sintatica.naoterminal;

import java.util.Arrays;

public class Bloco extends NaoTerminal {

	private static Bloco instance;
	
	public static Bloco getInstance() {
		if (instance == null)
			instance = new Bloco();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("if", Arrays.asList("if", "<Exp>", "then", "<Exp>", "<Else>"));
		producoes.put("for", Arrays.asList("<Laco>"));
		producoes.put("while", Arrays.asList("<Laco>"));
	}

	public static String codigo() {
		return "<Bloco>";
	}
}
