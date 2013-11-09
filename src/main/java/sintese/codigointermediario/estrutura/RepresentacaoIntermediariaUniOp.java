package sintese.codigointermediario.estrutura;

public class RepresentacaoIntermediariaUniOp extends RepresentacaoIntermediaria {
	
	private String resultado;
	private String operador;
	private String arg;

	public RepresentacaoIntermediariaUniOp(String resultado, String operador, String arg) {
		this.resultado = resultado;
		this.operador = operador;
		this.arg = arg;
	}

}
