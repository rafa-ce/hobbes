package analise.lexica;

import static analise.lexica.Suporte.percorreAutomato;
import static org.junit.Assert.assertEquals;
import static utils.ExpressaoRegular.*;

import org.junit.Test;

import analise.lexica.automato.Automato;
import analise.lexica.automato.AutomatoException;
import analise.lexica.automato.Estado;
import analise.lexica.automato.Transicao;

public class AutomatoTest {

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
	public void fazTransicaoDeUmEstadoParaOutro() {
		String entrada = " ";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		try {
			estadoAtual = percorreAutomato(entrada, automato, estadoAtual);
		} catch (AutomatoException e) {
			e.printStackTrace();
		}
		
		assertEquals("Estado final", automato.getEstadosFinais().get(0).getId().intValue(), estadoAtual.getId().intValue());
	}

	@Test(expected = AutomatoException.class)
	public void leCaractereInvalido() throws AutomatoException {
		String entrada = "c";
		
		Automato automato = criaAutomatoComDoisEstados();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		automato.getProximoEstado(estadoAtual, entrada);
	}
	
	@Test
	public void criaAutomatoQueIdentificaPalavra() {
		
		String result = "";
		String entrada = "palavra";
		
		Automato automato = criaAutomatoPalavra();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			try {
				automato.getProximoEstado(estadoAtual, cada.toString());
			} catch (AutomatoException e) {
				e.printStackTrace();
			}
			
			result += cada;
		}
		
		assertEquals(entrada, result);	
	}
	
	@Test(expected = AutomatoException.class)
	public void criaAutomatoQueIdentificaPalavraErro() throws AutomatoException {
		
		String entrada = "pala vra";
		
		Automato automato = criaAutomatoPalavra();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray())
			automato.getProximoEstado(estadoAtual, cada.toString());

	}
	
	@Test
	public void criaAutomatoQueIdentificaPalavraOuUnderline() {
		String entrada = "p_a_l_a_v_r_a";
		String result = "";
		
		Automato automato = criaAutomatoPalavraUnderline();
		Estado estadoAtual = automato.getEstadoInicial();
		
		for (Character cada : entrada.toCharArray()) {
			try {
				estadoAtual = automato.getProximoEstado(estadoAtual, cada.toString());
			} catch (AutomatoException e) {
				e.printStackTrace();
			}
			result += cada.toString();
		}
		
		assertEquals(entrada, result);
	}
	
	private Automato criaAutomatoPalavraUnderline() {
		Automato automato = new Automato();
		
		Estado estadoInicial = new Estado(0);
		Estado estadoFinal = new Estado(1);
		
		automato.setEstadoInicial(estadoInicial);
		automato.addEstadoFinal(estadoFinal);
		
		automato.addTransicao(new Transicao(estadoInicial, estadoFinal, LETRA));
		automato.addTransicao(new Transicao(estadoFinal, estadoFinal, LETRA_NUMERO_UNDERLINE));
		
		return automato;
	}

	private Automato criaAutomatoPalavra() {
		
		Automato automato = new Automato();
		
		Estado estadoInicialEFinal = new Estado(0);
		
		automato.setEstadoInicial(estadoInicialEFinal);
		automato.addEstadoFinal(estadoInicialEFinal);
		
		automato.addTransicao(new Transicao(estadoInicialEFinal, estadoInicialEFinal, LETRA));
		
		return automato;
	}

	private Automato criaAutomatoComDoisEstados() {
		Automato automato = new Automato();
		
		Estado estadoInicial = new Estado(0);
		Estado estadoFinal = new Estado(1);
		
		automato.setEstadoInicial(estadoInicial);
		automato.addEstadoFinal(estadoFinal);
		
		automato.addTransicao(new Transicao(
				estadoInicial, 
				estadoFinal, 
				ESPACO_EM_BRANCO));
		
		return automato;
	}

}
