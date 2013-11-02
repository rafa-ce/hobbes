package utils;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;
import static analise.lexica.TipoToken.PALAVRA_CHAVE;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;

public class Token {
	
	private String valor;
	private Posicao posicao;
	private String tipo;
	private Integer parametros;
	private TipoRetorno tipoRetorno;
	private Boolean escape;
	
	public Token(String valor, Integer linha, Integer coluna, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
		this.posicao = new Posicao(linha, coluna);
		this.escape = FALSE;
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

	public TipoRetorno getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(TipoRetorno tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}
	
	public boolean equals(Token token) {
//		if (getTipoRetorno() == null && token.getTipoRetorno() == null)
//			return false;
		
		if (getValor().equals(token.getValor()))
			if (getTipo().equals(token.getTipo()))
				return true;
		
		return false;
	}
	
	public void adicionaParametro() {
		if (parametros == null)
			parametros = 0;
		else
			parametros++;
	}
	
	public Integer numeroDeParametros() {
		return parametros;
	}
	
	public void marcaVariavellDeEscape() {
		escape = TRUE;
	}
	
	public Boolean isFuncao() {
		return parametros != null;
	}
	
}
