package analise.sintatica;

import static org.junit.Assert.*;

import org.junit.Test;

import analise.lexica.LexicoException;

public class SintaticoTest {
	
	@Test
	public void testaFluxoTokens() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertEquals(10, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoTokensDuasLinhas() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/arquivoDuasLinhas.txt");
		
		assertEquals(10, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoTokensComComentario() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/arquivoComentario.txt");
		
		assertEquals(13, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoLoucuraComComentario() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/arquivoDaLocura.txt");
		
		assertEquals(16, sintatico.montaASA().size());
	}

	@Test(expected = LexicoException.class)
	public void testaLexicoException() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/tokenInvalido.txt");
		
		sintatico.montaASA();
	}
}
