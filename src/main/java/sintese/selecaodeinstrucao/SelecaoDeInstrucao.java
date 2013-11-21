package sintese.selecaodeinstrucao;

import java.util.ArrayList;
import java.util.List;

import sintese.codigointermediario.CodigoIntemediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaBinop;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaCopy;

public class SelecaoDeInstrucao {
	
	private CodigoIntemediario ci;
	private List<Label> labels;

	public SelecaoDeInstrucao(CodigoIntemediario ci) {
		this.ci = ci;
		this.labels = new ArrayList<Label>();
	}
	
	public void executa() {
		adicionaLabel();
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				if (ri instanceof RepresentacaoIntermediariaBinOp)
					GeraCodigoDeMaquinaBinop.traduz((RepresentacaoIntermediariaBinOp) ri, labelAtual());
				
				if (ri instanceof RepresentacaoIntermediariaCopy)
					GeraCodigoDeMaquinaCopy.traduz((RepresentacaoIntermediariaCopy) ri, labelAtual());
			}
		}
	}
	
	private Label labelAtual() {
		return labels.get(labels.size() - 1);
	}
	
	protected void adicionaLabel() {
		labels.add(new Label("L" + Integer.toString(labels.size())));
	}
	
	public List<Label> getLabels() {
		return labels;
	}
}
