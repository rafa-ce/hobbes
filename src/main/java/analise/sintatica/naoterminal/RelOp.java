package analise.sintatica.naoterminal;

import java.util.Arrays;

public class RelOp extends NaoTerminal {
	
	private static RelOp instance;
	
	public static RelOp getInstance() {
		if (instance == null)
			instance = new RelOp();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(">", Arrays.asList(">"));
		producoes.put("<", Arrays.asList("<"));
		producoes.put("=", Arrays.asList("="));		
		producoes.put("<>", Arrays.asList("<>"));
		producoes.put(">=", Arrays.asList(">="));
		producoes.put("<=", Arrays.asList("<="));		
	}

}
