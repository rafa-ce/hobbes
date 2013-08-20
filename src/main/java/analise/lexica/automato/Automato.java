package analise.lexica.automato;

import java.util.ArrayList;
import java.util.List;

import analise.lexica.LexicoException;

public class Automato {
	
	private Estado estadoInicial;
	private List<Estado> estados;
	private List<Estado> estadosFinais;
	private List<Transicao> transicoes;
	
	public Automato() { 
		this.estados = new ArrayList<Estado>();
		this.transicoes = new ArrayList<Transicao>();
		this.estadosFinais = new ArrayList<Estado>();
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
		this.estados.add(estadoInicial);
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void addEstado(Estado estado) {
		this.estados.add(estado);
	}

	public List<Estado> getEstadosFinais() {
		return estadosFinais;
	}

	public void addEstadoFinal(Estado estadoFinal) {
		this.estadosFinais.add(estadoFinal);
		
		if (!estados.contains(estadoFinal))
			this.estados.add(estadoFinal);
	}

	public List<Transicao> getTransicoes() {
		return transicoes;
	}
	
	public void addTransicao(Transicao transicao) {
		this.transicoes.add(transicao);
	}
	
	public Estado getProximoEstado(Estado estadoAtual, String codigo) throws AutomatoException {
		for (Transicao transicao : getTransicoes()) {
			if (transicao.getOrigem().equals(estadoAtual) && codigo.matches(transicao.getCodigo()))
				return transicao.getDestino();
		}
		
		throw new AutomatoException();
	}

	public Boolean isEstadoFinal(Estado estado) {
		return getEstadosFinais().contains(estado);
	}
	
	public Boolean isEstadoInicial(Estado estado) {
		return getEstadoInicial().equals(estado);
	}
}
