package codigo.intermediario;

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
		
		for (Label label : ci.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				System.out.println(ri.toString());
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

}
