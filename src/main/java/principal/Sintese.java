package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.SelecaoDeInstrucao;

public class Sintese {

	public static void executa() throws IOException {
		GeraCodigoIntermediario ci = new GeraCodigoIntermediario();
		ci.executa();
		
		escreveArquivoCodigoIntermediario(ci);
		
		SelecaoDeInstrucao si = new SelecaoDeInstrucao(ci);
		si.executa();
		
		escreveArquivoCodigoSI(si);
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
	
	public static void escreveArquivoCodigoSI(SelecaoDeInstrucao si) throws IOException {
		File arquivoCI = new File("si.txt");
		
		if (!arquivoCI.exists())
			arquivoCI.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoCI);
		
		for (Label label : si.getLabels())
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				fw.write(ri.toString() + "\n");
		
		fw.close();
	}
}
