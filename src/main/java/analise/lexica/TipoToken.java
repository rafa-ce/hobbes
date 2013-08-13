package analise.lexica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipoToken {
	
	private Map<Integer, String> tipoToken;
	private List<String> palavrasChave; 
	
	public TipoToken() {
		tipoToken = new HashMap<Integer, String>();
		tipoToken.put(2, "identificador");
		tipoToken.put(4, "numero");
		tipoToken.put(6, "simbolo");
		tipoToken.put(8, "simbolo");
		tipoToken.put(9, "simbolo");
		tipoToken.put(10, "simbolo");
		tipoToken.put(12, "simbolo");
		tipoToken.put(13, "simbolo");
		tipoToken.put(15, "simbolo");
		tipoToken.put(19, "simbolo");
		
		this.palavrasChave = new ArrayList<String>();
		palavrasChave.add("while");
		palavrasChave.add("do");
		//TODO: todas as palavras chave
		
	}     
	
	public String getTipo(Integer id, String valor) {
		
		if (palavrasChave.contains(valor)){
			return "palavraChave";
		}
		
		return tipoToken.get(id);
	}
	
}
