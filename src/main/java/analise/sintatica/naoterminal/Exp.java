package analise.sintatica.naoterminal;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;

import java.util.Arrays;


public class Exp extends NaoTerminal {

	private static Exp instance;
	
	public static Exp getInstance() {
		if (instance == null)
			instance = new Exp();
		
		return instance;
	}
	
	@Override
	protected void inicializaProducoes() {
		producoes.put(IDENTIFICADOR, Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("[", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("print", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("if", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("for", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("while", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("break", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("return", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put("(", Arrays.asList("<ExpOR>", "<ExpORPr>"));
		producoes.put(NUMERO, Arrays.asList("<ExpOR>", "<ExpORPr>"));		
	}

}