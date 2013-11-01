package analise.semantica;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;

import utils.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.FuncDec;
import analise.sintatica.naoterminal.Prog;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;


public class Semantica extends RegraSemantica {

	public Semantica() {
		tabela = new TabelaDeSimbolos();
		noAtual = Arvore.getRaiz().proximoSemantico();
		noAnterior = Arvore.getRaiz();
		arrays = new ArrayList<Token>();
	}
	
	public void executa() throws SemanticoException {
		
		tabela.defineEscopo(null, Arvore.getRaiz());
		
		while (noAtual != null) {
			
			if (noAtual.getConteudo().equals(Prog.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);
			
			if (noAtual.getConteudo().equals(Bloco.codigo()))
				tabela.defineEscopo(noAnterior, noAtual);
				
			if (noAtual.getConteudo().equals(FuncDec.codigo()) && lendoFuncao) {
				tabela.defineEscopo(noAnterior, noAtual);
				lendoFuncao = FALSE;
			}
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador())
				trataToken((Token)noAtual.getConteudo(), noAnterior);
			
			andaNaArvore();
		}
		System.out.println("");
	}

	private void trataToken(Token token, No pai) throws SemanticoException {
		if (tabela.taNoUltimoEscopo(token))
			return;
		
		if (tabela.possuiToken(token))
			return;
		
		if (verificaAtribuicao(pai, token))
			return;
		
		if (noAtual.getPai().getConteudo().equals(FuncDec.codigo())) {
			tabela.adicionaToken(token);
			verificaParametrosFuncao();
			return;
		}
		
		throw new SemanticoException(token);
	}
}
