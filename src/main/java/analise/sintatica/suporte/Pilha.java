package analise.sintatica.suporte;

import java.util.List;
import java.util.Stack;

import utils.Token;
import analise.sintatica.naoterminal.NaoTerminal;
import analise.sintatica.naoterminal.Prog;

public class Pilha {
	
	private static final Token TOKEN_FIM_DA_PILHA = new Token("$", 0, 0, "Final do Arquivo");
	
	private static Stack<String> pilha;

	public static void iniciaPilha() {
		pilha = new Stack<String>();
		
		pilha.push("$");
		pilha.push(Prog.codigo());
	}

	public static String getTopo() {
		return pilha.lastElement();
	}
	
	public static void empilha(List<String> lista) {
		if (lista.get(0).equals("ε"))
			return;
		
		for (int i = lista.size() - 1; i >= 0; i--)
			pilha.push(lista.get(i));				
	}
	
	public static String desempilha() {
		return pilha.pop();
	}
	
	public static Boolean topoIsNaoTerminal() {
		return NaoTerminal.naoTerminais().contains(getTopo());
	}
	
	public static Stack<String> getPilha() {
		return pilha;
	}
	
	public static void finalizaPilha() {
		if (pilha.lastElement().equals("$"))
			return;
		
		desempilha();
		
		if (!topoIsNaoTerminal())
			return;
		
		finalizaPilha();
	}
}
