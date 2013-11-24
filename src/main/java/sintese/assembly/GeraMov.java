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
		if (ri.origem().equals("tmp3"))
			return;
		
		String destino = GeraAssembly.getRegistrador();
		GeraAssembly.alocaRegistrador(ri.destino(), destino);
		
		String origem = GeraAssembly.getRegistrador(ri.origem());
		
		if (origem == null)
			labelAtual.adicionaInstrucao(new GeraMov("$" + ri.origem(), destino));
		else
			labelAtual.adicionaInstrucao(new GeraMov(origem, destino));
	}
	
	@Override
	public String toString() {
		return "	movl " + origem + ", " + destino;
	}

}
