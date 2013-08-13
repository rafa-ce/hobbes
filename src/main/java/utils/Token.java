package utils;

public class Token {
	
	private String valor;
	private Integer posicao;
	private String tipo;

	public Token(String valor, Integer posicao, String tipo) {
		this.setValor(valor);
		this.setPosicao(posicao);
		this.setTipo(tipo);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
