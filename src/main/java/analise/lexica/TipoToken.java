package analise.lexica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipoToken {
	
	public static final String STRING = "string";
	public static final String OPERADOR = "operador";
	public static final String NUMERO = "numero";
	public static final String IDENTIFICADOR = "identificador";
	public static final String PALAVRA_CHAVE = "palavraChave";
	public static final String SIMBOLO = "simbolo";
	
	private static final String PALAVRA = "palavra";
	
	private Map<Integer, String> tiposToken;
	private static List<String> palavrasChave;
	private List<String> operadores;
	
	public TipoToken() {
		iniciaTiposToken();
		iniciaPalavrasChave();
		iniciaOperadores();
	}

	public String getTipo(Integer id, String valor) {
		
		String tipo = tiposToken.get(id);
		
		if (tipo.equals(PALAVRA)) {
			return identificaPalavra(valor);
		}
	
		return tipo;
	}
	
	private String identificaPalavra(String valor) {
		if (operadores.contains(valor)) {
			return OPERADOR;
		}
		
		if (palavrasChave.contains(valor)) {
			return PALAVRA_CHAVE;
		}
		
		return IDENTIFICADOR;
	}

	private void iniciaTiposToken() {
		tiposToken = new HashMap<Integer, String>();
		tiposToken.put(2, PALAVRA);
		tiposToken.put(4, NUMERO);
		tiposToken.put(6, OPERADOR);
		tiposToken.put(17, STRING);
		tiposToken.put(19, SIMBOLO);
	}     

	private void iniciaPalavrasChave() {
		palavrasChave = new ArrayList<String>();
		palavrasChave.add("array");
		palavrasChave.add("if");
		palavrasChave.add("then");
		palavrasChave.add("else");
		palavrasChave.add("while");
		palavrasChave.add("for");
		palavrasChave.add("to");
		palavrasChave.add("do");
		palavrasChave.add("break");
		palavrasChave.add("nil");
		palavrasChave.add("function");
		palavrasChave.add("return");
		palavrasChave.add("import");
		palavrasChave.add("and");
		palavrasChave.add("or");
		palavrasChave.add("printf");
	}
	
	private void iniciaOperadores() {
		this.operadores = new ArrayList<String>();
		operadores.add("and");
		operadores.add("or");
	}
	
	public static List<String> getPalavrasChave() {
		return palavrasChave;
	}
	
}
