package classes;

public class Partida {
	
	//ATRIBUTOS
	private int idPartida;
	private String data;
	private String nomeCampeonato;
	private String timeCasa;
	private String timeConvidado;
	
	//CONSTRUTOR
	public Partida() {};
	public Partida(int idPartida, String data, String nomeCampeonato, String timeCasa, String timeConvidado) {
		this.idPartida = idPartida;
		this.data = data;
		this.nomeCampeonato = nomeCampeonato;
		this.timeCasa = timeCasa;
		this.timeConvidado = timeConvidado;
	}
	
	//GETTERS AND SETTERS
	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public String getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(String timeCasa) {
		this.timeCasa = timeCasa;
	}

	public String getTimeConvidado() {
		return timeConvidado;
	}

	public void setTimeConvidado(String timeConvidado) {
		this.timeConvidado = timeConvidado;
	} 
	
	

}
