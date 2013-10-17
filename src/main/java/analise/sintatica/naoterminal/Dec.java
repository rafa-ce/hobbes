package analise.sintatica.naoterminal;

import java.util.Arrays;


public class Dec extends NaoTerminal {
	
	private static Dec instance;
	
	public static Dec getInstance() {
		if (instance == null)
			instance = new Dec();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("function", Arrays.asList("function", "id", "(", "<FieldList>", ")","=", "<Exp>"));
	}
	
	public static String codigo() {
		return "<Dec>";
	}
}
