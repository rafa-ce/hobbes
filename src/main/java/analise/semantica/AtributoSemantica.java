package analise.semantica;

import static java.lang.Boolean.FALSE;

import java.util.List;

import utils.Token;
import analise.semantica.suporte.TabelaDeSimbolos;
import analise.sintatica.suporte.No;

public abstract class AtributoSemantica {
	
	protected TabelaDeSimbolos tabela;
	protected List<Token> arrays; 
	protected No noAtual;
	protected No noAnterior;
	protected Boolean lendoFuncao = FALSE;

}
