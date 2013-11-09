package sintese.codigointermediario.estrutura;

import java.util.List;

public class RepresentacaoIntermediariaCall extends RepresentacaoIntermediaria{
	
	private List<String> parametros;
	private String funcao;
	private String resultado;
	
	public RepresentacaoIntermediariaCall(List<String> parametros, String funcao, String resultado) {
		this.parametros = parametros;
		this.funcao = funcao;
		this.resultado = resultado;
	}

}
