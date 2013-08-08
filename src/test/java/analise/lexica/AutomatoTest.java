package analise.lexica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import analise.lexica.automato.Automato;
import analise.lexica.automato.Estado;
import analise.lexica.automato.Transicao;

public class AutomatoTest {

	private static final String LETRA = "[a-zA-Z]";
	private static final String LETRA_E_UNDERLINE = "[a-zA-Z_]";
	private static final String ESPACO_EM_BRANCO = "\\s";

	@Test
	public void criaAtutomatoHappyDay() {
		Automato automato = criaAutomatoComDoisEstados();
		
		assertEquals("Estado Inicial", 0, automato.getEstadoInicial().getId().intValue());
		assertEquals("Quantidade de estados finais", 1, automato.getEstadosFinais().size());
		assertEquals("Estado final", 1, automato.getEstadosFinais().get(0).getId().intValue());
		assertEquals("Estados", 2, automato.getEstados().size());
		assertEquals("Transição", 1, automato.getTransicoes().size());
		
	}
	
	@Test
	public void fazTransicaoDeUmEstadoParaOutro() throws Throwable {
		String entrada = " ";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(entrada, automato, estadoAtual);
		
		assertEquals("Estado final", automato.getEstadosFinais().get(0).getId().intValue(), estadoAtual.getId().intValue());
	}

	@Test(expected = Exception.class)
	public void leCaractereInvalido() throws Throwable {
		String entrada = "c";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(entrada, automato, estadoAtual);
	}
	
	@Test
	public void criaAutomatoQueIdentificaPalavra() throws Throwable {
		
		String result = "";
		String entrada = "palavra";
		
		Automato automato = criaAutomatoPalavra();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			automato.getProximoEstado(estadoAtual, cada.toString());
			result += cada;
		}
		
		assertEquals(entrada, result);	
	}
	
	@Test(expected = Exception.class)
	public void criaAutomatoQueIdentificaPalavraErro() throws Throwable {
		
		String entrada = "pala vra";
		
		Automato automato = criaAutomatoPalavra();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			automato.getProximoEstado(estadoAtual, cada.toString());
		}
	}
	
	@Test
	public void criaAutomatoQueIdentificaPalavraOuUnderline() throws Throwable {
		String entrada = "p_a_l_a_v_r_a";
		String result = "";
		
		Automato automato = criaAutomatoPalavraUnderline();
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
			result += cada.toString();
		}
		
		assertEquals(entrada, result);
	}
	
	private Estado percorreAutomato(String entrada, Automato automato, Estado estadoAtual) throws Throwable {
		for (Character cada : entrada.toCharArray()) {
			estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
		}
		
		return estadoAtual;
	}

	private Automato criaAutomatoPalavraUnderline() {
		Automato automato = new Automato();
		
		Estado estadoInicial = new Estado(0, "inicial");
		Estado estadoFinal = new Estado(1, "final");
		
		automato.setEstadoInicial(estadoInicial);
		automato.addEstadoFinal(estadoFinal);
		
		automato.addTransicao(new Transicao(estadoInicial, estadoFinal, LETRA));
		automato.addTransicao(new Transicao(estadoFinal, estadoFinal, LETRA_E_UNDERLINE));
		
		return automato;
	}

	private Automato criaAutomatoPalavra() {
		
		Automato automato = new Automato();
		
		Estado estadoInicialEFinal = new Estado(0, "inicial");
		
		automato.setEstadoInicial(estadoInicialEFinal);
		automato.addEstadoFinal(estadoInicialEFinal);
		
		automato.addTransicao(new Transicao(estadoInicialEFinal, estadoInicialEFinal, LETRA));
		
		return automato;
	}

	private Automato criaAutomatoComDoisEstados() {
		Automato automato = new Automato();
		
		Estado estadoInicial = new Estado(0, "inicial");
		Estado estadoFinal = new Estado(1, "final");
		
		automato.setEstadoInicial(estadoInicial);
		automato.addEstadoFinal(estadoFinal);
		
		automato.addTransicao(new Transicao(
				estadoInicial, 
				estadoFinal, 
				ESPACO_EM_BRANCO));
		
		return automato;
	}

}
