package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;

import java.util.Arrays;

public class Laco extends NaoTerminal {

	private static Laco instance;
	
	public static Laco getInstance() {
		if (instance == null)
			instance = new Laco();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("for", Arrays.asList("for", IDENTIFICADOR, ":=", "<Exp>", "to", "<Exp>", "do", "<Exp>"));
		producoes.put("while", Arrays.asList("while", "<Exp>", "do", "<Exp>"));		
	}

	public static String codigo() {
		return "<Laco>";
	}
}
