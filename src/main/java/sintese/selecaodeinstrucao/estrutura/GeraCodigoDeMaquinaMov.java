package sintese.selecaodeinstrucao.estrutura;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import sintese.codigointermediario.suporte.Label;

public class GeraCodigoDeMaquinaMov extends RepresentacaoIntermediaria {
	
	private String destino;
	private String origem;
	
	public GeraCodigoDeMaquinaMov(String origem, String destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public static void traduz(RepresentacaoIntermediariaCopy ri, Label label) {
		label.adicionaInstrucao(new GeraCodigoDeMaquinaMov(ri.getOrigem(), ri.getDestino()));
	}
	
	@Override
	public String toString() {
		return "MOV" + " " + origem + ", " + destino;
	}
	
	public String destino() {
		return destino;
	}
	
	public String origem() {
		return origem;
	}
}
