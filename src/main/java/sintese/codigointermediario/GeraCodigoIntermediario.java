package sintese.codigointermediario;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import sintese.codigointermediario.suporte.Label;
import analise.lexica.token.Token;
import analise.sintatica.naoterminal.LValue;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;

public class GeraCodigoIntermediario extends CodigoIntemediario {
	
	public GeraCodigoIntermediario() {
		this.labels = new ArrayList<Label>();
		this.no = Arvore.getRaiz();
	}

	public void executa() {
		
		adicionaLabel();
		
		while (no != null)  {
			
			if (no.getConteudo().equals(LValue.codigo()))
				trataLValue();
			
			no = no.proximoSemantico();
		}
	}

	private void trataLValue() {
		No marcador = no;
		
		List<Token> instrucao = new ArrayList<Token>();
		
		no = no.proximoSemantico();
		instrucao.add((Token)no.getConteudo());
		no = no.proximoSemantico();
		no = no.proximoSemantico();
		
		while (!no.equals(marcador)) {
			
			if (no.isToken())
				instrucao.add((Token)no.getConteudo());
			
			no = no.proximoSemantico();	
		}
		
		criaInstrucao(instrucao);
		
	}

	private void criaInstrucao(List<Token> instrucao) {
		Boolean binOp = FALSE;
		
		for (Token token : instrucao) {
			if (token.isOperador() && !token.getValor().equals(":=")) {
				binOp = Boolean.TRUE;
				break;
			}
		}
		
		if (binOp)
			labels.get(0).adicionaInstrucao(criaBinOp(instrucao));
		else
			labels.get(0).adicionaInstrucao(criaCopy(instrucao));
		
		binOp = FALSE;
	}

	private RepresentacaoIntermediariaCopy criaCopy(List<Token> instrucao) {
		return new RepresentacaoIntermediariaCopy(instrucao.get(0).getValor(), instrucao.get(2).getValor());
	}

	private RepresentacaoIntermediariaBinOp criaBinOp(List<Token> instrucao) {
		return new RepresentacaoIntermediariaBinOp(instrucao.get(0).getValor(), 
													instrucao.get(3).getValor(), 
													instrucao.get(2).getValor(), 
													instrucao.get(4).getValor());
	}

}
