package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;

import java.util.Arrays;

public class FieldListPr extends NaoTerminal {
	
	private static FieldListPr instance;
	
	public static FieldListPr getInstance() {
		if (instance == null)
			instance = new FieldListPr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(",", Arrays.asList(",", IDENTIFICADOR, codigo()));
		producoes.put(")", Arrays.asList("ε"));		
	}

	public static String codigo() {
		return "<FieldListPr>";
	}
}
