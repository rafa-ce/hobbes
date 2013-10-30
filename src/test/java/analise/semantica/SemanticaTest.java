package analise.semantica;

import org.junit.Test;

import analise.sintatica.Sintatico;

public class SemanticaTest {

	@Test
	public void testArquivoComComentario1() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoComentario.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
//		Assert.assertEquals(13, semantico.getLista().size());
	}
	
	@Test
	public void testaFluxoDeclaraFuncao() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoVariosEscopos.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}

	@Test
	public void semanticaHappyDay() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoSintaticoHappyDay.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
//		Assert.assertEquals(13, semantico.getLista().size());
	}

}
