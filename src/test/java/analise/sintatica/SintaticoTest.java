package analise.sintatica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SintaticoTest {
	
	@Test
	public void testaFluxoTokens() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/arquivoLinhaUnica.txt");
		
		assertEquals(10, sintatico.montaASA().size());
	}

}
