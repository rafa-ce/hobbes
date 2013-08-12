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
		
		String entrada = "palavra ";
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(entrada, automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 2", 2, estadoAtual.getId().intValue());
	}
	
	@Test
	public void identificaNumero() throws Throwable {
		Automato automato = AutomatoTiger.implementa();
		
		String entrada = "99999 ";
		Estado estadoAtual = automato.getEstadoInicial();
		
		estadoAtual = percorreAutomato(entrada, automato, estadoAtual);
		
		assertEquals("Estado final deveria ser 4", 4, estadoAtual.getId().intValue());
	}

}
