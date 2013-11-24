package sintese.assembly;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sintese.assembly.GeraAssembly;
import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.SelecaoDeInstrucao;
import analise.semantica.Semantica;
import analise.sintatica.Sintatico;

public class AssemblyTest {

	@Test
	public void test() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIHappyDay.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa(0);
		
		assertEquals(1, ci.getLabels().size());
		
		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		GeraAssembly ga = new GeraAssembly(si);
		ga.executa();
		
		for (Label label : ga.getLabels()) {
			System.out.println(label.getNome());
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				System.out.println(ri.toString());
		}
	}

}
