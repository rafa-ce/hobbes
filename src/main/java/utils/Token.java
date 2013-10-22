package utils;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;
import static analise.lexica.TipoToken.PALAVRA_CHAVE;

import java.util.List;

public class Token {
	
	private String valor;
	private Posicao posicao;
	private String tipo;
	private List<String> parametros;
	private TipoRetorno tipoRetorno;
	
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

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	public TipoRetorno getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(TipoRetorno tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}
}
