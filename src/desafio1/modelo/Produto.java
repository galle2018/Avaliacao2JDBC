package desafio1.modelo;

public class Produto {	
	
	private String nome;
	private String descricao;
	private String desconto;
	private String dataInicio;
	private String dataFim;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Produto(String nome, String descricao, String desconto, String dataInicio, String dataFim) {
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;		
	}
	
	public String getNome() {		
		return nome;
	}
	public String getDescricao() {	
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

		
	// da formato a todos los String
	@Override
	public String toString() {
		//return String.format("O produto criado foi: %d, %s, %s", 
		return String.format("O produto criado é: %s, %s %s %s %s",//para listado
				this.nome, this.descricao, this.desconto, this.dataInicio, this.dataFim);
	}

	
}
