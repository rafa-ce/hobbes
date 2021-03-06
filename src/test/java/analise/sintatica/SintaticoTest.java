package analise.sintatica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import analise.sintatica.suporte.Pilha;

public class SintaticoTest {
	
	@Test
	public void testaFluxoSintaticoHappyDay() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoSintaticoHappyDay.txt");
		
		sintatico.executa();
		
		assertEquals(1, Pilha.getPilha().size());
		String topo = Pilha.getTopo();
		String first = (String) Pilha.getPilha().firstElement();
		
		assertTrue(topo.equals("$"));
		assertTrue(topo.equals(first));
	}
	
	@Test
	public void testaFluxoSintaticoWhile() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoWhile.txt");
		
		sintatico.executa();
		
		assertEquals(1, Pilha.getPilha().size());
		String topo = Pilha.getTopo();
		String first = (String) Pilha.getPilha().firstElement();
		
		assertTrue(topo.equals("$"));
		assertTrue(topo.equals(first));
	}
	
	@Test
	public void testaFluxoSintaticoSobrandoElementosNaPilha() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoSintaticoSobraNaPilha.txt");
		
		String erro = null;
		
		try {
			sintatico.executa();
		} catch (Throwable e) {
			e.printStackTrace();
			erro = e.getMessage();
		}
		assertEquals("Erro! Token: 'do' não encontrado.", erro);		
		assertEquals("[$, <Lista>, <ExpORPr>, <ExpANDPr>, <RelExp>, <TermPr>, <FactorPr>, <Exp>, do]", Pilha.getPilha().toString());
	}
	
	@Test
	public void erroLexicoNaSintatica() {
		
		Sintatico sintatica = new Sintatico("src/test/resources/outros/TokenInvalido.txt");
		String erro = null;
		
		try {
			sintatica.executa();
		} catch (Throwable e) {
			e.printStackTrace();
			erro = e.getMessage();
		}
		assertEquals("Linha: 1 - Coluna: 8. Token 2c inválido", erro);
	}
	
	@Test(expected = SintaticoException.class)
	public void erroSintatico() throws Throwable {
		
		Sintatico sintatica = new Sintatico("src/test/resources/outros/ArquivoWhileOd.txt");
		
		sintatica.executa();
	}
	
	@Test
	public void testaFluxoSintaticoFuncao() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoDeclaraFuncao.txt");
		
		sintatico.executa();
		
		assertEquals(1, Pilha.getPilha().size());
		String topo = Pilha.getTopo();
		String first = (String) Pilha.getPilha().firstElement();
		
		assertTrue(topo.equals("$"));
		assertTrue(topo.equals(first));
	}
}
