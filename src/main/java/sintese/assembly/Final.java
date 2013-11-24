package sintese.assembly;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;

public class Final extends RepresentacaoIntermediaria {
	
	private String finalDoCodigo;
	
	public Final() {
		StringBuilder fim = new StringBuilder();
		
		fim.append("	movl $0,%ebx\n");
		fim.append("	movl $1,%eax\n");
		fim.append("	int $0x80\n");
		
	  	finalDoCodigo = fim.toString();
	}
	
	@Override
	public String toString() {
		return finalDoCodigo;
	}

}
