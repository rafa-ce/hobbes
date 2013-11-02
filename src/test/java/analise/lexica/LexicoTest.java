package analise.lexica;

import static analise.lexica.TipoToken.IDENTIFICADOR;
import static analise.lexica.TipoToken.NUMERO;
import static analise.lexica.TipoToken.OPERADOR;
import static analise.lexica.TipoToken.PALAVRA_CHAVE;
import static analise.lexica.TipoToken.SIMBOLO;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import utils.Token;

public class LexicoTest {

	@Test
	public void lexicoHappyDay() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/outros/ArquivoLinhaUnica.txt");
		
		assertToken("a", "1 - 1", IDENTIFICADOR, lexico.getNextToken());
		assertToken(":=", "1 - 3", OPERADOR, lexico.getNextToken());
		assertToken("20", "1 - 6", NUMERO, lexico.getNextToken());
		assertToken("(", "1 - 9", SIMBOLO, lexico.getNextToken());
		assertToken("b", "1 - 10", IDENTIFICADOR, lexico.getNextToken());
		assertToken("*", "1 - 12", OPERADOR, lexico.getNextToken());
		assertToken("2", "1 - 14", NUMERO, lexico.getNextToken());
		assertToken(")", "1 - 15", SIMBOLO, lexico.getNextToken());
	}
	
	@Test(expected = LexicoException.class)
	public void identificaToken() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/outros/TokenInvalido.txt");
		
		assertToken("if", "1 - 1", PALAVRA_CHAVE, lexico.getNextToken());
		assertToken("a", "1 - 4", IDENTIFICADOR, lexico.getNextToken());
		assertToken(">", "1 - 6", OPERADOR, lexico.getNextToken());
		lexico.getNextToken();
	}
	
	@Test
	public void identificaWhile() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/outros/ArquivoWhile.txt");
		
		assertToken("while", "1 - 1", PALAVRA_CHAVE, lexico.getNextToken());
		assertToken("i", "1 - 7", IDENTIFICADOR, lexico.getNextToken());
		assertToken("<", "1 - 9", OPERADOR, lexico.getNextToken());
		assertToken("100", "1 - 11", NUMERO, lexico.getNextToken());
		assertToken("do", "1 - 15", PALAVRA_CHAVE, lexico.getNextToken());
		
		assertToken("i", "2 - 2", IDENTIFICADOR, lexico.getNextToken());
		assertToken(":=", "2 - 4", OPERADOR, lexico.getNextToken());
		assertToken("j", "2 - 6", IDENTIFICADOR, lexico.getNextToken());
		assertToken("+", "2 - 7", OPERADOR, lexico.getNextToken());
		assertToken("i", "2 - 8", IDENTIFICADOR, lexico.getNextToken());
	}
	
	@Test
	public void idetificaIf() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/outros/ArquivoIf.txt");
		
		assertToken("if", "1 - 1", PALAVRA_CHAVE, lexico.getNextToken());
		assertToken("a", "1 - 4", IDENTIFICADOR, lexico.getNextToken());
		assertToken("=", "1 - 6", OPERADOR, lexico.getNextToken());
		assertToken("b", "1 - 8", IDENTIFICADOR, lexico.getNextToken());
		assertToken("then", "1 - 10", PALAVRA_CHAVE, lexico.getNextToken());

		assertToken("a", "2 - 2", IDENTIFICADOR, lexico.getNextToken());
		assertToken(":=", "2 - 4", OPERADOR, lexico.getNextToken());
		assertToken("1", "2 - 7", NUMERO, lexico.getNextToken());

		assertToken("else", "3 - 1", PALAVRA_CHAVE, lexico.getNextToken());

		assertToken("b", "4 - 2", IDENTIFICADOR, lexico.getNextToken());
		assertToken(":=", "4 - 4", OPERADOR, lexico.getNextToken());
		assertToken("1", "4 - 7", NUMERO, lexico.getNextToken());
	}
	
	@Test
	public void arquivoDesorganizado() throws Throwable {
		Lexico lexico = new Lexico("src/test/resources/outros/ArquivoDesorganizado.txt");
		
		assertToken("while", "3 - 1", PALAVRA_CHAVE, lexico.getNextToken());
		assertToken("(", "3 - 6", SIMBOLO, lexico.getNextToken());
		assertToken("i", "3 - 8", IDENTIFICADOR, lexico.getNextToken());
		assertToken("<", "3 - 10", OPERADOR, lexico.getNextToken());
		assertToken("100", "3 - 25", NUMERO, lexico.getNextToken());
		assertToken(")", "3 - 29", SIMBOLO, lexico.getNextToken());
		assertToken("do", "3 - 30", PALAVRA_CHAVE, lexico.getNextToken());

		assertToken("i", "4 - 2", IDENTIFICADOR, lexico.getNextToken());
		assertToken(":=", "4 - 4", OPERADOR, lexico.getNextToken());
		assertToken("j", "4 - 7", IDENTIFICADOR, lexico.getNextToken());
		assertToken("+", "4 - 9", OPERADOR, lexico.getNextToken());
		assertToken("i", "4 - 11", IDENTIFICADOR, lexico.getNextToken());

		assertToken("printf", "5 - 1", PALAVRA_CHAVE, lexico.getNextToken());
		assertToken("(", "5 - 7", SIMBOLO, lexico.getNextToken());
		assertToken("\"jose\"", "5 - 8", "string", lexico.getNextToken());
		assertToken(")", "5 - 14", SIMBOLO, lexico.getNextToken());
		
		assertNull(lexico.getNextToken());
		
	}
	
	private void assertToken(String valor, String posicao, String tipo, Token token) {
		assertEquals(valor, token.getValor());
		assertEquals(posicao, token.getPosicao().toString());
		assertEquals(tipo, token.getTipo());
	}

}
