package analise.semantica;

import org.junit.Assert;
import org.junit.Test;

import analise.sintatica.Sintatico;
import analise.sintatica.suporte.Arvore;

public class SemanticaTest {

	@Test
	public void testArquivoComComentario1() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoComentario.txt");
		
		sintatico.executa();
		
		Semantica.executa(Arvore.getRaiz());
		
		Assert.assertEquals(13, Semantica.getLista().size());
	}
	
//	@Test
//	@Ignore
//	public void testaFluxoDeclaraFuncao() throws Throwable {
//		
//		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoDeclaraFuncao.txt");
//		
//		sintatico.executa();
//		
//		Semantica.executa(Arvore.getRaiz());
//		
//		Assert.assertEquals(25, Semantica.getLista().size());
//	}


}
