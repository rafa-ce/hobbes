package sintese.selecaodeinstrucao;

import java.util.ArrayList;
import java.util.List;

import analise.lexica.token.Token;
import sintese.codigointermediario.CodigoIntemediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaBinOp;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCJump;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaBinop;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaCJump;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaCopy;

public class SelecaoDeInstrucao {
	
	private CodigoIntemediario ci;
	private List<Label> labels;
	private List<Token> temporarios;

	public SelecaoDeInstrucao(CodigoIntemediario ci) {
		this.ci = ci;
		this.labels = new ArrayList<Label>();
		this.temporarios = ci.getTemporarios();
	}
	
	public void executa() {
		
		for (Label label : ci.getLabels()) {
			adicionaLabel();
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				if (ri instanceof RepresentacaoIntermediariaBinOp)
					GeraCodigoDeMaquinaBinop.traduz((RepresentacaoIntermediariaBinOp) ri, labelAtual(), temporarios);
				
				if (ri instanceof RepresentacaoIntermediariaCopy)
					GeraCodigoDeMaquinaCopy.traduz((RepresentacaoIntermediariaCopy) ri, labelAtual());
				
				if (ri instanceof RepresentacaoIntermediariaCJump)
					GeraCodigoDeMaquinaCJump.traduz((RepresentacaoIntermediariaCJump) ri, labelAtual());
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
	
	public List<Token> getTemporarios() {
		return temporarios;
	}
	
}
