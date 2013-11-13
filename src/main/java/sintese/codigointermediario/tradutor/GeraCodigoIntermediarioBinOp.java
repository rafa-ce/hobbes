package sintese.codigointermediario.tradutor;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import sintese.codigointermediario.suporte.Label;
import analise.lexica.token.Token;

public class GeraCodigoIntermediarioBinOp {
	
	public static void trataBinOp(List<Token> instrucao, List<Token> temporarios, Label label) {
//		instrucao = verificaOperacoesEntreParenteses(instrucao, temporarios, label);
		instrucao = realizaDivisaoMultiplicacao(instrucao, temporarios, label);
		instrucao = realizaSomaSubtracao(instrucao, temporarios, label);
		label.adicionaInstrucao(criaBinOp(instrucao));
	}
	
	private static List<Token> verificaOperacoesEntreParenteses(List<Token> instrucao, List<Token> temporarios, Label label) {
		Integer i = 0;
		List<Token> dentro = new ArrayList<Token>();
		
		while (i < instrucao.size()) {
			Token token = instrucao.get(i);
			
			if (token.getValor().equals(")"))
				break;
			
			if (token.getValor().equals("("))
				verificaOperacoesEntreParenteses(instrucao.subList(i + 1, instrucao.size()), temporarios, label);				
			
			dentro.add(token);
			
			i++;
		}
		
		dentro = realizaDivisaoMultiplicacao(dentro, temporarios, label);
		dentro = realizaSomaSubtracao(dentro, temporarios, label);
			
		return instrucao;
	}

	private static List<Token> realizaSomaSubtracao(List<Token> instrucao,	List<Token> temporarios, Label label) {
		return percorreInstrucoesDadoOperadores(instrucao, temporarios, label, "+", "-");	
	}

	private static List<Token> realizaDivisaoMultiplicacao(List<Token> instrucao, List<Token> temporarios, Label label) {
		return percorreInstrucoesDadoOperadores(instrucao, temporarios, label, "/", "*");			
	}

	public static List<Token> percorreInstrucoesDadoOperadores(List<Token> instrucao, List<Token> temporarios, Label label, String op1, String op2) {
		Integer i = 0;
		
		while (instrucao.size() > 5 && i < instrucao.size()) {
			Token token = instrucao.get(i);
			if (token.isOperador() && (token.getValor().equals(op1) || token.getValor().equals(op2))) {
				List<Token> instrucaoAux = new ArrayList<Token>();
				
				Token tokenTemporario = new Token();
				temporarios.add(tokenTemporario);
				
				tokenTemporario.setTemporario("t" + Integer.toString(temporarios.size()));
				tokenTemporario.setAtributosDoTemporario();
				instrucaoAux.add(tokenTemporario);
				instrucaoAux.add(null);
				instrucaoAux.add(instrucao.get(i - 1));
				instrucaoAux.add(instrucao.get(i));
				instrucaoAux.add(instrucao.get(i + 1));
				
				label.adicionaInstrucao(criaBinOp(instrucaoAux));
				
				instrucao.set(i, tokenTemporario);
				instrucao.remove(i + 1);
				instrucao.remove(i - 1);
				
				i--;
			}
			
			i++;
		}
				
		return instrucao;
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
