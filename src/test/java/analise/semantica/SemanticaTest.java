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
	}
	
	@Test
	public void testaVariosEscopos() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoVariosEscopos.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
	public void testaSemanticaFunction() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/ArquivoDeclaraFuncao.txt");
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
	}

}
