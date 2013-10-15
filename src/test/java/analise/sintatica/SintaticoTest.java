package analise.sintatica;

import org.junit.Test;

import analise.lexica.LexicoException;

public class SintaticoTest {
	
	@Test
	public void testaFluxoTokensHappyDay() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoLinhaUnica.txt");
		
//		assertEquals(8, sintatico.montaASA().size());
	}

	@Test(expected = LexicoException.class)
	public void testaLexicoException() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/TokenInvalido.txt");
		
		sintatico.montaASA();
	}
	
	@Test
	public void testaFluxoTokensWhile() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoWhile.txt");
		
//		assertEquals(10, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoTokensIf() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoIf.txt");
		
//		assertEquals(12, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoTokensComentario() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoComentario.txt");
		
//		assertEquals(13, sintatico.montaASA().size());
	}
	
	@Test
	public void testaFluxoTokensArquivoDesorganizado() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoDesorganizado.txt");
		
//		assertEquals(16, sintatico.montaASA().size());
	}
}
