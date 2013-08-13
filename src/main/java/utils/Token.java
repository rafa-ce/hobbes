package utils;

public class Token {
	
	private String valor;
	private Integer posicaoColuna;
	private String tipo;

	public Token(String valor, Integer posicaoColuna, String tipo) {
		this.setValor(valor);
		this.setPosicaoColuna(posicaoColuna);
		this.setTipo(tipo);
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getPosicaoColuna() {
		return posicaoColuna;
	}

	public void setPosicaoColuna(Integer posicao) {
		this.posicaoColuna = posicao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
