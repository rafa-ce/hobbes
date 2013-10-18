package analise.sintatica.naoterminal;

import java.util.Arrays;

public class Away extends NaoTerminal {

	private static Away instance;
	
	public static Away getInstance() {
		if (instance == null)
			instance = new Away();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("if", Arrays.asList("if", "<Exp>", "then", "<Exp>", "<Else>"));
		producoes.put("for", Arrays.asList("<Laco>"));
		producoes.put("while", Arrays.asList("<Laco>"));
	}

	public static String codigo() {
		return "<Away>";
	}
}
