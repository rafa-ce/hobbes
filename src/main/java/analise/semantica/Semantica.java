package analise.semantica;

import utils.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.Prog;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;


public class Semantica {

	private TabelaDeSimbolos tabela;
	
	public Semantica() {
		tabela = new TabelaDeSimbolos();
	}
	
	public void executa() {
		
		tabela.defineEscopo(null, Arvore.getRaiz());
		
		No noAtual = Arvore.getRaiz().proximoSemantico();
		No noAnterior = Arvore.getRaiz();
		
		while (noAtual != null) {
			
			if (noAtual.getConteudo().equals(Prog.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);;
			
			if (noAtual.getConteudo().equals(Bloco.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);;
			
			if (noAtual.isToken())
				tabela.adicionaToken((Token)noAtual.getConteudo());
			
			noAnterior = noAtual;
			noAtual = noAtual.proximoSemantico();
		}
		System.out.println("");
	}
}
