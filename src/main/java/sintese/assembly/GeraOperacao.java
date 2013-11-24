package sintese.assembly;

import java.util.HashMap;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaBinop;

public class GeraOperacao extends RepresentacaoIntermediaria {

	private String instrucao;
	private String arg1;
	private String arg2;
	
	public GeraOperacao(String instrucao, String arg1, String arg2) {
		this.instrucao = instrucao;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	public static void gera(GeraCodigoDeMaquinaBinop ri, Label labelAtual) {
		String instrucao = getInstrucaoAssembly(ri.getInstrucao());
		
		String registrador1 = GeraAssembly.getRegistrador(ri.arg1());
		String registrador2 = GeraAssembly.getRegistrador(ri.arg2());
		
		labelAtual.adicionaInstrucao(new GeraOperacao(instrucao, registrador1, registrador2));
		
		GeraAssembly.setGera(Boolean.FALSE);
	}
	
	private static String getInstrucaoAssembly(String operador) {
		HashMap<String, String> instrucoes = new HashMap<String, String>();
		
		instrucoes.put("ADD", "addl");
		instrucoes.put("SUB", "subl");
//		instrucoes.put("MUL");
//		instrucoes.put("DIV");
		
		return instrucoes.get(operador);
	}
	
	@Override
	public String toString() {
		return "	" + instrucao + " " + arg1 + ", " + arg2;
	}

}
