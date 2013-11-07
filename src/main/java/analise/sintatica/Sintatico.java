package analise.sintatica;

import static analise.sintatica.suporte.Pilha.iniciaPilha;

import java.util.List;

import utils.token.Token;
import analise.lexica.Lexico;
import analise.sintatica.naoterminal.NaoTerminal;
import analise.sintatica.suporte.Arvore;
import analise.sintatica.suporte.No;
import analise.sintatica.suporte.Pilha;


public class Sintatico {
	
	private Lexico lexico;
	
	public Sintatico(String entrada) {
		lexico = new Lexico(entrada);
		iniciaPilha();
		iniciaASA();
	}
	
	private void iniciaASA() {
		Arvore.criaRaiz();
	}
	
	public void executa() throws Throwable {
		
		No noAtual = Arvore.getRaiz();
		
		while (lexico.hasToken()) {
			
			Token token = lexico.getNextToken();
			
			if (token != null) {
				while (Pilha.topoIsNaoTerminal()) {
					List<String> producaoGerada = NaoTerminal.geraProducao(Pilha.getTopo(), token);
					Pilha.desempilha();
					Pilha.empilha(producaoGerada);
					noAtual.criaFilhos(producaoGerada); //TODO tratar null
					noAtual = noAtual.proximo();
				}
				
				if (!validaToken(token))
					throw new SintaticoException(token);
				
				noAtual.trocaConteudo(token);
				noAtual = noAtual.proximo();				
			}
		}
		
		Pilha.finaliza();
		Arvore.finaliza(noAtual);
	}
	
	private Boolean validaToken(Token token) {
		String topo = Pilha.desempilha();
		
		if (token.isIdentificador() || token.isNumero())
			return token.getTipo().equals(topo);
		
		return token.getValor().equals(topo);
	}
}
