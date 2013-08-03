package analise.lexica.automato;

public class Transicao {
	
	private Estado origem;
	private Estado destino;
	private String codigo;
	
	public Transicao(Estado origem, Estado destino, String codigo) {
		this.origem = origem;
		this.destino = destino;
		this.codigo = codigo;
	}

	public Estado getOrigem() {
		return origem;
	}

	public void setOrigem(Estado origem) {
		this.origem = origem;
	}

	public Estado getDestino() {
		return destino;
	}

	public void setDestino(Estado destino) {
		this.destino = destino;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
