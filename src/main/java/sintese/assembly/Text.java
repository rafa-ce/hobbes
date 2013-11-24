package sintese.assembly;

import sintese.codigointermediario.estrutura.RepresentacaoIntermediaria;

public class Text extends RepresentacaoIntermediaria {
	
	private String text;
	
	public Text() {
		this.text = "	.global _start";
	}
	
	@Override
	public String toString() {
		return text;
	}

}
