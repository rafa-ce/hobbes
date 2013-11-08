package analise.semantica;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import utils.token.Token;
import analise.semantica.suporte.Variavel;
import analise.sintatica.naoterminal.ArrayDec;
import analise.sintatica.naoterminal.Factor;
import analise.sintatica.naoterminal.LValuePr;
import analise.sintatica.suporte.No;

public abstract class RegraSemantica extends AtributoSemantica {
	
	protected Boolean isAtribuicao(Token token) {
		No irmao = noAnterior.getFilhos().get(noAnterior.getMarcador() + 1);
		
		if (irmao.getFilhos().isEmpty())
			return FALSE;
		
		Token conteudo = (Token) irmao.getFilhos().get(0).getConteudo();
			
		if (conteudo.getValor().equals(":=")) {
			tabela.adicionaToken(token);
			return TRUE;
		}
		
		return FALSE;
	}
	
	protected Boolean isFor(Token token) {
		No irmao = noAnterior.getFilhos().get(noAnterior.getMarcador() + 1);
		
		if (irmao.getFilhos().isEmpty())
			if (!irmao.getConteudo().equals(LValuePr.codigo()))		
				if (((Token)irmao.getConteudo()).getValor().equals(":=")) {
					tabela.adicionaToken(token);
					verificaDeclaracaoVariavel(token);
					return TRUE;
				}
		
		return FALSE;
	}
	
	protected void verificaDeclaracaoVariavel(Token token) {
		Variavel variavel = pesquisaVariavel(token.getValor());
		
		if (variavel == null) {
			variavel = adicionaVariavel(token.getValor());
		} else
			variavel.incrementaContador();
		
		token.setReferencia(variavel.toString());		
	}

	protected void contaParametrosDeclaracaoFuncao() {
		tabela.abreEscopo();
		lendoFuncao = TRUE;
		Token tokenFuncao = (Token)noAtual.getConteudo();
		tokenFuncao.adicionaParametro();
		andaNaArvore();
		
		while (true) {
			if(noAtual.isToken() && ((Token)noAtual.getConteudo()).getValor().equals(")"))
				break;
			
			if(noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador()) {
				Token token = (Token)noAtual.getConteudo();
				tabela.adicionaToken(token);
				tokenFuncao.adicionaParametro();
				verificaDeclaracaoVariavel(token);
			}
							
			andaNaArvore();
		}		
	}
	
	protected Integer contaParametrosChamadaFuncao() {
		Integer parametros = 0;
		No irmao = noAnterior.getFilhos().get(noAnterior.getMarcador() + 1);
		
		No argList = irmao.getFilhos().get(1);
		
		if (argList.getFilhos().isEmpty())
			return parametros;
		
		No no = argList.getFilhos().get(1);
		
		while(true) {
			parametros++;
			
			if (no.getFilhos().isEmpty())
				break;
			
			no = no.getFilhos().get(2);
		}
		
		return parametros;
	}
	
	protected void verificaTipoToken(Token token) {
		while(true) {
			if (noAtual.getConteudo().equals(Factor.codigo())) {
				defineTipo(token);
				break;
			}
			
			andaNaArvore();
		}
	}

	private void defineTipo(Token token) {
		No proximo = noAtual.getFilhos().get(0);
		
		if (proximo.getConteudo().equals(ArrayDec.codigo()))
			token.inicializaVetor(contaDimensoes(proximo));
		
	}

	private Integer contaDimensoes(No no) {
		Integer dimensoes = 0;
		
		while(true) {
			dimensoes++;
			
			if (no.getFilhos().isEmpty())
				break;
			
			no = no.getFilhos().get(2);
		}
		
		return dimensoes;
	}
	
	protected Integer contaDimensoesChamadaVetor() {
		Integer dimensoes = 0;
		
		No irmao = noAnterior.getFilhos().get(noAnterior.getMarcador() + 1);
		
		if (irmao.getFilhos().isEmpty())
			return dimensoes;
		
		No outro = irmao.getFilhos().get(3);
		dimensoes++;
		
		if (outro.getFilhos().isEmpty() || ((Token)outro.getFilhos().get(0).getConteudo()).getValor().equals(":="))
			return dimensoes;
		
		No no = outro.getFilhos().get(3);
		
		while(true) {
			dimensoes++;
			
			if (no.getFilhos().isEmpty() || ((Token)no.getFilhos().get(0).getConteudo()).getValor().equals(":="))
				break;
			
			no = no.getFilhos().get(3);
		}
		
		return dimensoes;
	}
}
