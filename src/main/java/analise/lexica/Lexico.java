package analise.lexica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import utils.Token;
import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;

public class Lexico {
	
	private Automato automato;
	private Integer coluna;
	private Integer linha;
	private Integer posicaoToken;
	private TipoToken tipoToken;
	private BufferedReader codigoFonte;
	private String linhaAtual;
	
	public Lexico(String entrada) {
		this.automato = AutomatoTiger.implementa();
		this.coluna = 0;
		this.linha = 0;
		this.tipoToken = new TipoToken();
		inicializa(entrada);
		
		try {
			linhaAtual = lerArquivo();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private void inicializa(String entrada) {
		try {
			codigoFonte = new BufferedReader(new FileReader(entrada));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private String lerArquivo() throws Throwable {	
		if (codigoFonte.ready())
			 return codigoFonte.readLine() + " ";
			
		codigoFonte.close();
		
		return "";
	}

	public Token getNextToken() throws Throwable {

		String valorDoToken = "";
		Estado estadoAtual = automato.getEstadoInicial();
		
		posicaoToken = coluna;
		
		while (coluna < linhaAtual.length() + 1) {
			
			Character cada = linhaAtual.charAt(coluna);
			
			try {
				estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
				valorDoToken += montaValorDoToken(estadoAtual, cada.toString());
				coluna++;
			} catch (LexicoException e) {
				e.getMessage();
			} finally {
				if (automato.isEstadoFinal(estadoAtual))
					break;
			}

		}
		
		if (coluna.equals(linhaAtual.length())) {
			coluna = 0;
			linhaAtual = lerArquivo();
		}
		
		return montaToken(valorDoToken, posicaoToken, estadoAtual);
	}
	
	
	private Token montaToken(String valor, Integer posicaoToken, Estado estado) {
		
		Integer estadoID = estado.getId();
		String tipo = tipoToken.getTipo(estadoID,  valor);
		
		return new Token(valor, posicaoToken, tipo);
	}

	private String montaValorDoToken(Estado estado, String caracter) {
		if (automato.isEstadoFinal(estado) || automato.isEstadoInicial(estado))
			return "";
		
		return caracter;
	}
}
