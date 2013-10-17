package analise.sintatica.naoterminal;

import java.util.Arrays;


public class RelExp extends NaoTerminal {
	
	private static RelExp instance;
	
	public static RelExp getInstance() {
		if (instance == null)
			instance = new RelExp();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(">", Arrays.asList("<RelOp>", "<ArithExp>"));
		producoes.put("<", Arrays.asList("<RelOp>", "<ArithExp>"));
		producoes.put("=", Arrays.asList("<RelOp>", "<ArithExp>"));		
		producoes.put("<>", Arrays.asList("<RelOp>", "<ArithExp>"));
		producoes.put(">=", Arrays.asList("<RelOp>", "<ArithExp>"));
		producoes.put("<=", Arrays.asList("<RelOp>", "<ArithExp>"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<RelExp>";
	}
}
