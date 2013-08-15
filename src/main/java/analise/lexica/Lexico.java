package analise.lexica;

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
	private TipoToken tipoToken;
	private BufferedReader codigoFonte;
	private String linhaAtual;
	
	public Lexico(String entrada) {
		this.automato = AutomatoTiger.implementa();
		this.iterador = 0;
		this.tokenLinha = 0;
		this.tipoToken = new TipoToken();
		inicializa(entrada);
		
		try {
			linhaAtual = getLinha();
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

	private String getLinha() throws Throwable {	
		if (codigoFonte.ready()) {
			tokenLinha++;
			return codigoFonte.readLine() + " ";
		}
		codigoFonte.close();
		
		return "";
	}

	public Token getNextToken() throws Throwable {

		lerProximaLinha();
		
		String valorDoToken = "";
		Estado estadoAtual = automato.getEstadoInicial();
		
		tokenColuna = iterador;
		
		while (iterador < linhaAtual.length() + 1) {
			
			Character cada = linhaAtual.charAt(iterador);
			
			try {
				estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
				valorDoToken += montaValorDoToken(estadoAtual, cada.toString());
				iterador++;
			} catch (LexicoException e) {
				e.getMessage();
				break;
			}
			
			if (automato.isEstadoFinal(estadoAtual))
				break;
		}
		
		if (automato.isEstadoFinal(estadoAtual))
			return montaToken(valorDoToken, estadoAtual);
		
		throw new LexicoException("Caractere inválido!");
	}

	private void lerProximaLinha() throws Throwable {
		if (iterador.equals(linhaAtual.length())) {
			iterador = 0;
			linhaAtual = getLinha();
		}
	}
	
	
	private Token montaToken(String valor, Estado estado) {
		
		Integer estadoID = estado.getId();
		String tipo = tipoToken.getTipo(estadoID,  valor);
		
		return new Token(valor, tokenLinha, tokenColuna, tipo);
	}

	private String montaValorDoToken(Estado estado, String caracter) {
		if (automato.isEstadoFinal(estado) || automato.isEstadoInicial(estado))
			return "";
		
		return caracter;
	}
}
