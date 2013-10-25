package principal;

import analise.sintatica.Sintatico;

public class Analise {

	public static void executa(String entrada) {
		
		Sintatico sintatico = new Sintatico(entrada);
		String resultado = "Ok";
		
		try {
			sintatico.executa();
		} catch (Throwable e) {
			resultado = e.getMessage();
		}
		
		System.out.println(resultado);
	}
}
