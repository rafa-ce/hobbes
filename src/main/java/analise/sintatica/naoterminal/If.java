package analise.sintatica.naoterminal;

import java.util.Arrays;

public class If extends NaoTerminal {

	private static If instance;
	
	public static If getInstance() {
		if (instance == null)
			instance = new If();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("if", Arrays.asList("if", "<Exp>", "then", "<Exp>", "<Else>"));
	}

	public static String codigo() {
		return "<If>";
	}

}
