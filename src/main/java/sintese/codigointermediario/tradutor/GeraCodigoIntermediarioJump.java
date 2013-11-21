package sintese.codigointermediario.tradutor;

import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaJump;

public class GeraCodigoIntermediarioJump {

	public static void geraJump(String lugar, List<RepresentacaoIntermediaria> buffer) {
		buffer.add(new RepresentacaoIntermediariaJump("L" + lugar));
	}
}
