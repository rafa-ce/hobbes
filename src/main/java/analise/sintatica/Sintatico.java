package analise.sintatica;

import static analise.sintatica.naoterminal.NaoTerminal.geraProducao;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import utils.Token;
import analise.lexica.Lexico;

public class Sintatico {
	
	private Lexico lexico;
	private Stack<String> pilha;
	
	public Sintatico(String entrada) {
		lexico = new Lexico(entrada);
		iniciaPilha();
	}
	
	public void montaASA() throws Throwable {
		
		while (lexico.hasToken()) {
			
			Token token = lexico.getNextToken();			
			
			while(isNaoTerminal(pilha.firstElement())) {
				String topo = pilha.pop();
				List<String> producaoGerada = geraProducao(topo, token);
				empilhaProducao(producaoGerada);
			}
				
			validaToken(token);
						
		}		
	}
	
	private Boolean validaToken(Token token) {
		String topo = pilha.pop();
		
		if (token.isIdentificador() || token.isNumero())
			return token.getTipo().equals(topo);
		
		return token.getValor().equals(topo);
	}

	private void empilhaProducao(List<String> producaoGerada) {
		for (int i = producaoGerada.size(); i < 0; i--)
			pilha.push(producaoGerada.get(i));			
				
	}

	private void iniciaPilha() {
		pilha.push("$");
		pilha.push("<prog>");
	}
	
	public static Boolean isNaoTerminal(String valor) {
		List<String> naoTerminais = Arrays.asList(
				"<Prog>"
				,"<Lista>"
				,"<Item>"
				,"<Exp>"
				,"<ExpOR>"
				,"<ExpAND>"
				,"<ExpORPr>"
				,"<ExpANDPr>"
				,"<ArithExp>"
				,"<RelExp>"
				,"<Term>"
				,"<TermPr>"
				,"<FactorPr>"
				,"<Factor>"
				,"<IfElse>"
				,"<LValue>"
				,"<LValuePr>"
				,"<Outro>"
				,"<ArgList>"
				,"<ArgListPr>"
				,"<RelOp>"
				,"<ExpList>"
				,"<ExpPr>"
				,"<Dec>"
				,"<FieldList>"
				,"<FieldListPr>");
		
		return naoTerminais.contains(valor);
	}
}
