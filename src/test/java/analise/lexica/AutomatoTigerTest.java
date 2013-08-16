package analise.lexica;

import static analise.lexica.Suporte.percorreAutomato;
import static org.junit.Assert.*;

import org.junit.Test;

import analise.lexica.automato.Automato;
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
	public void identificaSimbolos() {
		Automato automato = AutomatoTiger.implementa();
		
		String entrada = "+-*";
		
		for (Character cada : entrada.toCharArray()) {
			Estado estadoAtual = automato.getEstadoInicial();
			
			estadoAtual = percorreAutomato(cada.toString() + " ", automato, estadoAtual);
			
			assertEquals("Estado final deveria ser 6", 6, estadoAtual.getId().intValue());
		}	
	}
	
	@Test
	public void reconheceDiferente() {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("<> ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 8", 8, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMenorIgual() {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("<= ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 9", 9, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMenor() {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("< ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 10", 10, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMaiorIgual() {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(">= ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 12", 12, estadoAtual.getId().intValue());
	}
	
	@Test
	public void reconheceMaior() {
		Automato automato = AutomatoTiger.implementa();
		
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato("> ", automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 13", 13, estadoAtual.getId().intValue());
	}
}
