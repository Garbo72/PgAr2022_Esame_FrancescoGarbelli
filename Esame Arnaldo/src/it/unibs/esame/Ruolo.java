package it.unibs.esame;

public abstract class Ruolo implements Posizione{

	private String nome = "";
	private int vita = 5;
	private int attacco = 5;
	private int difesa = 5;
	private Posizione pos;
	private Arma arma;
	
	public Ruolo(String nome, int vita, Posizione pos) {
		super();
		this.nome = nome;
		this.vita = vita;
		this.pos = pos;
	}
	
	public Ruolo() {
		
	}
	
	
	public String getNome() {
		return nome;
	}

	public int getVita() {
		return vita;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public int perdiVita(int meno) {
		vita -= meno;
		return vita;
	}
	
	public boolean muovi(Mappa m) {
		if (m.libero)
			return true;
		else 
			return false;
	}
	
	
	
	
}
