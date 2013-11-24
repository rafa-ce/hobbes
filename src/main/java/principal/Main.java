package principal;

public class Main {
	
	public static void main(String[] args) throws Throwable {
		Opcoes.verifica(args);
					
		String analise = Analise.executa(args[0]);
		
		if (analise.equals("Ok"))
			Sintese.executa();
	}

}
