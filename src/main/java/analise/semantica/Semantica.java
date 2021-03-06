package analise.semantica;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;

import analise.lexica.token.Token;
import analise.semantica.suporte.Variavel;
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
		variaveis = new ArrayList<Variavel>();
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
			if (noAtual.isToken()) {
				if (((Token)noAtual.getConteudo()).getValor().equals("else")) {
					tabela.fechaEscopo();
					tabela.abreEscopo();
				}
				if (((Token)noAtual.getConteudo()).isIdentificador())
					trataToken((Token)noAtual.getConteudo());
			}
			
			andaNaArvore();
		}
	}

	private void trataToken(Token token) throws SemanticoException {
		Token tokenDeclarado = tabela.taNoUltimoEscopo(token);
		
		if (tokenDeclarado != null) {
			verificaParametrosFuncao(tokenDeclarado);
			verificaDimensoesVetor(tokenDeclarado);
			token.setReferencia(tokenDeclarado.getReferencia());
			return;
		}
		
		tokenDeclarado = tabela.possuiToken(token);
		
		if (tokenDeclarado != null) {
			verificaParametrosFuncao(tokenDeclarado);
			verificaDimensoesVetor(tokenDeclarado);
			token.marcaVariavellDeEscape();
			tokenDeclarado.marcaVariavellDeEscape();
			token.setReferencia(tokenDeclarado.getReferencia());
			return;
		}
		
		if (isFor(token))
			return;
		
		if (isAtribuicao(token)) {
			verificaTipoToken(token);
			verificaDeclaracaoVariavel(token);
			return;
		}
		
		if (noAtual.getPai().getConteudo().equals(FuncDec.codigo())) {
			tabela.adicionaToken(token);
			contaParametrosDeclaracaoFuncao();
			return;
		}
		
		throw new SemanticoException("Variável não inicializada: " + 
				token.getValor() + "("+ token.getPosicao().toString() + ")");
	}
	
	private void verificaDimensoesVetor(Token tokenDeclarado) throws SemanticoException {
		if(!tokenDeclarado.isVetor())
			return;
		
		if (tokenDeclarado.numeroDeDimensoes() == contaDimensoesChamadaVetor())
			return;
		
		throw new SemanticoException("Erro na dimensão do vetor");
	}

	private void verificaParametrosFuncao(Token tokenDeclarado) throws SemanticoException {
		if(!tokenDeclarado.isFuncao())
			return;
				
		if (tokenDeclarado.numeroDeParametros() == contaParametrosChamadaFuncao())
			return;
		
		throw new SemanticoException("Erro número de parâmetros");
	}
}
