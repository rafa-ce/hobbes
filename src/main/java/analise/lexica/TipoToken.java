package analise.lexica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipoToken {
	
	private Map<Integer, String> tiposToken;
	private List<String> palavrasChave;
	private List<String> simbolos;
	
	public TipoToken() {
		iniciaTiposToken();
		iniciaPalavrasChave();
		iniciaSibolos();
	}

	public String getTipo(Integer id, String valor) {
		
		String tipo = tiposToken.get(id);
		
		if (tipo.equals("palavra")) {
			return identificaPalavra(valor);
		}
	
		return tipo;
	}
	
	private String identificaPalavra(String valor) {
		if (simbolos.contains(valor)) return "simbolo";
		if (palavrasChave.contains(valor)) return "palavraChave";
		return "identificador";
	}

	private void iniciaTiposToken() {
		tiposToken = new HashMap<Integer, String>();
		tiposToken.put(2, "palavra");
		tiposToken.put(4, "numero");
		tiposToken.put(6, "simbolo");
		tiposToken.put(8, "simbolo");
		tiposToken.put(9, "simbolo");
		tiposToken.put(10, "simbolo");
		tiposToken.put(12, "simbolo");
		tiposToken.put(13, "simbolo");
		tiposToken.put(15, "simbolo");
		tiposToken.put(19, "simbolo");
	}     

	private void iniciaPalavrasChave() {
		this.palavrasChave = new ArrayList<String>();
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
		palavrasChave.add("import");
		palavrasChave.add("and");
		palavrasChave.add("or");
	}
	
	private void iniciaSibolos() {
		this.simbolos = new ArrayList<String>();
		simbolos.add("and");
		simbolos.add("or");
	}
	
}
