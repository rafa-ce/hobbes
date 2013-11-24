package sintese.assembly;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;

public class Inicio extends RepresentacaoIntermediaria {
	
	private String iniciolDoCodigo;
	
	public Inicio() {
		StringBuilder fim = new StringBuilder();
		
		fim.append("	pushl %ebp\n");
		fim.append("	movl %ebp, %esp");
		
	  	iniciolDoCodigo = fim.toString();
	}
	
	@Override
	public String toString() {
		return iniciolDoCodigo;
	}

}
