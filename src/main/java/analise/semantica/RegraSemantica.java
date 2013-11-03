package analise.semantica;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import utils.token.Token;
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
					return TRUE;
				}
		
		return FALSE;
	}
	
	protected void contaParametrosDeclaracaoFuncao() {
		tabela.abreEscopo();
		lendoFuncao = TRUE;
		Token tokenFuncao = (Token)noAtual.getConteudo();
		tokenFuncao.adicionaParametro();
		andaNaArvore();
		
		while (true) {
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador()) {
				Token token = (Token)noAtual.getConteudo();
				tabela.adicionaToken(token);
				tokenFuncao.adicionaParametro();
			}
			
			andaNaArvore();
			
			if(noAtual.isToken() && ((Token)noAtual.getConteudo()).getValor().equals(")"))
				break;
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
}
