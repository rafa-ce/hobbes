package sintese.selecaodeinstrucao.estrutura;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import sintese.codigointermediario.suporte.Label;

public class GeraCodigoDeMaquinaCopy extends RepresentacaoIntermediaria {
	
	private String destino;
	private String origem;
	
	public GeraCodigoDeMaquinaCopy(String origem, String destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public static void traduz(RepresentacaoIntermediariaCopy ri, Label label) {
		label.adicionaInstrucao(new GeraCodigoDeMaquinaCopy(ri.getOrigem(), ri.getDestino()));
	}
	
	@Override
	public String toString() {
		return "MOV" + " " + origem + ", " + destino;
	}
}
