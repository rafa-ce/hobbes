package sintese.codigointermediario;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.codigointermediario.tradutor.GeraCodigoIntermediarioBinOp;
import sintese.codigointermediario.tradutor.GeraCodigoIntermediarioCopy;
import sintese.codigointermediario.tradutor.GeraCodigoIntermediarioJump;
import analise.lexica.token.Token;
import analise.sintatica.naoterminal.Bloco;
import analise.sintatica.naoterminal.LValue;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;

public class GeraCodigoIntermediario extends CodigoIntemediario {
	
	public GeraCodigoIntermediario() {
		this.labels = new ArrayList<Label>();
		this.noAtual = Arvore.getRaiz();
		this.temporarios = new ArrayList<Token>();
	}

	public void executa() {
		
		List<RepresentacaoIntermediaria> buffer = new ArrayList<RepresentacaoIntermediaria>();
		
		adicionaLabel();
		
		while (noAtual != null)  {
			
			if (noAtual.getConteudo().equals(Bloco.codigo())) {
				if (noAnterior.equals(noAtual.getPai()))
					trataBloco();
				else
					return;				
			}
			
			if (noAtual.getConteudo().equals(LValue.codigo()))
				trataLValue();
			
			andaNaArvore();
		}
	}

	private void trataBloco() {
		No filho = noAtual.getFilhos().get(0);
		No neto = filho.getFilhos().get(0);
		
		if (((Token)neto.getConteudo()).getValor().equals("if"))
			GeraCodigoIntermediarioJump.geraJump(Integer.toString(labels.size()), labelAtual());
			
//		if (((Token)neto.getConteudo()).getValor().equals("for"))
//			
//		if (((Token)neto.getConteudo()).getValor().equals("while"))
		
		andaNaArvore();
		executa();
	}

	private void trataLValue() {
		No marcador = noAtual;
		
		List<Token> instrucao = new ArrayList<Token>();
		
		andaNaArvore();
		trataTemporario((Token)noAtual.getConteudo());
		instrucao.add((Token)noAtual.getConteudo());
		andaNaArvore();
		andaNaArvore();
		
		if (noAtual.getFilhos().isEmpty())
			instrucao = trataIfWhile(instrucao);
		else
			instrucao = trataAtribuicao(marcador, instrucao);
		
		criaInstrucao(instrucao);
		
	}

	public List<Token> trataAtribuicao(No marcador, List<Token> instrucao) {
		while (!noAtual.equals(marcador)) {
			
			if (noAtual.isToken()) { 
				trataTemporario((Token)noAtual.getConteudo());
				instrucao.add((Token)noAtual.getConteudo());
			}
			
			andaNaArvore();	
		}
		
		return instrucao;
	}

	private List<Token> trataIfWhile(List<Token> instrucao) {
		Token tokenTemporario = new Token();
		temporarios.add(tokenTemporario);
		
		tokenTemporario.setTemporario("t" + Integer.toString(temporarios.size() - 1));
		tokenTemporario.setAtributosDoTemporario();
		
		List<Token> resultado = new ArrayList<Token>();
		
		resultado.add(tokenTemporario);
		
		Token tokenAtribuicao = new Token();
		tokenAtribuicao.setValor(":=");
		
		resultado.add(tokenAtribuicao);
		resultado.add(instrucao.get(0));
		
		while (true) {
			
			if (noAtual.isToken() && ((Token)noAtual.getConteudo()).getValor().equals("then"))
				break;
				
			if (noAtual.isToken()) { 
				trataTemporario((Token)noAtual.getConteudo());
				resultado.add((Token)noAtual.getConteudo());
			}
			
			andaNaArvore();		
		}
		
		return resultado;
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
			if (token.getTipo() != null && token.isOperador() && !token.getValor().equals(":=")) {
				binOp = Boolean.TRUE;
				break;
			}
		}
		
		if (binOp)
			GeraCodigoIntermediarioBinOp.trataBinOp(instrucao, temporarios, labelAtual());
		else
			labelAtual().adicionaInstrucao(GeraCodigoIntermediarioCopy.criaCopy(instrucao));
		
		binOp = FALSE;
	}
}
