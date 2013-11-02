package analise.sintatica.naoterminal;

import java.util.Arrays;

public class FuncCorpo extends NaoTerminal {
	
	private static FuncCorpo instance;
	
	public static FuncCorpo getInstance() {
		if (instance == null)
			instance = new FuncCorpo();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put("(", Arrays.asList("(", FieldList.codigo(), ")","=", Exp.codigo()));
	}

	public static String codigo() {
		return "<FuncCorpo>";
	}
}
