package classes;

public class Pessoa {
	
	//ATRIBUTOS
	protected int idPessoa;
	protected String CPF;
	protected String nomePessoa;
	protected String dataNascimento;
	protected String sexo;
	protected String email;
	protected String telefone;
	protected Endereco endereco;

	
	//CONSTRUTOR
	
	public Pessoa() {
		
	}
	
	public Pessoa( int idPessoa,  String CPF,  String nomePessoa,  String dataNascimento, 
			String sexo, String email, String telefone) {
		this.idPessoa = idPessoa;
		this.CPF = CPF;
		this.nomePessoa = nomePessoa;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		//this.endereco = endereco;
}

	
	//GETTERS AND SETTERS
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
