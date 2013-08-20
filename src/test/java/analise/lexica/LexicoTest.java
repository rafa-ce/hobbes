package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void identificaUmaLinha() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 7", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 9", "simbolo", lexico.getNextToken());
		assertToken("100", "1 - 11", "numero", lexico.getNextToken());
		assertToken("do", "1 - 15", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 18", "identificador", lexico.getNextToken());
		assertToken("=", "1 - 20", "simbolo", lexico.getNextToken());
		assertToken("j", "1 - 22", "identificador", lexico.getNextToken());
		assertToken("+", "1 - 24", "simbolo", lexico.getNextToken());
		assertToken("i", "1 - 26", "identificador", lexico.getNextToken());
	}
	
	@Test
	public void identificaDuasLinhas() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoDuasLinhas.txt");
		
		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 7", "identificador", lexico.getNextToken());
		assertToken("and", "1 - 9", "simbolo", lexico.getNextToken());
		assertToken("100", "1 - 13", "numero", lexico.getNextToken());
		assertToken("do", "1 - 17", "palavraChave", lexico.getNextToken());
		assertToken("i", "2 - 2", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 4", "simbolo", lexico.getNextToken());
		assertToken("j", "2 - 5", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 6", "simbolo", lexico.getNextToken());
		assertToken("i", "2 - 7", "identificador", lexico.getNextToken());
	}
	
	@Test(expected = LexicoException.class)
	public void tokenInvalido() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/tokenInvalido.txt");
		
		assertToken("if", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("a", "1 - 4", "identificador", lexico.getNextToken());
		assertToken(">", "1 - 6", "simbolo", lexico.getNextToken());
		assertToken("b", "1 - 8", "identificador", lexico.getNextToken());
		assertToken("then", "1 - 10", "palavraChave", lexico.getNextToken());
		assertToken("a", "2 - 2", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 4", "simbolo", lexico.getNextToken());
		assertToken("b", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("else", "3 - 1", "palavraChave", lexico.getNextToken());
		
		lexico.getNextToken();
	}
	
	@Ignore
	@Test
	public void identificaComentarios() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoDaLocura.txt");
		
		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("(", "1 - 6", "simbolo", lexico.getNextToken());
		assertToken("i", "1 - 8", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 10", "simbolo", lexico.getNextToken());
		assertToken("100", "1 - 25", "numero", lexico.getNextToken());
		assertToken(")", "1 - 29", "simbolo", lexico.getNextToken());
		assertToken("do", "1 - 30", "palavraChave", lexico.getNextToken());
		assertToken("i", "2 - 2", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 4", "simbolo", lexico.getNextToken());
		assertToken("j", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 8", "simbolo", lexico.getNextToken());
		assertToken("i", "2 - 10", "identificador", lexico.getNextToken());
		assertToken("printf", "3 - 1", "identificador", lexico.getNextToken());
		assertToken("(", "3 - 7", "simbolo", lexico.getNextToken());
		assertToken("\"jose", "3 - 9", "string", lexico.getNextToken());
		assertToken(")", "3 - 15", "simbolo", lexico.getNextToken());
	}
	
	private void assertToken(String valor, String posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
		assertEquals(posicao, token.getPosicao().toString());
		assertEquals(tipo, token.getTipo());
	}

}
