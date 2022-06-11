package it.unibs.esame;

import java.util.ArrayList;

public abstract class Ruolo{

	private String nome = "";
	private int vita = 5;
	private int attacco = 5;
	private int difesa = 5;
	private Arma arma;
	private Coordinate posizione;
	
	
	public Ruolo(String nome, int vita, Coordinate l) {
		this.nome = nome;
		this.vita = vita;
		this.posizione = l;
	}
	
	public Ruolo(String nome, int vita, int attacco) {
		this.nome = nome;
		this.vita = vita;
		this.attacco = attacco;
	}
	
	

	

	
	public Coordinate getPosizione() {
		return posizione;
	}

	public void setPosizione(Coordinate posizione) {
		this.posizione = posizione;
	}
	
	public void setPosizione(int r,  int c) {
		this.posizione.setRiga(r);
		this.posizione.setColonna(c);
	}

	public String getNome() {
		return nome;
	}

	public int getVita() {
		return vita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public int perdiVita(int meno) {
		vita -= meno;
		return vita;
	}
	
	public boolean isVivo() {
		if (vita <= 0)
			return false;
		else 
			return true;
	}
	
	public int getAttacco() {
		if (arma != null)
			return arma.getPotenza() * attacco;
		else 
			return attacco;
	}
	
	public int getDifesa() {
		return difesa;
	}
	
	public int colpo(Ruolo attaccante) {
		int atk = attaccante.getAttacco();
		int def = attaccante.getDifesa();
		double modificatore = 1;
		double casuale = Math.random();
		if (casuale > 0.075)
			modificatore = 1.5;
		
		return vita- (int) (((2*atk)/(25*def)) * modificatore);
		
	}
	
	
}
