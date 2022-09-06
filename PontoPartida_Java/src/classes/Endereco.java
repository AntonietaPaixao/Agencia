package classes;

public class Endereco {
	
	//ATRIBUTOS
	private int idEndereco;
	private String cidade;
	private String estadoUf;
	private String logradouro;
	private String bairro;
	private String numero;
	
	//CONTRUTORES
	public Endereco() {
		
	}
	public Endereco ( String cidade, String estadoUf, String logradouro, String bairro, String numero)
	{
		//this.idEndereco = idEndereco;
		this.cidade = cidade;
		this.estadoUf = estadoUf;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
	}
	
	//GETTERS AND SETTERS	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstadoUf() {
		return estadoUf;
	}
	public void setEstadoUf(String estadoUf) {
		this.estadoUf = estadoUf;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String lograduro) {
		this.logradouro = lograduro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}


}
