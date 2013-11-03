package analise.semantica.suporte;

import java.util.ArrayList;
import java.util.List;

import utils.token.Token;
import analise.sintatica.suporte.No;

public class TabelaDeSimbolos {
	
	private List<Escopo> escopos = new ArrayList<Escopo>();

	public List<Escopo> getTabela() {
		return escopos;
	}
	
	public void abreEscopo() {
		escopos.add(new Escopo());
	}
	
	private Escopo ultimoEscopo() {
		return escopos.get(escopos.size() - 1);
	}

	public void adicionaToken(Token token) {
		ultimoEscopo().adicionaToken(token);
	}

	public void defineEscopo(No anterior, No atual) {
		if (anterior == null) {
			abreEscopo();
			return;
		}
			
		if (anterior.equals(atual.getPai()))
			abreEscopo();
		else
			fechaEscopo();
	}

	private void fechaEscopo() {
		escopos.remove(ultimoEscopo());
	}

	public Token possuiToken(Token token) {
		for (int i = escopos.size() - 1; i >= 0; i--) {
			Token tokenEscopo = escopos.get(i).possui(token);
			if (tokenEscopo != null)
				return tokenEscopo;
		}
		return null;
	}

	public Token taNoUltimoEscopo(Token token) {
		return ultimoEscopo().possui(token);
	}

}
