package analise.semantica;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;

import utils.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.FuncCorpo;
import analise.sintatica.naoterminal.FuncDec;
import analise.sintatica.naoterminal.LValuePr;
import analise.sintatica.naoterminal.Prog;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;


public class Semantica {

	private TabelaDeSimbolos tabela;
	private List<Token> arrays; 
	private No noAtual;
	private No noAnterior;
	private Boolean lendoFuncao = FALSE;
	
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
		
		if (noAtual.getPai().getConteudo().equals(FuncDec.codigo())) {
			tabela.adicionaToken(token);
			verificaParametrosFuncao();
			return;
		}
		
		throw new SemanticoException(token);
	}

	private void verificaParametrosFuncao() {
		tabela.abreEscopo();
		lendoFuncao = TRUE;
		
		noAnterior = noAtual;
		noAtual = noAtual.proximoSemantico();
		
		while (true) {
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador()) {
				tabela.adicionaToken(((Token)noAtual.getConteudo()));
				System.out.println(((Token)noAtual.getConteudo()).getValor());
			}
			
			noAnterior = noAtual;
			noAtual = noAtual.proximoSemantico();
			
			if(noAtual.isToken() && ((Token)noAtual.getConteudo()).getValor().equals(")"))
				break;
		}
	}
}
