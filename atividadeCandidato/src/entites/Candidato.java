package entites;

public class Candidato {
	
	private String name;
	private int cod;
	private int votes;
	
	
	public Candidato(String name, int cod, int votes) {
		this.name = name;
		this.cod = cod;
		this.votes = votes;
	}

	public Candidato(String name, int cod) {
		this.name = name;
		this.cod = cod;
		votes = 0;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes += votes;
	}
	
	
	

}
