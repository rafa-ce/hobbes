package sintese.selecao.instrucao;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.SelecaoDeInstrucao;
import analise.semantica.Semantica;
import analise.sintatica.Sintatico;

public class SelecaoDeInstrucaoTest {

	@Test
	public void selecaoDeInstrucaoHappyDay() throws Throwable {
			Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIHappyDay.txt");
			sintatico.executa();
			
			Semantica semantico = new Semantica();
			semantico.executa();
			
			GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
			ci.executa(0);
			
			assertEquals(1, ci.getLabels().size());
			
			SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
			si.executa();
			
			Assert.assertEquals(1, si.getLabels().size());
			
			List<String> esperado = Arrays.asList("MOV 1, t0",
					"MOV 3, t1", "ADD t0, t1", "MOV t1, tmp3", "MOV tmp3, t2");
			
			assertCodigoIntemediario(si, esperado);
			
	}
	
	@Test
	public void geraCodigoExpressaoDoisOperadoresMaisMenos() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIDoisOperadoresMaisMenos.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa(0);
		
		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		List<String> esperado = Arrays.asList("MOV 0, t0", "MOV 1, t1", "MOV 2, t2",
				"ADD t0, t1", "MOV t1, tmp4", "SUB tmp4, t2", "MOV t2, tmp5", "MOV tmp5, t3");
		
		assertCodigoIntemediario(si, esperado);
	}
	
	@Test
	public void geraCodigoExpressaoVariosOperadores() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIVariosOperadores.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa(0);
		
		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		List<String> esperado = Arrays.asList("MOV 1, t0", "MOV 2, t1", "MOV 3, t2",
				"MUL t0, t1", "MOV t1, tmp4", "MOV 10, tmp8", "DIV t2, tmp8", "MOV tmp8, tmp5",
				"MOV 5, tmp9", "ADD tmp4, tmp9", "MOV tmp9, tmp6", "SUB tmp6, tmp5", "MOV tmp5, tmp7", "MOV tmp7, t3");
		
		assertCodigoIntemediario(si, esperado);
	}
	
	@Test
	public void geraCodigoIntermediarioIf() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoIf.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa(0);

		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		Assert.assertEquals(4, si.getLabels().size());
		
	}
	
	public void assertCodigoIntemediario(SelecaoDeInstrucao si, List<String> esperado) {
		Integer i = 0;
		
		for (Label label : si.getLabels()) {
			for (RepresentacaoIntermediaria ri : label.getInstrucoes()) {
				assertEquals(esperado.get(i), ri.toString());;
				i++;
			}
		}
	}

}
