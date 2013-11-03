package analise.semantica;

import static java.lang.Boolean.FALSE;
import utils.token.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.FuncDec;
import analise.sintatica.naoterminal.Prog;
import analise.sintatica.suporte.Arvore;


public class Semantica extends RegraSemantica {

	public Semantica() {
		tabela = new TabelaDeSimbolos();
		noAtual = Arvore.getRaiz().proximoSemantico();
		noAnterior = Arvore.getRaiz();
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
				trataToken((Token)noAtual.getConteudo());
			
			andaNaArvore();
		}
	}

	private void trataToken(Token token) throws SemanticoException {
		Token tokenDeclarado = tabela.taNoUltimoEscopo(token);
		
		if (tokenDeclarado != null) {
			verificaParametrosFuncao(tokenDeclarado);
			return;
		}
		
		tokenDeclarado = tabela.possuiToken(token);
		
		if (tokenDeclarado != null) {
			verificaParametrosFuncao(tokenDeclarado);
			token.marcaVariavellDeEscape();
			tokenDeclarado.marcaVariavellDeEscape();
			return;
		}
		
		if (isFor(token))
			return;
		
		if (isAtribuicao(token))
			return;
		
		if (noAtual.getPai().getConteudo().equals(FuncDec.codigo())) {
			tabela.adicionaToken(token);
			contaParametrosDeclaracaoFuncao();
			return;
		}
		
		throw new SemanticoException(token);
	}
	
	private void verificaParametrosFuncao(Token tokenDeclarado) throws SemanticoException {
		if(!tokenDeclarado.isFuncao())
			return;
				
		if (tokenDeclarado.numeroDeParametros() == contaParametrosChamadaFuncao())
			return;
		
		throw new SemanticoException(tokenDeclarado); //numero de param errados
	}
}
