package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void lexicoHappyDay() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/ArquivoLinhaUnica.txt");
		
		assertToken("a", "1 - 1", "identificador", lexico.getNextToken());
		assertToken(":=", "1 - 3", "operador", lexico.getNextToken());
		assertToken("20", "1 - 6", "numero", lexico.getNextToken());
		assertToken("(", "1 - 9", "simbolo", lexico.getNextToken());
		assertToken("b", "1 - 10", "identificador", lexico.getNextToken());
		assertToken("*", "1 - 12", "operador", lexico.getNextToken());
		assertToken("2", "1 - 14", "numero", lexico.getNextToken());
		assertToken(")", "1 - 15", "simbolo", lexico.getNextToken());
	}
	
	@Test(expected = LexicoException.class)
	public void identificaToken() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/TokenInvalido.txt");
		
		assertToken("if", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("a", "1 - 4", "identificador", lexico.getNextToken());
		assertToken(">", "1 - 6", "operador", lexico.getNextToken());
		lexico.getNextToken();
	}
	
	@Test
	public void identificaWhile() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/ArquivoWhile.txt");
		
		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 7", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 9", "operador", lexico.getNextToken());
		assertToken("100", "1 - 11", "numero", lexico.getNextToken());
		assertToken("do", "1 - 15", "palavraChave", lexico.getNextToken());
		
		assertToken("i", "2 - 2", "identificador", lexico.getNextToken());
		assertToken(":=", "2 - 4", "operador", lexico.getNextToken());
		assertToken("j", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 7", "operador", lexico.getNextToken());
		assertToken("i", "2 - 8", "identificador", lexico.getNextToken());
	}
	
	@Test
	public void idetificaIf() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/ArquivoIf.txt");
		
		assertToken("if", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("a", "1 - 4", "identificador", lexico.getNextToken());
		assertToken("=", "1 - 6", "operador", lexico.getNextToken());
		assertToken("b", "1 - 8", "identificador", lexico.getNextToken());
		assertToken("then", "1 - 10", "palavraChave", lexico.getNextToken());

		assertToken("a", "2 - 2", "identificador", lexico.getNextToken());
		assertToken(":=", "2 - 4", "operador", lexico.getNextToken());
		assertToken("1", "2 - 7", "numero", lexico.getNextToken());

		assertToken("else", "3 - 1", "palavraChave", lexico.getNextToken());

		assertToken("b", "4 - 2", "identificador", lexico.getNextToken());
		assertToken(":=", "4 - 4", "operador", lexico.getNextToken());
		assertToken("1", "4 - 7", "numero", lexico.getNextToken());
	}
	

	@Test
	public void arquivoComComentario() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/ArquivoComentario.txt");

		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 7", "identificador", lexico.getNextToken());
		assertToken(">", "1 - 9", "operador", lexico.getNextToken());
		assertToken("100", "1 - 17", "numero", lexico.getNextToken());
		assertToken("do", "1 - 21", "palavraChave", lexico.getNextToken());

		assertToken("i", "2 - 2", "identificador", lexico.getNextToken());
		assertToken(":=", "2 - 4", "operador", lexico.getNextToken());
		assertToken("j", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 7", "operador", lexico.getNextToken());
		assertToken("i", "2 - 8", "identificador", lexico.getNextToken());

		assertToken("i", "7 - 1", "identificador", lexico.getNextToken());
		assertToken(":=", "7 - 3", "operador", lexico.getNextToken());
		assertToken("10", "7 - 6", "numero", lexico.getNextToken());
		
	}
	
	@Test
	public void arquivoDesorganizado() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/ArquivoDesorganizado.txt");
		
		assertToken("while", "3 - 1", "palavraChave", lexico.getNextToken());
		assertToken("(", "3 - 6", "simbolo", lexico.getNextToken());
		assertToken("i", "3 - 8", "identificador", lexico.getNextToken());
		assertToken("<", "3 - 10", "operador", lexico.getNextToken());
		assertToken("100", "3 - 25", "numero", lexico.getNextToken());
		assertToken(")", "3 - 29", "simbolo", lexico.getNextToken());
		assertToken("do", "3 - 30", "palavraChave", lexico.getNextToken());

		assertToken("i", "4 - 2", "identificador", lexico.getNextToken());
		assertToken(":=", "4 - 4", "operador", lexico.getNextToken());
		assertToken("j", "4 - 7", "identificador", lexico.getNextToken());
		assertToken("+", "4 - 9", "operador", lexico.getNextToken());
		assertToken("i", "4 - 11", "identificador", lexico.getNextToken());

		assertToken("printf", "5 - 1", "palavraChave", lexico.getNextToken());
		assertToken("(", "5 - 7", "simbolo", lexico.getNextToken());
		assertToken("\"jose\"", "5 - 8", "string", lexico.getNextToken());
		assertToken(")", "5 - 14", "simbolo", lexico.getNextToken());
		
	}
	
	private void assertToken(String valor, String posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
		assertEquals(posicao, token.getPosicao().toString());
		assertEquals(tipo, token.getTipo());
	}

}
