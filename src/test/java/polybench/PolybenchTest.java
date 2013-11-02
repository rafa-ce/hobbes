package polybench;

import org.junit.Test;

import analise.semantica.Semantica;
import analise.sintatica.Sintatico;

public class PolybenchTest {

	@Test
	public void lu() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/polybench/lu.txt");
		sintatico.executa();

		Semantica semantico = new Semantica();
		semantico.executa();
	}
}
