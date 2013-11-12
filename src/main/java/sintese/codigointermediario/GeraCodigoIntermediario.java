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
		this.temporarios = new ArrayList<Token>();
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
		trataTemporario((Token)no.getConteudo());
		instrucao.add((Token)no.getConteudo());
		no = no.proximoSemantico();
		no = no.proximoSemantico();
		
		while (!no.equals(marcador)) {
			
			if (no.isToken()) { 
				trataTemporario((Token)no.getConteudo());
				instrucao.add((Token)no.getConteudo());
			}
			
			no = no.proximoSemantico();	
		}
		
		criaInstrucao(instrucao);
		
	}

	private void trataTemporario(Token token) {
		if (token.isIdentificador())
			verificaTipo(token);
	}

	public void verificaTipo(Token token) {
		Token declarado;
		declarado = pesquisaNaListaDeTemporarios(token);
		
		if (declarado == null) {
			identificaTipoTemporario(token);
			temporarios.add(token);
		} else
			token.setTemporario(declarado.getTemporario());
	}

	public void identificaTipoTemporario(Token token) {
		if (token.isFuncao()) {
			token.setTemporario("f" + Integer.toString(temporarios.size()));
			return;
		}
		
		if (token.isVariavelDeEscape()) { 
			token.setTemporario("e" + Integer.toString(temporarios.size()));
			return;
		}
		
		token.setTemporario("t" + Integer.toString(temporarios.size()));
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
		return new RepresentacaoIntermediariaCopy(instrucao.get(0).getTemporario(), 
													instrucao.get(2).getValor());
	}

	private RepresentacaoIntermediariaBinOp criaBinOp(List<Token> instrucao) {
		return new RepresentacaoIntermediariaBinOp(instrucao.get(0).getTemporario(), 
													instrucao.get(3).getValor(), 
													instrucao.get(2).getTemporario(), 
													instrucao.get(4).getTemporario());
	}

}
