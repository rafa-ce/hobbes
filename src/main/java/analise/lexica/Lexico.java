package analise.lexica;

import analise.lexica.automato.Automato;

public class Lexico {
	
	private Automato automato;

	public Lexico() {
		this.automato = AutomatoTiger.implementa();
	}
}
