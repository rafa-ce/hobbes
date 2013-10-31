package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;

import java.util.Arrays;

public class FuncDec extends NaoTerminal {
	
	private static FuncDec instance;
	
	public static FuncDec getInstance() {
		if (instance == null)
			instance = new FuncDec();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("function", Arrays.asList("function", IDENTIFICADOR, FuncCorpo.codigo()));
	}

	public static String codigo() {
		return "<FuncDec>";
	}
}
