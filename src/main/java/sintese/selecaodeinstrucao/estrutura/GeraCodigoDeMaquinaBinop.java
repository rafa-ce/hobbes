package sintese.selecaodeinstrucao.estrutura;

import java.util.HashMap;
import java.util.List;

import analise.lexica.token.Token;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import sintese.codigointermediario.suporte.Label;

public class GeraCodigoDeMaquinaBinop extends RepresentacaoIntermediaria {

	private String instrucao;
	private String arg1;
	private String arg2;
	
	public GeraCodigoDeMaquinaBinop(String instrucao, String arg1, String arg2) {
		this.instrucao = instrucao;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public static void traduz(RepresentacaoIntermediariaBinOp ri, Label label, List<Token> temporarios) {
		String instrucao = getInstrucaoDeMaquina(ri.getOperador());
		
		String retorno = trataBinOp(ri, label, instrucao, temporarios);
		label.adicionaInstrucao(new GeraCodigoDeMaquinaMov(retorno, ri.getResult()));
	}

	public static String trataBinOp(RepresentacaoIntermediariaBinOp ri, Label label, String instrucao, List<Token> temporarios) {
		String retorno = ri.getArg2();
		
		if (isNumero(retorno)) {
			Token tokenTemporario = new Token();
			temporarios.add(tokenTemporario);
			
			tokenTemporario.setTemporario("tmp" + Integer.toString(temporarios.size() - 1));
			tokenTemporario.setAtributosDoTemporario();
			
			retorno = tokenTemporario.getValor();
			label.adicionaInstrucao(new GeraCodigoDeMaquinaMov(ri.getArg2(), retorno));
		}
			
		label.adicionaInstrucao(new GeraCodigoDeMaquinaBinop(instrucao, ri.getArq1(), retorno));
		
		return retorno;
	}
	
	private static String getInstrucaoDeMaquina(String operador) {
		HashMap<String, String> instrucoes = new HashMap<String, String>();
		
		instrucoes.put("+", "ADD");
		instrucoes.put("-", "SUB");
		instrucoes.put("*", "MUL");
		instrucoes.put("/", "DIV");
		instrucoes.put(">", "CMP");
		instrucoes.put("<", "CMP");
		instrucoes.put("=", "CMP");
		instrucoes.put("<>", "CMP");
		
		return instrucoes.get(operador);
	}
	
	@Override
	public String toString() {
		return instrucao + " " + arg1 + ", " + arg2;
	}
	
	public static Boolean isNumero(String valor) {  
	    return valor.matches("[0-9]*");  
	}
	
	public String getInstrucao() {
		return instrucao;
	}
	
	public String arg1() {
		return arg1;
	}
	
	public String arg2() {
		return arg2;
	}
}
