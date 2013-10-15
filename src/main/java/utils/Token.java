package utils;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;
import static analise.lexica.TipoToken.PALAVRA_CHAVE;

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
	
	public Boolean isPalavraChave() {
		return getTipo().equals(PALAVRA_CHAVE);
	}
	
	public Boolean isIdentificador() {
		return getTipo().equals(IDENTIFICADOR);
	}

	public Boolean isNumero() {
		return getTipo().equals(NUMERO);
	}
}
