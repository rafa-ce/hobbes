package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void identificaUmaLinha() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertToken("while", "1 - 0", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 6", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 8", "simbolo", lexico.getNextToken());
		assertToken("100", "1 - 10", "numero", lexico.getNextToken());
		assertToken("do", "1 - 14", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 17", "identificador", lexico.getNextToken());
		assertToken("=", "1 - 19", "simbolo", lexico.getNextToken());
		assertToken("j", "1 - 21", "identificador", lexico.getNextToken());
		assertToken("+", "1 - 23", "simbolo", lexico.getNextToken());
		assertToken("i", "1 - 25", "identificador", lexico.getNextToken());
	}
	
	@Test
	public void identificaDuasLinhas() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoDuasLinhas.txt");
		
		assertToken("while", "1 - 0", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 6", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 8", "simbolo", lexico.getNextToken());
		assertToken("100", "1 - 10", "numero", lexico.getNextToken());
		assertToken("do", "1 - 14", "palavraChave", lexico.getNextToken());
		assertToken("i", "2 - 0", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 3", "simbolo", lexico.getNextToken());
		assertToken("j", "2 - 5", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 7", "simbolo", lexico.getNextToken());
		assertToken("i", "2 - 9", "identificador", lexico.getNextToken());
	}
	
	@Test(expected = LexicoException.class)
	public void tokenInvalido() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/tokenInvalido.txt");
		
		assertToken("if", "1 - 0", "palavraChave", lexico.getNextToken());
		assertToken("a", "1 - 3", "identificador", lexico.getNextToken());
		assertToken(">", "1 - 5", "simbolo", lexico.getNextToken());
		assertToken("b", "1 - 7", "identificador", lexico.getNextToken());
		assertToken("then", "1 - 9", "palavraChave", lexico.getNextToken());
		assertToken("a", "2 - 0", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 3", "simbolo", lexico.getNextToken());
		assertToken("b", "2 - 5", "identificador", lexico.getNextToken());
		assertToken("else", "3 - 0", "palavraChave", lexico.getNextToken());
		
		lexico.getNextToken();
	}
	
	private void assertToken(String valor, String posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
		assertEquals(posicao, token.getPosicao().toString());
		assertEquals(tipo, token.getTipo());
	}

}
