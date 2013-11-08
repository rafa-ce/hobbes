package analise.semantica;

import static java.lang.Boolean.FALSE;

import java.util.List;

import analise.semantica.suporte.Variavel;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.suporte.No;

public abstract class AtributoSemantica {
	
	protected TabelaDeSimbolos tabela;
	protected No noAtual;
	protected No noAnterior;
	protected Boolean lendoFuncao = FALSE;
	protected List<Variavel> variaveis;
	
	public void andaNaArvore() {
		noAnterior = noAtual;
		noAtual = noAtual.proximoSemantico();
	}

	public List<Variavel> getVariaveis() {
		return variaveis;
	}

	public Variavel adicionaVariavel(String nome) {
		Variavel variavel = new Variavel(nome);
		variaveis.add(variavel);
		
		return variavel;
	}
	
	public Variavel pesquisaVariavel(String nome) {
		for (Variavel variavel : variaveis) {
			if (variavel.getNome().equals(nome))
				return variavel;
		}
		
		return null;
	}

}
