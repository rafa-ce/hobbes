package sintese.assembly;

import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import analise.lexica.token.Token;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.SelecaoDeInstrucao;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaBinop;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaCJump;
import sintese.selecaodeinstrucao.estrutura.GeraCodigoDeMaquinaMov;

public class GeraAssembly {
	
	private List<Label> labels;
	private SelecaoDeInstrucao si;
	private static Boolean gera = TRUE;
	private static List<String> registradoresLivres;
	private static Map<String, String> registradoresOcupados;
	
	public GeraAssembly(SelecaoDeInstrucao si) {
		this.si = si;
		this.labels = new ArrayList<Label>();
		carregaRegistradores();
	}
	
	private void carregaRegistradores() {
		registradoresLivres = new ArrayList<String>();
		registradoresLivres.add("%eax");
		registradoresLivres.add("%ebx");
		registradoresLivres.add("%ecx");
		registradoresLivres.add("%edx");
		
		registradoresOcupados = new HashMap<String, String>();
	}
	
	public void executa() {
		adicionaText();
		
		for (Label label : si.getLabels()) {
			trataLabel(label);
			labelAtual().adicionaInstrucao(new Inicio());
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				if (ri instanceof GeraCodigoDeMaquinaBinop)
					GeraOperacao.gera((GeraCodigoDeMaquinaBinop)ri, labelAtual());
				if (ri instanceof GeraCodigoDeMaquinaMov) {
					GeraMov.gera((GeraCodigoDeMaquinaMov)ri, labelAtual());
				}
			}	
		}
		
		adicionaInstrucaoFinal();
	}

	private void adicionaInstrucaoFinal() {
		labelAtual().adicionaInstrucao(new Final());
		
	}

	private void trataLabel(Label label) {
		if (label.getNome().equals("L0"))
			adicionaLabel("_start:");
		else
			adicionaLabel();
	}

	private void adicionaLabel(String string) {
		labels.add(new Label(string));
	}

	private void adicionaText() {
		labels.add(new Label(".text"));
		labelAtual().adicionaInstrucao(new Text());
	}

	private void adicionaVariaveisNoBss(List<Token> temporarios) {
		List<Token> bss = new ArrayList<Token>();
		
		for (Token token : temporarios) {
			if (isDeclarado(token.getTemporario()))
				bss.add(token);
		}
		
		if (bss.size() > 0)
			labelAtual().adicionaInstrucao(new Bss(bss));
	}
	
	private Boolean isDeclarado(String nome) {
		return nome.matches("t[0-9]*");
	}
	
	private void adicionaLabel() {
		adicionaLabel("L" + Integer.toString(labels.size()));
	}
	
	private Label labelAtual() {
		return labels.get(labels.size() - 1);
	}
	
	public List<Label> getLabels() {
		return labels;
	}

	public Boolean getGera() {
		return gera;
	}

	public static void setGera(Boolean valor) {
		gera = valor;
	}
	
	public static String getRegistrador() {
		return registradoresLivres.remove(0);
	}
	
	public static String getRegistrador(String tmp) {
		return registradoresOcupados.get(tmp);
	}
	
	public static void alocaRegistrador(String tmp, String registrador) {
		registradoresOcupados.put(tmp, registrador);
	}
}
