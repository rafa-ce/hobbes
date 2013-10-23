package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class ExpOr extends NaoTerminal {
	
	private static ExpOr instance;
	
	public static ExpOr getInstance() {
		if (instance == null)
			instance = new ExpOr();
		
		return instance;
	}

	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("[", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("print", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("if", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("for", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("while", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("break", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("return", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put("(", Arrays.asList("<ExpAND>", "<ExpANDPr>"));
		producoes.put(NUMERO, Arrays.asList("<ExpAND>", "<ExpANDPr>"));			
	}

	public static String codigo() {
		return "<ExpOR>";
	}
}
