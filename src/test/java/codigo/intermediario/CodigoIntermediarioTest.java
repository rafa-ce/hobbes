package codigo.intermediario;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
		
		List<String> esperado = Arrays.asList("cp(t0, 1)", "cp(t1, 3)", "binop(+, t2, t0, t1)");
		
		Integer i = 0;
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				Assert.assertEquals(esperado.get(i), ri.toString());;
				i++;
			}
		}
		
	}
	
	@Test
	public void geraCodigoExpressaoDoisOperadoresMaisMenos() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIDoisOperadoresMaisMenos.txt");
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
	public void geraCodigoExpressaoVariosOperadores() throws Throwable {
		
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIVariosOperadores.txt");
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
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
			}
		}
		
	}
	
	@Test
	public void geraCodigoIntermediarioWhile() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoWhile.txt");
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
	}
	
	@Test
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
	}
}
