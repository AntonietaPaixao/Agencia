package classes;


public class Compra {
	
	//ATRIBUTOS
	private int idCompra;
	private double valorCompra;
	private String dataCompra;
	private int quantPacotes;
	private Pessoa pessoa;
	
	//CONSTRUTORES
	public Compra() {};
	public Compra (int idCompra, double valorCompra, String dataCompra, int quantPacotes, Pessoa pessoa) {
		this.idCompra=idCompra;
		this.valorCompra=valorCompra;
		this.dataCompra = dataCompra;
		this.quantPacotes = quantPacotes;
		this.pessoa=pessoa;		
	}
		
	
	//GETTERS AND SETTERS	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getQuantPacotes() {
		return quantPacotes;
	}
	public void setQuantPacotes(int quantPacotes) {
		this.quantPacotes = quantPacotes;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
	
	
}
