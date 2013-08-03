package analise.lexica;

import static org.junit.Assert.*;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;
import analise.lexica.automato.Transicao;

public class AutomatoTest {

	private static final String ESPACO_EM_BRANCO = "\\s";

	@Test
	public void criaAtutomatoHappyDay() {
		Automato automato = criaAutomatoComDoisEstados();
		
		assertEquals("Estado Inicial", 0, automato.getEstadoInicial().getId().intValue());
		assertEquals("Quantidade de estados finais", 1, automato.getEstadosFinais().size());
		assertEquals("Estado final", 1, automato.getEstadosFinais().get(0).getId().intValue());
		assertEquals(2, automato.getEstados().size());
		
	}
	
	@Test
	public void fazTransicaoDeUmEstadoParaOutro() throws Throwable {
		String entrada = " ";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
		}
		
		assertEquals("Estado final", automato.getEstadosFinais().get(0).getId(), estadoAtual.getId());
	}
	
	@Test(expected = Exception.class)
	public void leCaractereInvalido() throws Throwable {
		String entrada = "c";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
		}
	}

	private Automato criaAutomatoComDoisEstados() {
		Automato automato = new Automato();
		
		Estado estadoInicial = new Estado(0);
		automato.setEstadoInicial(estadoInicial);
		
		List<Estado> estadosFinais = new ArrayList<Estado>();
		Estado estadoFinal = new Estado(1);
		estadosFinais.add(estadoFinal);
		automato.setEstadosFinais(estadosFinais);
		
		List<Estado> estados = new ArrayList<Estado>();
		estados.add(estadoInicial);
		estados.add(estadoFinal);
		automato.setEstados(estados);
		
		Transicao transicao = new Transicao(estadoInicial, estadoFinal, ESPACO_EM_BRANCO);
		List<Transicao> transicoes = new ArrayList<Transicao>();
		transicoes.add(transicao);
		automato.setTransicoes(transicoes);
		
		return automato;
	}

}
