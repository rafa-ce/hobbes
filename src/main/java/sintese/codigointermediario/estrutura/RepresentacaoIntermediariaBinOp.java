package sintese.codigointermediario.estrutura;

public class RepresentacaoIntermediariaBinOp extends RepresentacaoIntermediaria {

	private String result;
	private String operador;
	private String arg1;
	private String arg2;
	
	public RepresentacaoIntermediariaBinOp(String result, String operador, String arg1, String arg2) {
		this.result = result;
		this.operador = operador;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	public String getOperador() {
		return operador;
	}
	
	public String getResult() {
		return result;
	} 
	
	public String getArq1() {
		return arg1;
	}
	
	public String getArg2() {
		return arg2;
	}
	
	@Override
	public String toString() {
		return "binop(" + operador + ", " + result + ", " + arg1 + ", " + arg2 + ")";
	}
}
