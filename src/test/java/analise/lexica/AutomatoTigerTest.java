package analise.lexica;

import static analise.lexica.Suporte.percorreAutomato;
import static org.junit.Assert.*;

import org.junit.Test;

import analise.lexica.automato.Automato;
import analise.lexica.automato.AutomatoException;
import analise.lexica.automato.Estado;

public class AutomatoTigerTest {

	@Test
	public void identificaPalavra() throws Throwable {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("palavra ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 2", 2, estadoAtual.getId().intValue());
	}
	
	@Test
	public void identificaNumero() throws Throwable {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("99999 ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 4", 4, estadoAtual.getId().intValue());
	}
	
	@Test
	public void identificaSimbolos() throws AutomatoException {
		Automato automato = AutomatoTiger.implementa();
		
		String entrada = "+-*";
		
		for (Character cada : entrada.toCharArray()) {
			Estado estadoAtual = automato.getEstadoInicial();
			
			estadoAtual = percorreAutomato(cada.toString() + " ", automato, estadoAtual);
			
			assertEquals("Estado final deveria ser 6", 6, estadoAtual.getId().intValue());
		}	
	}
	
	@Test
	public void reconheceDiferente() throws AutomatoException {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("<> ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 6", 6, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMenorIgual() throws AutomatoException {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("<=", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 8", 8, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMenor() throws AutomatoException {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("< ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 6", 6, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMaiorIgual() throws Exception {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(">=", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 10", 10, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMaior() throws AutomatoException {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("> ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 6", 6, estadoAtual.getId().intValue());
	}
}
