package sintese.codigointermediario.suporte;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;

public class Label {
	
	private String nome;
	private List<RepresentacaoIntermediaria> instrucoes;
	
	public Label(String nome) {
		this.nome = nome;
		instrucoes = new ArrayList<RepresentacaoIntermediaria>();
	}
	
	public void adicionaInstrucao(RepresentacaoIntermediaria instrucao) {
		instrucoes.add(instrucao);
	}
	
	public List<RepresentacaoIntermediaria> getInstrucoes() {
		return instrucoes;
	}

}
