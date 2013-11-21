package sintese.selecaodeinstrucao.estrutura;

import java.util.HashMap;

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

	public static void traduz(RepresentacaoIntermediariaBinOp ri, Label label) {
		String instrucao = getInstrucaoDeMaquina(ri.getOperador());
		
		label.adicionaInstrucao(new GeraCodigoDeMaquinaBinop(instrucao, ri.getArq1(), ri.getArg2()));
		label.adicionaInstrucao(new GeraCodigoDeMaquinaCopy(ri.getArg2(), ri.getResult()));
	}
	
	private static String getInstrucaoDeMaquina(String operador) {
		HashMap<String, String> instrucoes = new HashMap<String, String>();
		
		instrucoes.put("+", "ADD");
		instrucoes.put("-", "SUB");
		instrucoes.put("*", "MUL");
		instrucoes.put("/", "DIV");
		
		return instrucoes.get(operador);
	}
	
	@Override
	public String toString() {
		return instrucao + " " + arg1 + " " + arg2;
	}

}
