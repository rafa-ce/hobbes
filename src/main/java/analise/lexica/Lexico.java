package analise.lexica;

import static utils.ExpressaoRegular.ESPACO_EM_BRANCO;
import utils.ExpressaoRegular;
import utils.Token;
import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;

public class Lexico {
	
	private Automato automato;
	private Integer coluna;
	private TipoToken tipoToken;

	public Lexico() {
		this.automato = AutomatoTiger.implementa();
		this.coluna = 0;
		this.tipoToken = new TipoToken();
	}

	public Token getNextToken(String entrada) throws Throwable {
		
		String valorDoToken = "";
		
		Estado estadoAtual = automato.getEstadoInicial();

		while (coluna < entrada.length()) {
			
			Character cada = entrada.charAt(coluna);
			
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
		
		if (coluna.equals(entrada.length())) {
			coluna = 0;
		}
		
		return montaToken(valorDoToken, estadoAtual);
	}
	
	private Token montaToken(String valor, Estado estado) {
		String tipo = tipoToken.getTipo(estado.getId());
		
		return new Token(valor, coluna, tipo);
	}

	private String montaValorDoToken(Estado estado, String caracter) {
		if (automato.isEstadoFinal(estado) || automato.isEstadoInicial(estado))
			return "";
		
		return caracter;
	}
}
