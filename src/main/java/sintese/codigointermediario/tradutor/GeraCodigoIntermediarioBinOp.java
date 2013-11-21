package sintese.codigointermediario.tradutor;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import analise.lexica.token.Token;

public class GeraCodigoIntermediarioBinOp {
	
	public static void trataBinOp(List<Token> instrucao, List<Token> temporarios, List<RepresentacaoIntermediaria> buffer) {
		instrucao = verificaOperacoesEntreParenteses(instrucao, temporarios, buffer);
		instrucao = realizaDivisaoMultiplicacao(instrucao, temporarios, buffer);
		instrucao = realizaSomaSubtracao(instrucao, temporarios, buffer);
		instrucao = realizaOperacoesLogicas(instrucao, temporarios, buffer);
		
		buffer.add(GeraCodigoIntermediarioCopy.criaCopy(instrucao));
	}
	
	private static List<Token> verificaOperacoesEntreParenteses(List<Token> instrucao, List<Token> temporarios, List<RepresentacaoIntermediaria> buffer) {
		List<Token> dentro = new ArrayList<Token>();
		Boolean par = Boolean.FALSE;
		
		while (!instrucao.isEmpty()) {
			Token token = instrucao.get(0);
			
			if (token.getValor().equals(")")) {
				instrucao.remove(0);
				par = Boolean.TRUE;
				break;
			}
			
			if (token.getValor().equals("(")) {
				List<Token> result = verificaOperacoesEntreParenteses(instrucao.subList(1, instrucao.size()), temporarios, buffer);
				dentro.add(result.get(0));
			}
			
			if (!token.getValor().equals("("))
				dentro.add(token);
			
			instrucao.remove(0);
			}
		
		if (par) {
			dentro.add(0, criaTemporario(temporarios));
			dentro.add(1, criaTokenAtribuicao());
			
			dentro = realizaDivisaoMultiplicacao(dentro, temporarios, buffer);
			dentro = realizaSomaSubtracao(dentro, temporarios, buffer);
			dentro = realizaOperacoesLogicas(dentro, temporarios, buffer);
			
			buffer.add(GeraCodigoIntermediarioCopy.criaCopy(dentro));
		}
				
		
		return dentro;
	}

	public static Token criaTokenAtribuicao() {
		Token tokenAtribuicao = new Token();
		tokenAtribuicao.setValor(":=");
		
		return tokenAtribuicao;
	}

	private static List<Token> realizaSomaSubtracao(List<Token> instrucao,	List<Token> temporarios, List<RepresentacaoIntermediaria> buffer) {
		return percorreInstrucoesDadoOperadores(instrucao, temporarios, buffer, "+", "-");	
	}

	private static List<Token> realizaDivisaoMultiplicacao(List<Token> instrucao, List<Token> temporarios, List<RepresentacaoIntermediaria> buffer) {
		return percorreInstrucoesDadoOperadores(instrucao, temporarios, buffer, "/", "*");			
	}
	
	private static List<Token> realizaOperacoesLogicas(List<Token> instrucao, List<Token> temporarios, List<RepresentacaoIntermediaria> buffer) {
		return percorreInstrucoesDadoOperadores(instrucao, temporarios, buffer, "<", ">");	
	}

	public static List<Token> percorreInstrucoesDadoOperadores(List<Token> instrucao, List<Token> temporarios, List<RepresentacaoIntermediaria> buffer, String op1, String op2) {
		Integer i = 0;
		
		while (instrucao.size() > 3 && i < instrucao.size()) {
			Token token = instrucao.get(i);
			if (token.getTipo() != null && token.isOperador() && (token.getValor().equals(op1) || token.getValor().equals(op2))) {
				List<Token> instrucaoAux = new ArrayList<Token>();
				
				Token tokenTemporario = criaTemporario(temporarios);
				
				instrucaoAux.add(tokenTemporario);
				instrucaoAux.add(null);
				instrucaoAux.add(instrucao.get(i - 1));
				instrucaoAux.add(instrucao.get(i));
				instrucaoAux.add(instrucao.get(i + 1));
				
				buffer.add(criaBinOp(instrucaoAux));
				
				instrucao.set(i, tokenTemporario);
				instrucao.remove(i + 1);
				instrucao.remove(i - 1);
				
				i--;
			}
			
			i++;
		}
				
		return instrucao;
	}

	public static Token criaTemporario(List<Token> temporarios) {
		Token tokenTemporario = new Token();
		temporarios.add(tokenTemporario);
		
		tokenTemporario.setTemporario("t" + Integer.toString(temporarios.size() - 1));
		tokenTemporario.setAtributosDoTemporario();
		return tokenTemporario;
	}

	private static RepresentacaoIntermediariaBinOp criaBinOp(List<Token> instrucao) {
		return new RepresentacaoIntermediariaBinOp(getPrintIntermediario(instrucao, 0), 
													getPrintIntermediario(instrucao, 3), 
													getPrintIntermediario(instrucao, 2), 
													getPrintIntermediario(instrucao, 4));
	}
	
	public static String getPrintIntermediario(List<Token> instrucao, Integer i) {
		Token token = instrucao.get(i);
		if (token.isIdentificador())
			return token.getTemporario();
		
		return token.getValor();
	}

}
