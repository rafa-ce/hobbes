package analise.lexica.automato;

import java.util.List;

public class Automato {
	
	private Estado estadoInicial;
	private List<Estado> estados;
	private List<Estado> estadosFinais;
	private List<Transicao> transicoes;
	
	public Automato() { }

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Estado> getEstadosFinais() {
		return estadosFinais;
	}

	public void setEstadosFinais(List<Estado> estadosFinais) {
		this.estadosFinais = estadosFinais;
	}

	public List<Transicao> getTransicoes() {
		return transicoes;
	}
	
	public Estado getProximoEstado(Estado estadoAtual, String codigo) throws Throwable {
		for (Transicao transicao : getTransicoes()) {
			if (transicao.getOrigem().equals(estadoAtual) && codigo.matches(transicao.getCodigo()))
				return transicao.getDestino();
		}
		
		throw new Exception("Caractere inválido!");
	}

	public void setTransicoes(List<Transicao> transicoes) {
		this.transicoes = transicoes;
	}
	
	
	
	

}
