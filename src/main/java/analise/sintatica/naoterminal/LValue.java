package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;

import java.util.Arrays;

public class LValue extends NaoTerminal {
	
	private static LValue instance;
	
	public static LValue getInstance() {
		if (instance == null)
			instance = new LValue();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("id", "<LValuePr>"));
	}

}