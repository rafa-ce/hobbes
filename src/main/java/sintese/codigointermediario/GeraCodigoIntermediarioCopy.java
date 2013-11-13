package sintese.codigointermediario;

import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediariaCopy;
import analise.lexica.token.Token;

public class GeraCodigoIntermediarioCopy {
	
	public static RepresentacaoIntermediariaCopy criaCopy(List<Token> instrucao) {
		return new RepresentacaoIntermediariaCopy(getPrintIntermediario(instrucao, 0), 
													getPrintIntermediario(instrucao, 2));
	}
	
	public static String getPrintIntermediario(List<Token> instrucao, Integer i) {
		Token token = instrucao.get(i);
		if (token.isIdentificador())
			return token.getTemporario();
		
		return token.getValor();
	}

}
