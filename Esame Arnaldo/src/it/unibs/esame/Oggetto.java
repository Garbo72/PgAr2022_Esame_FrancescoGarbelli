package it.unibs.esame;

public abstract class Oggetto {
	
	
	private int potenza;
	private int vita;
	private double recupero;
	
	public Oggetto() {
		
	}

	public int getPotenza() {
		return potenza;
	}

	public void setPotenza(int potenza) {
		this.potenza = potenza;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public double getRecupero() {
		return recupero;
	}

	public void setRecupero(double d) {
		this.recupero = d;
	}

}
