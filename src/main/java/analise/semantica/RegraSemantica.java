package analise.semantica;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import utils.Token;
import analise.sintatica.naoterminal.LValuePr;
import analise.sintatica.suporte.No;

public abstract class RegraSemantica extends AtributoSemantica {
	
	public Boolean verificaAtribuicao(No pai, Token token) {
		
		No irmao = pai.getFilhos().get(pai.getMarcador() + 1);
		if (irmao.getFilhos().isEmpty()) {
			if (!irmao.getConteudo().equals(LValuePr.codigo())) {		
				if (((Token)irmao.getConteudo()).getValor().equals(":=")) {
					tabela.adicionaToken(token);
					return TRUE;
				}
			}
		} else {
			Token conteudo = (Token) irmao.getFilhos().get(0).getConteudo();
			
			if (conteudo.getValor().equals(":=")) {
				tabela.adicionaToken(token);
				return TRUE;
			}
		}
		
		return FALSE;
	}
	
	public void verificaParametrosFuncao() {
		tabela.abreEscopo();
		lendoFuncao = TRUE;
		
		andaNaArvore();
		
		while (true) {
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).isIdentificador()) {
				tabela.adicionaToken(((Token)noAtual.getConteudo()));
				System.out.println(((Token)noAtual.getConteudo()).getValor());
			}
			
			andaNaArvore();
			
			if(noAtual.isToken() && ((Token)noAtual.getConteudo()).getValor().equals(")"))
				break;
		}		
	}
	
	public void andaNaArvore() {
		noAnterior = noAtual;
		noAtual = noAtual.proximoSemantico();
	}
}
