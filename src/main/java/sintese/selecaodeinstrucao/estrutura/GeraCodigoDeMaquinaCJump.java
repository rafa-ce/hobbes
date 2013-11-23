package sintese.selecaodeinstrucao.estrutura;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCJump;
import sintese.codigointermediario.suporte.Label;

public class GeraCodigoDeMaquinaCJump extends RepresentacaoIntermediaria{

	private String lugar;
	
	public GeraCodigoDeMaquinaCJump(String lugar) {
		this.lugar = lugar;
	}

	public static void traduz(RepresentacaoIntermediariaCJump ri, Label labelAtual) {
		labelAtual.adicionaInstrucao(new GeraCodigoDeMaquinaCJump(ri.getLugar()));
	}
	
	@Override
	public String toString() {
		return "JNZ " + lugar;
	}

}
