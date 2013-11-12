package sintese.codigointermediario;

import java.util.List;

import sintese.codigointermediario.suporte.Label;
import analise.lexica.token.Token;
import analise.sintatica.suporte.No;

public abstract class CodigoIntemediario {
	
	protected List<Label> labels;
	protected No no;
	protected List<Token> temporarios; 
	
	public List<Label> getLabels() {
		return labels;
	}

	public No getNo() {
		return no;
	}
	
	protected boolean temFilhos() {
		return no.getFilhos() != null;
	}
	
	protected void adicionaLabel() {
		labels.add(new Label("L" + Integer.toString(labels.size())));
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
