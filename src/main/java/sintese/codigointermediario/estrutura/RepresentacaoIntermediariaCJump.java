package sintese.codigointermediario.estrutura;


public class RepresentacaoIntermediariaCJump extends RepresentacaoIntermediaria{

	private String condicao;
	private String lugar;
	
	public RepresentacaoIntermediariaCJump(String condicao, String lugar) {
		this.condicao = condicao;
		this.lugar = lugar;
	}
	
	@Override
	public String toString() {
		return "if " + condicao + " goto " + lugar;
	}
	
	public String getLugar() {
		return lugar;
	}
	
}
