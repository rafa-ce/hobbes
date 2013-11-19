package sintese.codigointermediario.tradutor;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaJump;
import sintese.codigointermediario.suporte.Label;



public class GeraCodigoIntermediarioJump {

	public static void geraJump(String lugar, Label label) {
		label.adicionaInstrucao(new RepresentacaoIntermediariaJump("L" + lugar));
	}
	
	

}
