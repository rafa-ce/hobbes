package analise.sintatica.suporte;

import java.util.ArrayList;
import java.util.List;

import analise.sintatica.naoterminal.Prog;
import utils.Token;

public class No {
	
	private static No raiz;
	
	private Object conteudo;
	private No pai;
	private List<No> filhos;
	private Integer marcador = -1;
	private Boolean escape;
	
	private No(Object conteudo, No pai, List<No> filhos) {
		this.conteudo = conteudo;
		this.pai = pai;
		this.filhos = filhos;
	}
	
	public static void criaRaiz() {
		raiz = criaNo(Prog.codigo(), null, new ArrayList<No>());
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
			if (pai == null)
				return null;
			
			return pai.proximo();
		}
		
		incrementaMarcador();
		return filhos.get(marcador);
	}

	public Integer filhoAtual() {
		return marcador;
	}
	
	public List<No> getFilhos() {
		return filhos;
	}

	public No getPai() {
		return pai;
	}

	public Boolean getEscape() {
		return escape;
	}

	public void setEscape(Boolean escape) {
		this.escape = escape;
	}
	
	public String printConteudo() {
		if (conteudo instanceof Token)
			return ((Token)conteudo).getValor();
		
		return conteudo.toString();
	}

	public Token getConteudo() {
		return (Token) conteudo;
	}

	public Boolean isToken() {
		return conteudo instanceof Token;
	}

	private void incrementaMarcador() {
		marcador++;
	}

	public static No getRaiz() {
		return raiz;
	}
	
	public void printArvore() {
		No no = raiz;
		
		while (no != null) {
			System.out.println(no.printConteudo());
			
			no = no.proximo();
		}
	}

	public static void finalizaArvore(No no) {
		while (no != null)  {
			no = no.proximo();
		}
	}
}
