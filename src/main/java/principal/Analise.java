package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import analise.semantica.Semantica;
import analise.sintatica.Sintatico;
import analise.sintatica.suporte.Arvore;

public class Analise {

	public static void executa(String entrada) throws IOException {
		String resultado = "Ok";
		
		try {
			Sintatico sintatico = new Sintatico(entrada);
			sintatico.executa();
			
			Semantica semantica = new Semantica();
			semantica.executa();
		} catch (Throwable e) {
			resultado = e.getMessage();
		}
		
		System.out.println(resultado);
		
		if (resultado.equals("Ok"))
			escreveArvoreNoArquivo();
	}

	private static void escreveArvoreNoArquivo() throws IOException {
		File arquivoArvore = new File("arvore.txt");
		
		if (!arquivoArvore.exists())
			arquivoArvore.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoArvore);
		
		Arvore.escreveNoArquivo(fw);
		
		fw.close();
	}
}
