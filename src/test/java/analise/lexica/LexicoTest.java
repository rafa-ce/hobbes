package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void identificaUmaLinha() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertToken("while", 0, "palavraChave", lexico.getNextToken());
		assertToken("i", 6, "identificador", lexico.getNextToken());
		assertToken("<", 8, "simbolo", lexico.getNextToken());
		assertToken("100", 10, "numero", lexico.getNextToken());
		assertToken("do", 14, "palavraChave", lexico.getNextToken());
		assertToken("i", 17, "identificador", lexico.getNextToken());
		assertToken("=", 19, "simbolo", lexico.getNextToken());
		assertToken("j", 21, "identificador", lexico.getNextToken());
		assertToken("+", 23, "simbolo", lexico.getNextToken());
		assertToken("i", 25, "identificador", lexico.getNextToken());
	}
	
	@Test
	public void identificaDuasLinhas() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoDuasLinhas.txt");
		
		assertToken("while", 0, "palavraChave", lexico.getNextToken());
		assertToken("i", 6, "identificador", lexico.getNextToken());
		assertToken("<", 8, "simbolo", lexico.getNextToken());
		assertToken("100", 10, "numero", lexico.getNextToken());
		assertToken("do", 14, "palavraChave", lexico.getNextToken());
		assertToken("i", 0, "identificador", lexico.getNextToken());
		assertToken("=", 3, "simbolo", lexico.getNextToken());
		assertToken("j", 5, "identificador", lexico.getNextToken());
		assertToken("+", 7, "simbolo", lexico.getNextToken());
		assertToken("i", 9, "identificador", lexico.getNextToken());
	}
	
	private void assertToken(String valor, Integer posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
		assertEquals(posicao, token.getPosicaoColuna());
		assertEquals(tipo, token.getTipo());
	}

}
