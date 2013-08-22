package analise.lexica;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import utils.Token;

public class LexicoTest {
	
	@Test
	public void identificaUmaLinha() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertToken("while", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 7", "identificador", lexico.getNextToken());
		assertToken("<", "1 - 9", "operador", lexico.getNextToken());
		assertToken("100", "1 - 11", "numero", lexico.getNextToken());
		assertToken("do", "1 - 15", "palavraChave", lexico.getNextToken());
		assertToken("i", "1 - 18", "identificador", lexico.getNextToken());
		assertToken("=", "1 - 20", "operador", lexico.getNextToken());
		assertToken("j", "1 - 22", "identificador", lexico.getNextToken());
		assertToken("+", "1 - 24", "operador", lexico.getNextToken());
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
		assertToken(":=", "2 - 4", "operador", lexico.getNextToken());
		assertToken("j", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("+", "2 - 7", "operador", lexico.getNextToken());
		assertToken("i", "2 - 8", "identificador", lexico.getNextToken());
	}
	
	@Test(expected = LexicoException.class)
	public void tokenInvalido() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/tokenInvalido.txt");
		
		assertToken("if", "1 - 1", "palavraChave", lexico.getNextToken());
		assertToken("a", "1 - 4", "identificador", lexico.getNextToken());
		assertToken(">", "1 - 6", "operador", lexico.getNextToken());
		assertToken("b", "1 - 8", "identificador", lexico.getNextToken());
		assertToken("then", "1 - 10", "palavraChave", lexico.getNextToken());
		assertToken("a", "2 - 2", "identificador", lexico.getNextToken());
		assertToken("=", "2 - 4", "operador", lexico.getNextToken());
		assertToken("b", "2 - 6", "identificador", lexico.getNextToken());
		assertToken("else", "3 - 1", "palavraChave", lexico.getNextToken());
		
		lexico.getNextToken();
	}
	
	@Test
	public void identificaComentarios() throws Throwable {
		
		Lexico lexico = new Lexico("src/test/resources/arquivoDaLocura.txt");
		
		assertToken("while", "3 - 1", "palavraChave", lexico.getNextToken());
		assertToken("(", "3 - 6", "simbolo", lexico.getNextToken());
		assertToken("i", "3 - 8", "identificador", lexico.getNextToken());
		assertToken("<", "3 - 10", "operador", lexico.getNextToken());
		assertToken("100", "3 - 25", "numero", lexico.getNextToken());
		assertToken(")", "3 - 29", "simbolo", lexico.getNextToken());
		assertToken("do", "3 - 30", "palavraChave", lexico.getNextToken());
		assertToken("i", "4 - 2", "identificador", lexico.getNextToken());
		assertToken("=", "4 - 4", "operador", lexico.getNextToken());
		assertToken("j", "4 - 6", "identificador", lexico.getNextToken());
		assertToken("+", "4 - 8", "operador", lexico.getNextToken());
		assertToken("i", "4 - 10", "identificador", lexico.getNextToken());
		assertToken("printf", "5 - 1", "identificador", lexico.getNextToken());
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
