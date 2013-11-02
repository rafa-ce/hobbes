package analise.semantica;

import static java.lang.Boolean.FALSE;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.suporte.No;

public abstract class AtributoSemantica {
	
	protected TabelaDeSimbolos tabela;
	protected No noAtual;
	protected No noAnterior;
	protected Boolean lendoFuncao = FALSE;
	
	public void andaNaArvore() {
		noAnterior = noAtual;
		noAtual = noAtual.proximoSemantico();
	}

}
