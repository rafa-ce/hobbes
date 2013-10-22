package analise.sintatica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SintaticoTest {
	
	@Test
	public void testaFluxoSintaticoHappyDay() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoSintaticoHappyDay.txt");
		
		sintatico.executa();
		
		assertEquals(1, sintatico.getPilha().size());
		String firstElement = sintatico.getPilha().firstElement();
		String lastElement = sintatico.getPilha().lastElement();
		
		assertTrue(firstElement.equals("$"));
		assertTrue(firstElement.equals(lastElement));
		
		sintatico.printArvore();
	}
	
	@Test
	public void testaFluxoSintaticoWhile() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoWhile.txt");
		
		sintatico.executa();
		
		assertEquals(1, sintatico.getPilha().size());
		String firstElement = sintatico.getPilha().firstElement();
		String lastElement = sintatico.getPilha().lastElement();
		
		assertTrue(firstElement.equals("$"));
		assertTrue(firstElement.equals(lastElement));
		
		sintatico.printArvore();
	}
	
	@Test
	public void testaFluxoSintaticoWhileErro() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoWhileErro.txt");
		
		sintatico.executa();
		
		assertEquals(1, sintatico.getPilha().size());
		String firstElement = sintatico.getPilha().firstElement();
		String lastElement = sintatico.getPilha().lastElement();
		
		assertTrue(firstElement.equals("$"));
		assertTrue(firstElement.equals(lastElement));
		
		sintatico.printArvore();
	}

	@Test
	public void testaFluxoSintaticoSobrandoElementosNaPilha() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoSintaticoSobraNaPilha.txt");
		
		sintatico.executa();
		
		assertEquals("[$, <Lista>, <ExpORPr>, <ExpANDPr>, <RelExp>, <TermPr>, <FactorPr>, <Exp>]", sintatico.getPilha().toString());
	}
	
}
