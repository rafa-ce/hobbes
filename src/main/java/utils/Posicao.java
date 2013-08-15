package utils;

public class Posicao {
	
	private Integer linha;
	private Integer coluna;
	
	public Posicao(Integer linha, Integer coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public Integer getLinha() {
		return linha;
	}
	
	public Integer getColuna() {
		return coluna;
	}
			
	@Override
	public String toString() {
		return getLinha() + " - " + getColuna();
	}

}
