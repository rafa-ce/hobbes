package analise.sintatica.arvore;

import java.util.ArrayList;
import java.util.List;

import utils.Token;

public class No {
	
	private Object conteudo;
	private No pai;
	private List<No> filhos;
	private Integer marcador = -1;
	
	private No(Object conteudo, No pai, List<No> filhos) {
		this.conteudo = conteudo;
		this.pai = pai;
		this.filhos = filhos;
	}
	
	public static No criaNo(Object conteudo, No pai, List<No> filhos) {
		return new No(conteudo, pai, filhos);
	}
	
	public void criaFilhos(List<String> filhos) {
		for (String filho : filhos) {
			this.filhos.add(criaNo(filho, this, new ArrayList<No>()));
		}
		
	}
	
	public void trocaConteudo(Token token) {
		conteudo = token;
	}
	
	public No proximo() {
		if (filhos.size() == filhoAtual() + 1) {
			marcador = -1;
			pai.incrementaMarcador();
			pai.proximo();
		}
		
		incrementaMarcador();
		return filhos.get(marcador);
	}

	public List<No> getFilhos() {
		return filhos;
	}

	public Integer filhoAtual() {
		return marcador;
	}
	
	private void incrementaMarcador() {
		marcador++;
	}
	
	public String printConteudo() {
		if (conteudo instanceof Token)
			return ((Token)conteudo).getValor();
		
		return conteudo.toString();
	}
	
}
