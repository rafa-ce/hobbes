package analise.semantica.suporte;


public class Variavel {
	
	private String nome;
	private Integer quantidade;
	
	public Variavel(String nome) {
		this.setNome(nome);
		setQuantidade(1);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void incrementaContador() {
		quantidade++;		
	}

}
