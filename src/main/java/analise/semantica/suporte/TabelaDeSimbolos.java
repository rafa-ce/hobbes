package analise.semantica.suporte;

import java.util.ArrayList;
import java.util.List;

import utils.Token;
import analise.sintatica.suporte.No;

public class TabelaDeSimbolos {
	
	private List<Escopo> escopos = new ArrayList<Escopo>();

	public List<Escopo> getTabela() {
		return escopos;
	}
	
	public void abreEscopo() {
		escopos.add(new Escopo());
		System.out.println("Abre: " + escopos.size());
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
			
		if (anterior.equals(atual.getPai())) {
			abreEscopo();
//			System.out.println("Abre: " + escopos.size() + " - " + atual.getConteudo().toString());			
		} else {
			fechaEscopo();
			System.out.println("Fecha: " + escopos.size() + " - " + atual.getConteudo().toString());
		}
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
