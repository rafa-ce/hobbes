package analise.semantica;

import java.util.ArrayList;
import java.util.List;

import utils.Token;
import analise.sintatica.arvore.No;


public class Semantica {

	private static List<Token> lista; 
	
	public static void executa(No no) {
		
		lista = new ArrayList<Token>();
		
		while (no != null) {
			
			if (no.isToken())
				lista.add(no.getConteudo());
				
			no = no.proximo();
			
		}
		
	}
	
	public static List<Token> getLista() {
		return lista;
	}
	
}
