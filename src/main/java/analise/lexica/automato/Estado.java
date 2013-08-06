package analise.lexica.automato;

public class Estado {
	
	private Integer id;
	private String nome;
	
	public Estado(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
