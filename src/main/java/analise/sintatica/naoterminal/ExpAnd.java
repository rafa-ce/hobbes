package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class ExpAnd extends NaoTerminal {
	
	private static ExpAnd instance;
	
	public static ExpAnd getInstance() {
		if (instance == null)
			instance = new ExpAnd();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("[", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("print", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("if", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("for", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("while", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("break", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("return", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put("(", Arrays.asList("<ArithExp>", "<RelExp>"));
		producoes.put(NUMERO, Arrays.asList("<ArithExp>", "<RelExp>"));		
	}

}
