package sintese.codigointermediario.estrutura;


public class RepresentacaoIntermediariaCJump extends RepresentacaoIntermediaria{

	private String condicao;
	private String lugar;
	
	public RepresentacaoIntermediariaCJump(String condicao, String lugar) {
		this.condicao = condicao;
		this.lugar = lugar;
	}
	
}
