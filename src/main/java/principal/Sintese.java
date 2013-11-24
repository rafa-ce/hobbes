package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import sintese.assembly.GeraAssembly;
import sintese.codigointermediario.GeraCodigoIntermediario;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.suporte.Label;
import sintese.selecaodeinstrucao.SelecaoDeInstrucao;

public class Sintese {

	public static void executa() throws IOException {
		
		GeraCodigoIntermediario ci = null;
		if (Opcoes.geraCI()) {
			ci = new GeraCodigoIntermediario();
			ci.executa(0);
			escreveArquivoCodigoIntermediario(ci);			
		}
		
		SelecaoDeInstrucao si = null;
		if (Opcoes.geraCI() && Opcoes.geraSI()) {
			si = new SelecaoDeInstrucao(ci);
			si.executa();
			escreveArquivoCodigoSI(si);
		}

		if (Opcoes.geraCI() && Opcoes.geraSI() && Opcoes.geraAssembly()) {
			GeraAssembly assembly = new GeraAssembly(si);
			assembly.executa();
			escreveArquivoAssembly(assembly);			
		}
	}

	private static void escreveArquivoAssembly(GeraAssembly assembly) throws IOException {
		File arquivoCI = new File("assembly.s");
		
		if (!arquivoCI.exists())
			arquivoCI.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoCI);
		fw.write(".code32" + "\n");
		
		for (Label label : assembly.getLabels()) {
			fw.write(label.getNome() + "\n");
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				fw.write(ri.toString() + "\n");
			
			fw.write("\n");
		}
		fw.close();		
	}

	public static void escreveArquivoCodigoIntermediario(GeraCodigoIntermediario ci) throws IOException {
		File arquivoCI = new File("ci.txt");
		
		if (!arquivoCI.exists())
			arquivoCI.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoCI);
		
		for (Label label : ci.getLabels()) {
			fw.write(label.getNome() + "\n");
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				fw.write(ri.toString() + "\n");
			
			fw.write("\n");
		}
		fw.close();
	}
	
	public static void escreveArquivoCodigoSI(SelecaoDeInstrucao si) throws IOException {
		File arquivoCI = new File("si.txt");
		
		if (!arquivoCI.exists())
			arquivoCI.createNewFile();
		
		FileWriter fw = new FileWriter(arquivoCI);
		
		for (Label label : si.getLabels()) {
			fw.write(label.getNome() + "\n");
			for (RepresentacaoIntermediaria ri : label.getInstrucoes())
				fw.write(ri.toString() + "\n");
			fw.write("\n");
		}
		fw.close();
	}
}
