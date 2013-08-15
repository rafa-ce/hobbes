package analise.lexica;

import static java.lang.Boolean.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import utils.Token;
import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;

public class Lexico {
	
	private Automato automato;
	private Integer iterador;
	private Integer tokenLinha;
	private Integer tokenColuna;
	private BufferedReader codigoFonte;
	private String linhaAtual;
	private Boolean fimDeArquivo;
	
	public Lexico(String entrada) {
		this.automato = AutomatoTiger.implementa();
		this.iterador = 0;
		this.tokenLinha = 0;
		fimDeArquivo = FALSE;
		inicializa(entrada);
	}
	
	private void inicializa(String entrada) {
		abreArquivo(entrada);
		
		try {
			linhaAtual = getLinha();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void abreArquivo(String entrada) {
		try {
			codigoFonte = new BufferedReader(new FileReader(entrada));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String getLinha() throws Throwable {	
		if (codigoFonte.ready()) {
			tokenLinha++;
			return codigoFonte.readLine() + " ";
		}
		
		codigoFonte.close();
		fimDeArquivo = TRUE;
		
		return "";
	}

	public Token getNextToken() throws Throwable {

		lerProximaLinha();
		
		String valorDoToken = "";
		Estado estadoAtual = automato.getEstadoInicial();
		
		tokenColuna = iterador;
		
		while (!automato.isEstadoFinal(estadoAtual)) {
			
			Character cada = linhaAtual.charAt(iterador);
			
			try {
				estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
				valorDoToken += montaValorDoToken(estadoAtual, cada.toString());
				iterador++;
			} catch (LexicoException e) {
				e.getMessage();
				break;
			}
		}
		
		if (automato.isEstadoFinal(estadoAtual))
			return montaToken(valorDoToken, estadoAtual);
		
		throw new LexicoException("Caractere inv�lido!");
	}

	private void lerProximaLinha() throws Throwable {
		if (iterador.equals(linhaAtual.length())) {
			iterador = 0;
			linhaAtual = getLinha();
		}
	}
	
	
	private Token montaToken(String valor, Estado estado) {
		TipoToken tipoToken = new TipoToken();
		
		Integer estadoID = estado.getId();
		String tipo = tipoToken.getTipo(estadoID,  valor);
		
		return new Token(valor, tokenLinha, tokenColuna, tipo);
	}

	private String montaValorDoToken(Estado estado, String caracter) {
		if (automato.isEstadoFinal(estado) || automato.isEstadoInicial(estado))
			return "";
		
		return caracter;
	}

	public Boolean hasToken() {
		return !fimDeArquivo;
	}
}
