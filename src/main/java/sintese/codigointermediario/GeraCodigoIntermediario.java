package sintese.codigointermediario;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.suporte.Label;
import sintese.codigointermediario.tradutor.GeraCodigoIntermediarioBinOp;
import sintese.codigointermediario.tradutor.GeraCodigoIntermediarioCopy;
import analise.lexica.token.Token;
import analise.sintatica.naoterminal.Bloco;
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
			
//			if (no.getConteudo().equals(Bloco.codigo()))
//				executa();
			
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
			GeraCodigoIntermediarioBinOp.trataBinOp(instrucao, temporarios, labels.get(0));
		else
			labels.get(0).adicionaInstrucao(GeraCodigoIntermediarioCopy.criaCopy(instrucao));
		
		binOp = FALSE;
	}
}
