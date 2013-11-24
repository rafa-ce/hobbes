package sintese.assembly;

import java.util.List;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;
import analise.lexica.token.Token;

public class Bss extends RepresentacaoIntermediaria {
	
	private List<Token> variaveis;
	
	public Bss(List<Token> variaveis) {
		this.variaveis = variaveis;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder(".bss\n");
		
		for (Token token : variaveis)
			retorno.append("	.lcomm " + token.getTemporario() + " , 1000\n");
		
		return retorno.toString();
	}

}
