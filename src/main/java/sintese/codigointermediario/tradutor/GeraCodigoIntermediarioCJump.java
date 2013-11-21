package sintese.codigointermediario.tradutor;

import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCJump;
import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;

public class GeraCodigoIntermediarioCJump {

	public static void geraCJump(String lugar, List<RepresentacaoIntermediaria> buffer) {
		buffer.add(new RepresentacaoIntermediariaCJump(getCondicao(buffer), "L" + lugar));
	}
	
	private static String getCondicao(List<RepresentacaoIntermediaria> buffer) {
		RepresentacaoIntermediaria ri = buffer.get(buffer.size() - 1);
		
		return ((RepresentacaoIntermediariaCopy)ri).getDestino();
	}
}
