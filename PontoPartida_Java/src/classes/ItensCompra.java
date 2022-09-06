package classes;

public class ItensCompra {
	
	//ATRIBUTOS
	private int idItensCompra;
	private PacotePartida pacotePartida;
	private Compra compra;
	
	//CONSTRUTORES	
	public ItensCompra() {
		
	};
	public ItensCompra(int idItensCompra, PacotePartida pacotePartida, Compra compra){
		this.idItensCompra=idItensCompra;
		this.pacotePartida = pacotePartida;
		this.compra = compra;
	}
	
	//GETTERS AND SETTERS	
	public int getIdItensCompra() {
		return idItensCompra;
	}
	public void setIdItensCompra(int idItensCompra) {
		this.idItensCompra = idItensCompra;
	}

	public PacotePartida getPacotePartida() {
		return pacotePartida;
	}

	public void setPacotePartida(PacotePartida pacotePartida) {
		this.pacotePartida = pacotePartida;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	

}
