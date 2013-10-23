package analise.semantica;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import analise.sintatica.Sintatico;
import analise.sintatica.suporte.No;

public class SemanticaTest {

	@Test
	@Ignore
	public void test() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoComentario.txt");
		
		No raiz = sintatico.executa();
		
		Semantica.executa(raiz);
		
		Assert.assertEquals(13, Semantica.getLista().size());
	}

}
