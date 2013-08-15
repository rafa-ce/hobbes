package utils;

public class Token {
	
	private String valor;
	private Posicao posicao;
	private String tipo;

	public Token(String valor, Integer linha, Integer coluna, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
		this.posicao = new Posicao(linha, coluna);
	}

	public String getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public Posicao getPosicao() {
		return posicao;
	}
}
