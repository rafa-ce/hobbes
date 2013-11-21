package sintese.selecao.instrucao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
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
			
			List<String> esperado = Arrays.asList("MOV 1 t0",
					"MOV 3 t1", "ADD t0 t1", "MOV t1 t3", "MOV t3 t2");
			
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
		
		List<String> esperado = Arrays.asList("MOV 0 t0", "MOV 1 t1", "MOV 2 t2",
				"ADD t0 t1", "MOV t1 t4", "SUB t4 t2", "MOV t2 t5", "MOV t5 t3");
		
		assertCodigoIntemediario(si, esperado);
	}
	
	@Test
	@Ignore
	public void geraCodigoExpressaoVariosOperadores() throws Throwable {
		Sintatico sintatico = new Sintatico("src/test/resources/outros/ArquivoCIVariosOperadores.txt");
		sintatico.executa();
		
		Semantica semantico = new Semantica();
		semantico.executa();
		
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa(0);
		
		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		List<String> esperado = Arrays.asList("");
		
		assertCodigoIntemediario(si, esperado);
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
