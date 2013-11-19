package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;

public class Sintese {

	public static void executa() throws IOException {
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		
		ci.executa();
		
		escreveArquivoCodigoIntermediario(ci);
	}

	public static void escreveArquivoCodigoIntermediario(GeraCodigoIntermediario ci) throws IOException {
		File arquivoCI = new File("ci.txt");
		
		if (!arquivoCI.exists())
			arquivoCI.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoCI);
		
		for (Label label : ci.getLabels())
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				fw.write(ri.toString() + "\n");
		
		fw.close();
	}
}
