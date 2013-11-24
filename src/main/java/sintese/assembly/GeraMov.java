package sintese.assembly;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaMov;

public class GeraMov extends RepresentacaoIntermediaria {

	private String destino;
	private String origem;
	
	public GeraMov(String origem, String destino) {
		this.destino = destino;
		this.origem = origem;
	}

	public static void gera(GeraCodigoDeMaquinaMov ri, Label labelAtual) {
		String registrador = GeraAssembly.getRegistrador();
		GeraAssembly.alocaRegistrador(ri.destino(), registrador);
		
		labelAtual.adicionaInstrucao(new GeraMov(ri.origem(), registrador));
	}
	
	@Override
	public String toString() {
		return "	movl $" + origem + ", " + destino;
	}

}
