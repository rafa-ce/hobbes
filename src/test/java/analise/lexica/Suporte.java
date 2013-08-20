package analise.lexica;

import analise.lexica.automato.Automato;
import analise.lexica.automato.AutomatoException;
import analise.lexica.automato.Estado;

public class Suporte {
	
	public static Estado percorreAutomato(String entrada, Automato automato, Estado estadoAtual) throws AutomatoException {
		for (Character cada : entrada.toCharArray()) {
			try {
				estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
			} catch (AutomatoException e) {
				throw e;
			}
		}
		
		return estadoAtual;		
	}

}
