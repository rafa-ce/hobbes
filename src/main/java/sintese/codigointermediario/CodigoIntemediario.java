package sintese.codigointermediario;

import java.util.List;

import sintese.codigointermediario.suporte.Label;
import analise.lexica.token.Token;
import analise.sintatica.suporte.No;

public abstract class CodigoIntemediario {
	
	protected List<Label> labels;
	protected No noAtual;
	protected No noAnterior;
	protected List<Token> temporarios;
	protected Boolean criaLabel = Boolean.TRUE;
	
	public void andaNaArvore() {
		noAnterior = noAtual;
		noAtual = noAtual.proximoSemantico();
	}
	
	public List<Label> getLabels() {
		return labels;
	}

	public No getNo() {
		return noAtual;
	}
	
	protected boolean temFilhos() {
		return noAtual.getFilhos() != null;
	}
	
	protected void adicionaLabel() {
		if (criaLabel)
			labels.add(new Label("L" + Integer.toString(labels.size())));
		
		criaLabel = Boolean.TRUE;
	}
	
	protected Label labelAtual() {
		return labels.get(labels.size() - 1);
	}
	
	protected Token pesquisaNaListaDeTemporarios(Token token) {
		for (Token tokenDeclarado : temporarios) {
			if (tokenDeclarado.getValor().equals(token.getValor()) &&
					tokenDeclarado.getReferencia().equals(token.getReferencia()))
						return tokenDeclarado;
		}
		
		return null;
	}
	
}
