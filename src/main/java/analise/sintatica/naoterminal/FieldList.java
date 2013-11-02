package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;

import java.util.Arrays;

public class FieldList extends NaoTerminal {
	
	private static FieldList instance;
	
	public static FieldList getInstance() {
		if (instance == null)
			instance = new FieldList();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList(IDENTIFICADOR, FieldListPr.codigo()));
		producoes.put(")", Arrays.asList("ε"));
	}

	public static String codigo() {
		return "<FieldList>";
	}
}
