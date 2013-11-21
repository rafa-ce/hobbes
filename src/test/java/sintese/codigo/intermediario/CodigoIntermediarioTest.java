package sintese.codigo.intermediario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import analise.semantica.Semantica;
import analise.sintatica.Sintatico;

public class CodigoIntermediarioTest {

	@Test
	public void geraCodigoHappyDay() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIHappyDay.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		assertEquals(1, ci.getLabels().size());
		
		List<String> esperado = Arrays.asList("cp(t0, 1)", "cp(t1, 3)",
											"binop(+, t3, t0, t1)", "cp(t2, t3)");
		
		assertCodigoIntemediario(ci, esperado);
	}

	@Test
	public void geraCodigoExpressaoDoisOperadoresMaisMenos() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIDoisOperadoresMaisMenos.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		List<String> esperado = Arrays.asList("cp(t0, 0)", "cp(t1, 1)", "cp(t2, 2)",
					"binop(+, t4, t0, t1)", "binop(-, t5, t4, t2)",
					"cp(t3, t5)");
		
		assertCodigoIntemediario(ci, esperado);
	}
	
	@Test
	public void geraCodigoExpressaoVariosOperadores() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIVariosOperadores.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		List<String> esperado = Arrays.asList("cp(t0, 1)", "cp(t1, 2)", "cp(t2, 3)",	"binop(*, t4, t0, t1)",
				"binop(/, t5, t2, 10)", "binop(+, t6, t4, 5)",
				"binop(-, t7, t6, t5)", "cp(t3, t7)");
		
		assertCodigoIntemediario(ci, esperado);
	}
	
	@Test
	public void geraCodigoExpressaoDoisOperadoresVezesDividir() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIDoisOperadoresVezesDividir.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
			}
		}
		
	}
	
	@Test
	public void geraCodigoExpressaoComParenteses() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIExpressaoComParenteses.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		List<String> esperado = Arrays.asList("cp(t0, 0)","cp(t1, 1)","cp(t2, 2)",
				"binop(-, t5, t1, t2)","cp(t4, t5)",
				"binop(*, t7, t4, 10)","cp(t6, t7)",
				"binop(/, t8, t6, 2)", "binop(+, t9, t0, t8)",
				"cp(t3, t9)");
		
		assertCodigoIntemediario(ci, esperado);
		
	}
	
	@Test
	@Ignore
	public void geraCodigoIntermediarioWhile() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoWhileCi.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
			}
		}
		
		Assert.fail();
	}
	
	@Test
	@Ignore
	public void geraCodigoIntermediarioIf() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoIf.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
			}
		}
		
		Assert.fail();
	}
	
	@Test
	@Ignore
	public void geraCodigoIntermediarioIfElse() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoIfElse.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
			}
		}
		
		Assert.fail();
	}
	
	public void assertCodigoIntemediario(GeraCodigoIntermediario ci,
			List<String> esperado) {
		Integer i = 0;
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				assertEquals(esperado.get(i), ri.toString());;
				i++;
			}
		}
	}
}
