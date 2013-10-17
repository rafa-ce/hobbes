package analise.sintatica;

import static analise.sintatica.naoterminal.NaoTerminal.geraProducao;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import utils.Token;
import analise.lexica.Lexico;

public class Sintatico {
	
	private static final Token TOKEN_FIM_DA_PILHA = new Token("$", 0, 0, "Final do Arquivo");
	private Lexico lexico;
	private Stack<String> pilha;
	
	public Sintatico(String entrada) {
		lexico = new Lexico(entrada);
		iniciaPilha();
	}
	
	public void executa() throws Throwable {
		while (lexico.hasToken()) {
			
			Token token = lexico.getNextToken();
			
			while(isNaoTerminal(pilha.lastElement())) {
				String topo = pilha.pop();
				List<String> producaoGerada = geraProducao(topo, token);
				empilhaProducao(producaoGerada);
			}
				
			validaToken(token);		
		}

		finalizaPilha();

	}
	
	private void finalizaPilha() {
		
		if (pilha.lastElement().equals("$"))
			return;
		
		String topo = pilha.pop();

		if (!isNaoTerminal(topo))
			return;
		
		if (!geraProducao(topo, TOKEN_FIM_DA_PILHA).get(0).equals("ε"))
			return;
		
		finalizaPilha();
	}

	private Boolean validaToken(Token token) {
		String topo = pilha.pop();
		
		if (token.isIdentificador() || token.isNumero())
			return token.getTipo().equals(topo);
		
		return token.getValor().equals(topo);
	}

	private void empilhaProducao(List<String> producaoGerada) {
		if (producaoGerada.get(0).equals("ε"))
			return;
		
		for (int i = producaoGerada.size() - 1; i >= 0; i--)
			pilha.push(producaoGerada.get(i));			
				
	}

	private void iniciaPilha() {
		pilha = new Stack<String>();
		
		pilha.push("$");
		pilha.push("<Prog>");
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

	public Stack<String> getPilha() {
		return pilha;
	}
}
