package analise.semantica;

import utils.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.LValuePr;
import analise.sintatica.naoterminal.Prog;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;


public class Semantica {

	private TabelaDeSimbolos tabela;
	
	public Semantica() {
		tabela = new TabelaDeSimbolos();
	}
	
	public void executa() throws SemanticoException {
		
		tabela.defineEscopo(null, Arvore.getRaiz());
		
		No noAtual = Arvore.getRaiz().proximoSemantico();
		No noAnterior = Arvore.getRaiz();
		
		while (noAtual != null) {
			
			if (noAtual.getConteudo().equals(Prog.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);;
			
			if (noAtual.getConteudo().equals(Bloco.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);;
			
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador())
				trataToken((Token)noAtual.getConteudo(), noAnterior);
				
			
			noAnterior = noAtual;
			noAtual = noAtual.proximoSemantico();
		}
		System.out.println("");
	}

	private void trataToken(Token token, No pai) throws SemanticoException {
		if (tabela.taNoUltimoEscopo(token))
			return;
		
		//atribuição
		No irmao = pai.getFilhos().get(pai.getMarcador() + 1);
		if (irmao.getFilhos().isEmpty()) {
			if (!irmao.getConteudo().equals(LValuePr.codigo())) {		
				if (((Token)irmao.getConteudo()).getValor().equals(":=")) {
					tabela.adicionaToken(token);
					return;
				}
			}
		} else {
			Token conteudo = (Token) irmao.getFilhos().get(0).getConteudo();
			
			if (conteudo.getValor().equals(":=")) {
				tabela.adicionaToken(token);
				return;
			}
		}
		//fim atribuição
		
		if (tabela.possuiToken(token))
			return;
		
		throw new SemanticoException(token);
	}
}
