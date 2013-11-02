package analise.semantica;

import org.junit.Test;

import analise.sintatica.Sintatico;

public class SemanticaTest {

	@Test
	public void arquivoComComentario() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoComentario.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test(expected = SemanticoException.class)
	public void arquivoComComentarioErro() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoComentarioErro.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
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
	}

}
