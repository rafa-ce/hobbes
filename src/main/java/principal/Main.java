package principal;

public class Main {
	
	public static void main(String[] args) throws Throwable {
//		configuracoes
					
		Analise.executa(args[0]);
		
		Sintese.executa();
	}

}
