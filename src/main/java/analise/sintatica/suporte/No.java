package analise.sintatica.suporte;

import java.util.ArrayList;
import java.util.List;

import utils.Token;

public class No {
	
	private Object conteudo;
	private No pai;
	private List<No> filhos;
	private Integer marcador = -1;
	private Integer profundidade;
	
	private No(Object conteudo, No pai, List<No> filhos, Integer profundidade) {
		this.conteudo = conteudo;
		this.pai = pai;
		this.filhos = filhos;
		this.profundidade = profundidade; 
	}
	
	public static No criaNo(Object conteudo, No pai, List<No> filhos, Integer profundidade) {
		return new No(conteudo, pai, filhos, profundidade);
	}
	
	public void criaFilhos(List<String> filhos) {
		if (filhos.get(0).equals("ε"))
			return;
		
		for (String filho : filhos) {
			this.filhos.add(criaNo(filho, this, new ArrayList<No>(), getProfundidade() + 1));
		}
	}
	
	public No proximo() {
		if (filhos.size() == filhoAtual() + 1) {
			marcador = -1;
			if (pai == null)
				return null;
			
			return pai.proximo();
		}
		
		incrementaMarcador();
		return filhos.get(marcador);
	}

	public Boolean isToken() {
		return conteudo instanceof Token;
	}

	public String printConteudo() {
		if (conteudo instanceof Token)
			return ((Token)conteudo).getValor();
		
		return conteudo.toString();
	}

	public No getPai() {
		return pai;
	}

	public List<No> getFilhos() {
		return filhos;
	}

	public Integer filhoAtual() {
		return marcador;
	}

	public Object getConteudo() {
		return conteudo;
	}

	public void trocaConteudo(Token token) {
		conteudo = token;
	}

	public Integer getProfundidade() {
		return profundidade;
	}

	private void incrementaMarcador() {
		marcador++;
	}
	
	public No proximoSemantico() {
		if (filhos.size() == filhoAtual() + 1) {
			marcador = -1;
			if (pai == null)
				return null;
			
			return pai;
		}
		
		incrementaMarcador();
		return filhos.get(marcador);
	}
}
