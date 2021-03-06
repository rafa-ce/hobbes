package analise.lexica.token;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;
import static analise.lexica.TipoToken.OPERADOR;
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
	private Boolean escape;
	private List<Integer> dimensoes;
	private Integer referencia;
	private String temporario;
	
	public Token() { }

	public Token(String valor, Integer linha, Integer coluna, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
		this.posicao = new Posicao(linha, coluna);
		this.escape = FALSE;
	}

	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public void setAtributosDoTemporario() {
		tipo = IDENTIFICADOR;
		valor = getTemporario();
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
	
	public Boolean isOperador() {
		return getTipo().equals(OPERADOR);
	}

	public Boolean isNumero() {
		return getTipo().equals(NUMERO);
	}

	public boolean equals(Token token) {
		if (getValor().equals(token.getValor()))
			if (getTipo().equals(token.getTipo()))
				if (!getPosicao().getLinha().equals(token.getPosicao().getLinha()))
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
	
	public Boolean isVariavelDeEscape() {
		return escape;
	}
	
	public Boolean isFuncao() {
		return parametros != null;
	}
	
	public Boolean isVetor() {
		return dimensoes != null;
	}
	
	public void inicializaVetor(Integer quantidade) {
		dimensoes = new ArrayList<Integer>();
		
		for (int i = 1; i < quantidade; i++) {
			dimensoes.add(0);
		}
	}
	
	public Integer numeroDeDimensoes() {
		return dimensoes.size();
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer identificador) {
		this.referencia = identificador;
	}

	public String getTemporario() {
		return temporario;
	}

	public void setTemporario(String temporario) {
		this.temporario = temporario;
	}
}
