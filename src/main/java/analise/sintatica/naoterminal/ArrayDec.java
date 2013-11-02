package analise.sintatica.naoterminal;

import java.util.Arrays;

public class ArrayDec extends NaoTerminal {

	private static ArrayDec instance;
	
	public static ArrayDec getInstance() {
		if (instance == null)
			instance = new ArrayDec();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put("[", Arrays.asList("[", "]", ArrayDecPr.codigo()));
	}

	public static String codigo() {
		return "<ArrayDec>";
	}

}
