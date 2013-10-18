package analise.sintatica;

import static analise.sintatica.naoterminal.NaoTerminal.geraProducao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import utils.Token;
import analise.lexica.Lexico;
import analise.sintatica.arvore.No;
import analise.sintatica.naoterminal.Prog;

public class Sintatico {
	
	private static final Token TOKEN_FIM_DA_PILHA = new Token("$", 0, 0, "Final do Arquivo");
	private Lexico lexico;
	private Stack<String> pilha;
	private No raiz;
	private No noAtual;
	
	public Sintatico(String entrada) {
		lexico = new Lexico(entrada);
		iniciaPilha();
		iniciaASA();
	}
	
	private void iniciaASA() {
		raiz = No.criaNo(Prog.codigo(), null, new ArrayList<No>());
	}

	public void executa() throws Throwable {
		noAtual = raiz;
		
		while (lexico.hasToken()) {
			
			Token token = lexico.getNextToken();
			
			while(isNaoTerminal(pilha.lastElement())) {
				String topo = pilha.pop();
				List<String> producaoGerada = geraProducao(topo, token);
				empilhaProducao(producaoGerada);
				noAtual.criaFilhos(producaoGerada);
				noAtual = noAtual.proximo();
			}
				
			validaToken(token);
			noAtual.trocaConteudo(token);
			noAtual = noAtual.proximo();
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
		
		noAtual.criaFilhos(Arrays.asList("ε"));
		
		noAtual = noAtual.proximo();
		noAtual = noAtual.proximo();
		
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
	
	public void printArvore() {
		
	}
}
