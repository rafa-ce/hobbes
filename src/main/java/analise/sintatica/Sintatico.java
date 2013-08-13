package analise.sintatica;

import java.io.BufferedReader;

import analise.lexica.Lexico;

public class Sintatico {
	
	private Lexico lexico;
	private Integer linha;
	
	public Sintatico() {
		linha = 0;
	}
	
	public void lerArquivo(BufferedReader arquivo) throws Throwable {
		
		while (arquivo.ready()) {
			lexico.getNextToken(arquivo.readLine());
			linha++;
		}
		arquivo.close();
	}

}
