package sintese.codigointermediario.estrutura;

public class RepresentacaoIntermediariaCopy extends RepresentacaoIntermediaria{

	private String destino;
	private String origem;
	
	public RepresentacaoIntermediariaCopy(String destino, String origem) {
		this.destino = destino;
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	@Override
	public String toString() {
		return "cp(" + destino + ", " + origem + ")";
	}
	
}
