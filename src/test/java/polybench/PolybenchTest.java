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
	
	@Test
	public void doitgen() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/polybench/doitgen.txt");
		sintatico.executa();

		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
	public void durbin() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/polybench/durbin.txt");
		sintatico.executa();

		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
	public void atax() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/polybench/atax.txt");
		sintatico.executa();

		Semantica semantico = new Semantica();
		semantico.executa();
	}
	
	@Test
	public void gemm() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/polybench/gemm.txt");
		sintatico.executa();

		Semantica semantico = new Semantica();
		semantico.executa();
	}
}
