package analise.semantica;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import analise.semantica.suporte.Variavel;
import analise.sintatica.Sintatico;
import analise.sintatica.SintaticoException;

public class SemanticaTest {

	@Test
	public void arquivoComComentario() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoComentario.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		List<Variavel> variaveis = semantico.getVariaveis();
		
		assertEquals("Variavers declaradas", 2, variaveis.size());
		assertEquals("i2", variaveis.get(0).toString());
		assertEquals("j3", variaveis.get(1).toString());
	}
	
	@Test(expected = SemanticoException.class)
	public void arquivoComComentarioErro() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoComentarioErro.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SemanticoException.class)
	public void variosEscopos() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoVariosEscopos.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
	public void semanticaFunction() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoDeclaraFuncao.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}

	@Test
	public void semanticaHappyDay() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoSintaticoHappyDay.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		List<Variavel> variaveis = semantico.getVariaveis();
		assertEquals("a1", variaveis.get(0).toString());
	}
	
	@Test
	public void semanticaVetor() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoVetor.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SemanticoException.class)
	public void semanticaVetorErro() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoVetorErro.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SemanticoException.class)
	public void semanticaVetorEmUmaExpressaoErro() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoExpressaoVetorErro.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		List<Variavel> variaveis = semantico.getVariaveis();
		
		assertEquals(3, variaveis.size());
		assertEquals("a1", variaveis.get(0).toString());
		assertEquals("i1", variaveis.get(0).toString());
		assertEquals("j1", variaveis.get(0).toString());
	}
	
	@Test
	public void semanticaVetorEmUmaExpressao() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoExpressaoVetor.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SemanticoException.class)
	public void erroVariavelNaoDeclarada() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoWhile.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SintaticoException.class)
	public void naoUsaPalavraChaveComoIdentificador() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoForIdentificador.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
}
