package analise.sintatica.suporte;

import java.util.ArrayList;

import analise.sintatica.naoterminal.Prog;

public class Arvore {
	
	private static No raiz;

	private Arvore(No raiz) {
		setRaiz(raiz);
	}
	
	public static void criaRaiz() {
		new Arvore(No.criaNo(Prog.codigo(), null, new ArrayList<No>(), 0));
	}
	
	public static No getRaiz() {
		return raiz;
	}

	public void setRaiz(No no) {
		raiz = no;
	}

	public static void printArvore() {
		No no = getRaiz();
		
		while (no != null) {
			for (int i = 0; i < no.getProfundidade(); i++) {
				System.out.print(" - ");
			}
			
			System.out.println(no.printConteudo());
			
			no = no.proximo();
		}
	}
	
	public static void finaliza(No no) {
		while (no != null)  {
			no = no.proximo();
		}
	}
}
