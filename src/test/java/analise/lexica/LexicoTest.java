package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void identificaUmaLinha() throws Throwable {
		
		String entrada = "while i < 100 do i = j + i\n";
		
		Lexico lexico = new Lexico();
		
		assertToken("while", 6, "palavraChave", lexico.getNextToken(entrada));
		assertToken("i", 8, "identificador", lexico.getNextToken(entrada));
		assertToken("<", 6, "simbolo", lexico.getNextToken(entrada));
		assertToken("100", 6, "numero", lexico.getNextToken(entrada));
		assertToken("do", 6, "palavraChave", lexico.getNextToken(entrada));
		assertToken("i", 6, "identificador", lexico.getNextToken(entrada));
		assertToken("=", 6, "simbolo", lexico.getNextToken(entrada));
		assertToken("j", 6, "identificador", lexico.getNextToken(entrada));
		assertToken("+", 6, "simbolo", lexico.getNextToken(entrada));
		assertToken("i", 6, "identificador", lexico.getNextToken(entrada));
	}
	
	@Test
	public void identificaDuasLinhas() throws Throwable {
		String entrada1 = "while i < 100 do\n";
		String entrada2 = "i = j + i\n";
		
		Lexico lexico = new Lexico();
		
		assertToken("while", 6, "palavraChave", lexico.getNextToken(entrada1));
		assertToken("i", 8, "identificador", lexico.getNextToken(entrada1));
		assertToken("<", 6, "simbolo", lexico.getNextToken(entrada1));
		assertToken("100", 6, "numero", lexico.getNextToken(entrada1));
		assertToken("do", 6, "palavraChave", lexico.getNextToken(entrada1));
		assertToken("i", 6, "identificador", lexico.getNextToken(entrada2));
		assertToken("=", 6, "simbolo", lexico.getNextToken(entrada2));
		assertToken("j", 6, "identificador", lexico.getNextToken(entrada2));
		assertToken("+", 6, "simbolo", lexico.getNextToken(entrada2));
		assertToken("i", 6, "identificador", lexico.getNextToken(entrada2));
	}
	
	private void assertToken(String valor, Integer posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
//		assertEquals(posicao, token.getPosicao());
		assertEquals(tipo, token.getTipo());
	}

}
