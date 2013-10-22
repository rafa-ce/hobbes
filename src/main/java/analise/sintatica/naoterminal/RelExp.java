package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

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
		producoes.put(IDENTIFICADOR, Arrays.asList("ε"));
		producoes.put("import", Arrays.asList("ε"));
		producoes.put("[", Arrays.asList("ε"));
		producoes.put("]", Arrays.asList("ε"));
		producoes.put("print", Arrays.asList("ε"));
		producoes.put("if", Arrays.asList("ε"));
		producoes.put("then", Arrays.asList("ε"));
		producoes.put("else", Arrays.asList("ε"));
		producoes.put("for", Arrays.asList("ε"));
		producoes.put("to", Arrays.asList("ε"));
		producoes.put("do", Arrays.asList("ε"));
		producoes.put("while", Arrays.asList("ε"));
		producoes.put("break", Arrays.asList("ε"));
		producoes.put("return", Arrays.asList("ε"));
		producoes.put("(", Arrays.asList("ε"));
		producoes.put(")", Arrays.asList("ε"));
		producoes.put("or", Arrays.asList("ε"));
		producoes.put(NUMERO, Arrays.asList("ε"));
		producoes.put("function", Arrays.asList("ε"));
		producoes.put("$", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<RelExp>";
	}
}
