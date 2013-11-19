package sintese.codigointermediario.estrutura;


public class RepresentacaoIntermediariaJump extends RepresentacaoIntermediaria{

	private String lugar;

	public RepresentacaoIntermediariaJump(String lugar) {
		this.lugar = lugar;
	}
	
	@Override
	public String toString() {
		return "goto " + lugar;
	}
	
}
