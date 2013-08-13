package analise.lexica;

import java.util.HashMap;
import java.util.Map;

public class TipoToken {
	
	private Map<Integer, String> tipoToken;
	
	public TipoToken() {
		tipoToken = new HashMap<Integer, String>();
		tipoToken.put(2, "palavra");
		tipoToken.put(4, "numero");
		tipoToken.put(6, "simbolo");
		tipoToken.put(8, "simbolo");
		tipoToken.put(9, "simbolo");
		tipoToken.put(10, "simbolo");
		tipoToken.put(12, "simbolo");
		tipoToken.put(13, "simbolo");
		tipoToken.put(15, "simbolo");
		tipoToken.put(19, "simbolo");
	}     
	
	public String getTipo(Integer id) {
		return tipoToken.get(id);
	}
}
